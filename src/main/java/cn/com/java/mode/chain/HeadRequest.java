package cn.com.java.mode.chain;

public class HeadRequest extends RequestChain{

    public HeadRequest(RequestChain chain){
        this.requestChain = chain;
    }

    @Override
    public void handle(Request request) {
        if (request!=null && "404".equals(request.getHead())){
            System.out.println("request of head is "+request.getHead()+" return ");
        }else {
            this.requestChain.handle(request);
        }
    }
}
