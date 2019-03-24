package cn.com.java.io.base;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadRandomAcessFile {


    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("d:/a.txt","rw");
            Person person = null;
//            Person person = new Person(2,"刘新乖",175.5d);
//            raf.seek(raf.length());
//            raf.writeInt(person.getId());
//            raf.writeUTF(person.getName());
//            raf.writeDouble(person.getHeight());
//            raf.seek(0);
            person = new Person(raf.readInt(),raf.readUTF(),raf.readDouble());
            System.out.println(person);


            raf = new RandomAccessFile("d:/out.txt","rw");
            raf.seek(raf.length());
//            raf.write("\r\n中国移动阅读基地".getBytes());
//            raf.seek(raf.length());
            raf.write("2536".getBytes());
            raf.seek(0);
            raf.write("sdfs".getBytes());
            raf.seek(0);
            byte[] buff = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (;;){
                int read = raf.read(buff);
                if (read<=0) break;
                bos.write(buff,0,read);
            }
            System.out.println(new String(bos.toByteArray()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   static class Person{
        private int id;
        private String name;
        private Double height;

        public Person(int id, String name, Double height) {
            this.id = id;
            this.name = name;
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

       @Override
       public String toString() {
           return "Person{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", height=" + height +
                   '}';
       }
   }
}
