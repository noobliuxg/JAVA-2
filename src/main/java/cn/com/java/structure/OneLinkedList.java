package cn.com.java.structure;

public class OneLinkedList<E> {

    private int size;
    private Node head;

    public void addHead(E e){
        Node newNode = new Node(e);
        if (size == 0) {
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public E removeFrist(){
        if (size<=0) return null;
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public boolean remove(E e){
        if (size<=0) return false;
        Node current = head;
        Node previous = head;
        while (current.data != e){
            if (current.next == null){
                return false;
            }
            previous = current;
            current = current.next;
        }

        if (current == head){
            head = head.next;
        }else{
            previous.next = current.next;
        }
        size--;
        return true;
    }

    public void println(){
        if (size>0){
            int index = size;
            Node current = head;
            while (index>0){
                if (current == head){
                    System.out.print("["+current.data+"->");
                }else if(current.next == null){
                    System.out.print(current.data+"]");
                }else{
                    System.out.print(current.data+"->");
                }
                current = current.next;
                index--;
            }
        }else {
            System.out.println("[]");
        }
    }

    private class Node{
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        OneLinkedList<String> list = new OneLinkedList<>();

        list.addHead("01");
        list.addHead("02");
        list.addHead("03");
        list.addHead("04");
        list.println();
        list.remove("02");
        System.out.println();
        list.println();
        list.removeFrist();
        System.out.println();
        list.println();
    }
}
