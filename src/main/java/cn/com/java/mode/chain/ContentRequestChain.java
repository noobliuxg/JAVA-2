package cn.com.java.mode.chain;

public class ContentRequestChain extends RequestChain{

    @Override
    public void handle(Request request) {
        if (request!=null && "AA".equals(request.getContent())){
            System.out.println("request of content containt AA return now");
        }else{
            System.out.println("this request is safed");
        }
    }
}
