package test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggerTest {

    public static Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args){
        logger.error("chen");
    }

    public void proxyTest(){
        TestProxy testProxy=new TestProxy();
        DynamicProxyHandler handler=new DynamicProxyHandler();
        ITest test=(ITest)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                testProxy.getClass().getInterfaces(),
                handler);

    }

    class TestProxy implements ITest{


        public void test() {

        }
    }
    static class DynamicProxyHandler implements InvocationHandler{
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    interface ITest{
        void test();
    }
}
