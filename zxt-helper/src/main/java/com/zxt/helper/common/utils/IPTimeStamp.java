package com.zxt.helper.common.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author:TanXiao
 * @date:2023/3/23
 */
@Component
public class IPTimeStamp {

    private SimpleDateFormat sdf=null;
    private String ip="100000";
    //    public IPTimeStamp(String ip){
//        this.ip=ip;
//
//    }
    public String getDate(){
        this.sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return this.sdf.format(new Date());
    }
    public  String getTimeStamp() {
        this.sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return this.sdf.format(new Date());
    }
    private String addZero (String str,int len){
        StringBuffer s=new StringBuffer();
        s.append(str);
        while(s.length()<len){
            s.insert(0,"0");

        }
        return s.toString();
    }

    public String getIPTimeRand(){
        StringBuffer buf =new StringBuffer();
        if(this.ip!=null){
            String[] s=this.ip.split("\\.");
            for (int i = 0; i < s.length; i++) {
                buf.append(this.addZero(s[i], 3));
            }
        }
        buf.append(this.getTimeStamp());
        Random r= new Random();
        for (int i = 0; i < 3; i++) {
            buf.append(r.nextInt(10));
        }
        return buf.toString();
    }

    public static String getDateTimeNow(){
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


}
