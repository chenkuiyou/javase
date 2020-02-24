package DateAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 *
 * jdk8之前的方法
 *
 * 1System的静态方法 System.currentTimeMillis()
 *
 *  java.util.Date类 和 java.sql.Date （前者是后者的父类）
 *  2在未和数据库交互的时候使用java.util.Date
 *  3java.sql.Date是对应数据库中的Date
 *
 *  4SimpleDateFormat
 *  5 Calender (抽象类)
 *      1.实例化 创建其子类的对象（不常用）
 *      2.调用静态方法
 *
 * @author cky
 * @create 2020 2 16 16:41
 */
public class DateText {
    public static void main(String[] args) {

        //1.System的静态方法
        // 获得1970年初 到现在的毫秒时间差  称为时间戳
        long time =System.currentTimeMillis();
        System.out.println(time);

        //2.java.util.Date 的两个方法
        Date date=new Date();
        System.out.println(date.getTime()); //1581843374279

        //输出使用
        System.out.println(date.toString());//Sun Feb 16 16:52:34 CST 2020

        //3java.sql.Date 的创建 ，需要一个时间戳
        java.sql.Date date2=new java.sql.Date(1581843154394L);

        System.out.println(date2);//2020-02-16

        //将java.util.Date 转换成java.sql.Date
        Date date7=new Date();
        java.sql.Date date10=new java.sql.Date(date7.getTime());
        System.out.println(date10);

        //4.SimpleDateFormat
        // 4.1对Date进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date8=new Date();
        System.out.println(date8);  //Sun Feb 16 17:19:15 CST 2020
        String format=sdf.format(date8);
        System.out.println(format);  //20-2-16 下午5:19
        //4.2 解析  将字符串解析为日期
        Date date15=null;
        try {
            date15=sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date15);
        //还可以设置SimpleDateFormat 的格式  可以从api中去查
        SimpleDateFormat sdf1 = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\"");
        String format1=sdf1.format(date8);
        System.out.println(format1);
        try {
            date15=sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date15);

        //5.Calender
        //实例化调用 Calender的静态方法

        Calendar calender= Calendar.getInstance();
        //常用方法
        //get（）
        int day=calender.get(Calendar.DAY_OF_MONTH);  //获取这个月的第几天
        System.out.println(day);
        System.out.println(calender.get(Calendar.DAY_OF_YEAR)); //这一年的第几天
        //set()  感觉用不到
        calender.set(Calendar.DAY_OF_MONTH,15);
        System.out.println(calender.get(Calendar.DAY_OF_MONTH));
        //add()
        calender.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(calender.get(Calendar.DAY_OF_MONTH));
        //getTime();
        System.out.println(calender.getTime());
        //setTime();
        Date date18=new Date();
        calender.setTime(date18);
        System.out.println(calender.getTime());


    }
}
