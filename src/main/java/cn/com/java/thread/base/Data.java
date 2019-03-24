package cn.com.java.thread.base;

import java.util.LinkedList;
import java.util.List;

public class Data {

    private int index = 0;

    private List<String> datas = new LinkedList<String>();

    public int getDatas() {
        return datas.size();
    }

    public String addData(String data){
        datas.add(index,data);
        index++;
        return data;
    }

    public String removeData(){
        index--;
        String data = datas.remove(index);
        return data;
    }
}
