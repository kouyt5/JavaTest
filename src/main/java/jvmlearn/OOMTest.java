package jvmlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/7/19.
 */
public class OOMTest {
    private byte[] bytes = new byte[64 * 1024];

    public static void main(String[] args) {
        List<OOMTest> list = new ArrayList<OOMTest>();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(50);
                    list.add(new OOMTest());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.gc();
            }
        }
    }
}
