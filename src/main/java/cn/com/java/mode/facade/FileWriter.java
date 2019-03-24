package cn.com.java.mode.facade;

public class FileWriter {

    public String write(String content){
        System.out.println("加密后的内容："+content);
        return new String("新的文件名");
    }
}
