package cn.com.java.mode.facade;

public class FileReader {

    public String read(String fileName){
        System.out.println("读取文件名为："+fileName+"中的附件信息");
        return new String("文件内容");
    }

}
