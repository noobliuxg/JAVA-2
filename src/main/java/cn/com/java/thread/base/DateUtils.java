package cn.com.java.thread.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtils {

    private static final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

    private static final ConcurrentHashMap<String,DateFormat> dateMap = new ConcurrentHashMap<>();


    public static DateFormat getDateFormat(String pattern){
        if (!dateMap.containsKey(pattern)){
            dateMap.put(pattern,new SimpleDateFormat(pattern));
        }
        DateFormat format = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"的DateFormat:"+format);
        if (format==null){
            format = dateMap.get(pattern);
            threadLocal.set(format);
        }
        return format;
    }

    public static String dateToStr(Date date,String pattern){
        return getDateFormat(pattern).format(date);
    }

    public static Date strToDate(String pattern,String string) throws ParseException {
        if (!dateMap.containsKey(pattern)){
            dateMap.put(pattern,new SimpleDateFormat(pattern));
        }
        return getDateFormat(pattern).parse(string);
    }


    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(dateToStr(new Date(),"yyyy-MM-dd"));
        },"t1").start();

        new Thread(()->{
            try {
                System.out.println(strToDate("yyyy-MM-dd","2019-03-19"));
                System.out.println(dateToStr(new Date(),"2019-03-19"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

}
