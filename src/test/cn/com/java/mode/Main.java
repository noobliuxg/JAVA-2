package cn.com.java.mode;

import cn.com.java.inner.Outer;
import cn.com.java.mode.chain.ContentRequestChain;
import cn.com.java.mode.chain.HeadRequest;
import cn.com.java.mode.chain.Request;
import cn.com.java.mode.chain.RequestChain;
import org.junit.Test;

public class Main {

    @Test
    public void test(){
        Request request = new Request();
        request.setHead("404");
        request.setContent("AABBCC");

        RequestChain requestChain = new HeadRequest(new ContentRequestChain());

        requestChain.handle(request);

        request.setHead("200");
        requestChain.handle(request);
    }
}
