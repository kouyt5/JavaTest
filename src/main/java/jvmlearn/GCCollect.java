package jvmlearn;

/**
 * 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvovorRatio=8
 *
 * 指定大于4M的对象直接分配到老年区中 -XX:PretenureSizeThreshold=4194304
 *
 * 限制年龄 -XX:MaxTenuringThreshold=1
 * @author chen
 *
 */
public class GCCollect {

    private static final int SIZE=1024*1024;

    public static void main(String[] args) {
        byte[] b1,b2,b3,b4,b5,b6,b7,b8,b9;
        b1=new byte[(int)(0.9*SIZE)];
        b3=new byte[4*SIZE];
        System.out.println("first gc beginning");
        b4=new byte[3*SIZE];
        b5=new byte[4*SIZE];
        b4=null;

        b6=new byte[1*SIZE];
//        System.out.println("second gc beginning");
//        b7=new byte[(int)(1*SIZE)];
        //b8=new byte[(int)(0.3*SIZE)];
        //b9=new byte[(int)(0.1*SIZE)];
    }

}
