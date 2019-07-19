package jvmlearn;

/**
 *
 * 控制台查看GC： java -verbose:gc GCTest.java
 * 或者 -XX:+PrintGCDetails -Xloggc:./log/gclogs
 * 在项目主文件夹下生成gclogs文件
 * <pre>
 * [0.004s][info][gc] Using G1
 * [0.456s][info][gc] GC(0) Pause Full (System.gc()) 24M->3M(60M) 3.712ms
 * </pre>
 * @author chen
 */
public class GCTest {
    Object instance=null;
    private byte[] bigSize=new byte[2*1024*1024];
    public static void main(String[] args){

        GCTest gcTest=new GCTest();
        GCTest gcTest1=new GCTest();
        gcTest.instance=gcTest1;
        gcTest1.instance=gcTest;

        gcTest=null;
        gcTest1=null;

        System.gc();
    }
    private static void testGC(){

    }
}
