package cn.com.java.mode.prototype;

import org.junit.Test;

import java.io.*;

public class Main {

    @Test
    public void testShallow(){
        Prototype prototype = new Prototype();
        prototype.setField_int(1);
        prototype.setField_str("1");
        Prototype shallow = null;
        try {
            shallow = (Prototype) prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(shallow.equals(prototype));
        System.out.println(shallow.hashCode());
        System.out.println(prototype.hashCode());
        System.out.println(shallow.getField_int() == prototype.getField_int());
        System.out.println(shallow.getField_str() == prototype.getField_str());
    }

    @Test
    public void testDeep(){
        Prototype prototype = new Prototype();
        prototype.setField_int(2);
        prototype.setField_str("2");

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(baos);
            stream.writeObject(prototype);
            stream.flush();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Prototype deep = (Prototype)ois.readObject();

            System.out.println(deep == prototype);
            System.out.println(deep.hashCode());
            System.out.println(prototype.hashCode());

            System.out.println(deep.getField_int());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
