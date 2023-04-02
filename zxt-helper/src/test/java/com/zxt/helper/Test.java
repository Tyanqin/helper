package com.zxt.helper;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/25
 */
public class Test {

    public static void main(String args[]) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("D:\\a\\变压器全过程技术监督精益化管理实施细则1121.xlsx");//开启文件读取流
//        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);//读取文件
//        //获取sheet
//        XSSFSheet sheet = sheets.getSheet("table1");
////        sheets.getNumberOfSheets();//获取sheet的数量，如果有多个sheet，可以使用for
//        List<Object> list = new ArrayList<>();
//        //获取行数
//        int rows = sheet.getPhysicalNumberOfRows();
        Test1();
    }

        public static void Test1()throws IOException {
            //加载PDF文档
            PdfDocument pdf = new PdfDocument();
            pdf.loadFromFile("D:\\a\\b\\2.电压互感器全过程技术监督精益化管理实施细则.pdf");
            //创建StringBuilder类的实例
            StringBuilder builder = new StringBuilder();
            //抽取表格
            PdfTableExtractor extractor = new PdfTableExtractor(pdf);
            PdfTable[] tableLists ;
            for (int page = 0; page < pdf.getPages().getCount(); page++) {
                tableLists = extractor.extractTable(page);
                if (tableLists != null && tableLists.length > 0) {
                    for (PdfTable table : tableLists) {
                        int row = table.getRowCount();
                        int column = table.getColumnCount();
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < column; j++) {
                                String text = table.getText(i, j);
                                System.out.println(("i:" + i + "====>j:" + j + "====>>>>  " + text.toString()));
                                builder.append(text+" ");
                            }
                            builder.append("\r\n");
                        }
                    }
                }
            }

            //将提取的表格内容写入txt文档
            FileWriter fileWriter = new FileWriter("D:\\a\\orc.txt");
            fileWriter.write(builder.toString());
            fileWriter.flush();
            fileWriter.close();
        }






}
