package cn.com.java.io.base;

import java.io.*;
import java.net.URL;

public class FileMain {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("D:\\codes\\study\\idea\\JAVA\\src\\main\\java\\cn\\com\\java\\io\\base\\a.txt"));
            ByteArrayOutputStream bas = new ByteArrayOutputStream();
            for (;;){
                byte[] buffer = new byte[1024];
                int read = fis.read(buffer);
                if (read<=0){
                    break;
                }
                bas.write(buffer,0,read);
            }

            byte[] bytes = bas.toByteArray();
            System.out.println(new String(bytes));


            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

            FileOutputStream fos = new FileOutputStream(new File("D:\\codes\\study\\idea\\JAVA\\src\\main\\java\\cn\\com\\java\\io\\base\\d.txt"));

            byte[] buffer = new byte[1024];
            for (;;){
                int read = bis.read(buffer);
                if (read<=0){
                    break;
                }
                fos.write(buffer,0,read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
