package cn.com.java.structure;


import java.util.Arrays;

/**
 * 栈：
 *      特点：
 *          先进后出
 *      原理：
 *          只能在栈顶的一段入栈和出栈,即：只能在线性表的一段放入元素和取出元素
 * @param <T>
 */
public class Stack<T> {

    private Object[] objArray;

    private int capacity = 10;

    private int index = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
        objArray = new Object[capacity];
    }

    /**
     * 出栈
     */
    public T pop(){
        if (index>0){
            return (T)objArray[--index];
        }
        throw new RuntimeException("栈顶没有元素");
    }


    /**
     * 入栈
     */
    public void push(T t){
        if (index>=capacity){
            objArray = Arrays.copyOf(objArray, capacity * 2);
        }
        objArray[index++]=t;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(3);
        stack.push("liuxg");
        stack.push("你好");
        stack.push("很帅");
        stack.push("AA");
        stack.push("BB");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
