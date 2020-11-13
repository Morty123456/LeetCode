package aa;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class test2 {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        out.write("写入了数据");

        new Thread(()->{
            try {
                System.out.println("新的线程");
                System.out.println(in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
