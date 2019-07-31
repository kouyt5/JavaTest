package test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggerTest {

    public static Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args){
        logger.debug("chen");
        new LoggerTest().proxyTest();
    }

    public void proxyTest(){
        TestProxy testProxy=new TestProxy();
        DynamicProxyHandler handler=new DynamicProxyHandler(testProxy);
        ITest test=(ITest)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                testProxy.getClass().getInterfaces(),
                handler);
        test.test();

    }

    class TestProxy implements ITest{


        @Override
        public void test() {
            System.out.println("running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class DynamicProxyHandler implements InvocationHandler{
        private ITest iTest;
        public DynamicProxyHandler(ITest iTest){
            this.iTest=iTest;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke start");
            method.invoke(iTest,args);
            System.out.println("invoke end");
            return null;
        }
    }

    interface ITest{
        void test();
    }
}
