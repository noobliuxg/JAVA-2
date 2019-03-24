package cn.com.java.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatch {

    public static void main(String[] args) {
        //创建Pattern正在解析器
        Pattern pattern = Pattern.compile("\\d+");

        //使用正在解析器解析字符串
        Matcher matcher = pattern.matcher("25DV3652AB");
        System.out.println(matcher.lookingAt());
        if (matcher.lookingAt()){//lookingAt()只匹配一次
            System.out.println(matcher.group());//匹配一次获取到的数字
        }
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            System.out.println(start+","+end+","+group);
        }


        pattern = Pattern.compile("\\d{9,11}@qq.com.cn");

        matcher = pattern.matcher("517099925@qq.com.cn刘新乖,52147526453@qq.com.cn留心");

        while (matcher.find()){
            System.out.println("邮件："+matcher.group());
        }

        String phoneRegex = "((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(18[0-9]))\\d{8}";
//        String phoneRegex = "\\d+";
        pattern = Pattern.compile(phoneRegex);

        String[] split = pattern.split("我的手机号码：15579124310,朋友的手机号码：13352535221");
        for (String str : split){
            System.out.println(str);
        }
//        matcher = pattern.matcher("我的手机号码：15579124310,朋友的手机号码：13352535221");
//        while (matcher.find()){
//            System.out.println("电话号码："+matcher.group());
//        }

//        while ()
    }
}
