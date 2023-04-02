package com.zxt.helper.common.utils;

import com.zxt.helper.Annotation.ExcelAttribute;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
public class ExcelExportUtil<T> {
    /*
    写入数据的起始行
     */
    private int rowIndex;
    /*
    需要提取的样式所在的行号
     */
    private int styleIndex;
    /*
     对象的字节码
     */
    private Class clazz;
    /*
    对象中的所有属性
     */
    private Field fields[];

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getStyleIndex() {
        return styleIndex;
    }

    public void setStyleIndex(int styleIndex) {
        this.styleIndex = styleIndex;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public ExcelExportUtil(Class clazz, int rowIndex, int styleIndex) {
        this.clazz = clazz;
        this.rowIndex = rowIndex;
        this.styleIndex = styleIndex;
        fields = clazz.getDeclaredFields();
    }


    public void export(HttpServletResponse response, InputStream is, List<T> objs, String fileName) throws Exception {
        //1.根据模板创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        //2.读取工作表
        Sheet sheet = workbook.getSheetAt(0);
        //3.提取公共的样式
        Row row1 = sheet.getRow(styleIndex);
        CellStyle[] styles = getTemplateStyles(row1);
        //4.根据数据创建每一行和每一个单元格的数据2
        AtomicInteger datasAi = new AtomicInteger(rowIndex); //数字
        for (T t : objs) {
            //datasAi.getAndIncrement()  ：获取数字，并++    i++
            Row row = sheet.createRow(datasAi.getAndIncrement());
            for(int i=0;i<styles.length;i++) {
                Cell cell = row.createCell(i);
                cell.setCellStyle(styles[i]);
                for (Field field : fields) {
                    if(field.isAnnotationPresent(ExcelAttribute.class)){
                        field.setAccessible(true);
                        ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
                        //如果当前i的值和 属性上注解的 sort值一致就反射调用它的get方法,也就时 当 i=0时就会找属性上注解为0的属性值写入其值
                        if(i == ea.sort()) {
                            if(field.get(t) != null) {
                                cell.setCellValue(field.get(t).toString());
                            }
                        }
                    }
                }
            }
        }
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("ISO8859-1")));
        response.setHeader("filename", fileName);
        workbook.write(response.getOutputStream());
    }










    public CellStyle[] getTemplateStyles(Row row) {
        CellStyle [] styles = new CellStyle[row.getLastCellNum()];
        for(int i=0;i<row.getLastCellNum();i++) {
            styles[i] = row.getCell(i).getCellStyle();
        }
        return styles;
    }

}
