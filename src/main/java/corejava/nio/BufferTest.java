package corejava.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.put("12345".getBytes());
/*        byte[] bytes1 = new byte[buffer.limit()];
        buffer.get(bytes1);
        System.out.println(bytes1.toString());*/
        System.out.println("put------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.flip();
        System.out.println("flip------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes));
        System.out.println("get------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.clear();
        System.out.println("clear------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());


        String rr = "rrrr";
        for (int i = 0; i < rr.length(); i++) {

        }
        buffer.put(5,"rrrrrr".getBytes()[0]);
        System.out.println("put2------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.flip();
        System.out.println("flip2------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.clear();
        System.out.println("clear------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        byte[] bytes2 = new byte[buffer.limit()];
        buffer.get(bytes2);
        System.out.println(new String(bytes2));
    }

    @Test
    public void swapBuf(){
        int n = 16;
        System.out.println(n);
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("bc".getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        buffer.clear();
        int position = buffer.position();
        buffer.mark();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        byte c1 = buffer.get();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        byte c2 = buffer.get();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        buffer.reset();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("=======flip=========");
        buffer.put(c2).put(c1);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("=======get=========");
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        System.out.println(new String(bytes));

        System.out.println(position);
        buffer.position(position);

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
        buffer.clear();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("================");
    }
}
