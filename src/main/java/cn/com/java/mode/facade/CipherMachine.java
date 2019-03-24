package cn.com.java.mode.facade;

public class CipherMachine {


    public String doFinal(String content){
        System.out.println("要进行加密的内容："+content);
        return new String("加密"+content);
    }
}
