package cn.com.java.structure;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 队列：
 *      特点：先进先出
 *      原理：在队列的一段插入，一段取出，即：在线性表的右边插入数据，在线性表的左边取出数据
 * @param <T>
 */
public class Queue<T> {
    private int capacity = 10;

    private int right = 0;

    private int left = 0;

    private Object[] objArray;

    public Queue() {
        objArray = new Object[capacity];
    }

    public Queue(int capacity){
        this.capacity = capacity;
        objArray = new Object[capacity];
    }

    public T pop(){
        if (left<right) {
            return (T)objArray[left++];
        }
        if (left==right){
            left=right=0;
        }
        throw new RuntimeException("队列中没有元素");
    }

    public void push(T t){
        if (right<capacity)
            objArray[right++] = t;
        else
            Arrays.copyOf(objArray,capacity*2);
    }

    public int getRight(){
        return right;
    }

    public int getLeft(){
        return left;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        for (int i=0;i<5;i++){
            queue.push(i);
        }
        System.out.println("right : "+queue.getRight()+",left : "+queue.getLeft());
        for (int i=0;i<6;i++){
            try {
                System.out.println(queue.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("right : "+queue.getRight()+",left : "+queue.getLeft());
        queue.push(1);
        System.out.println("right : "+queue.getRight()+",left : "+queue.getLeft());
    }
}
