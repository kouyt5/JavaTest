package jvmlearn;

public class StringTest {

    public static void main(String[] args){
        testString();


    }

    public static void testString(){
        String s="java";
        String s1=new StringBuilder("ja").append("va").toString();
        //false 想想为什么
        System.out.println(s1.intern()==s1);
    }

}
