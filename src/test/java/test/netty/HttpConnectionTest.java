package test.netty;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;


/**
 * 向一个通道中传indirect ByteBuffer (wrap()) for writing
 * 通道可能会在每次调用中隐含地进行下面的操作
 *
 * 1.   创建一个临时的direct ByteBuffer 对象 (ByteBuffer.allocateDirect())。
 * 2.   将indirect缓冲区的内容复制到临时缓冲中。
 * 3.   使用临时缓冲区执行低层次 I/O 操作。
 * 4.   临时缓冲区对象离开作用域，并最终成为被回收的无用数据。
 *
 *
 *
 *
 * 读数据通过内核空间到用户空间，往外写数据通过用户空间到内核空间。JVM堆栈属于用户空间。 直接缓冲区就是内核空间的内存。
 * Netty的零拷贝(计算机在网络上发送文件时，不需将文件内容拷贝到用户空间而直接在内核空间中传输到网络的方式)，就是用了直接缓冲区。
 */
public class HttpConnectionTest {
    public static void main(String[] args) throws Exception {
        String hellow = "hellow";
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(hellow.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println("======================");
        buffer.flip();
        int readNum = 0;
        System.out.println(buffer.position() + " " + buffer.limit());
        while (readNum++ < 2 && buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        System.out.println();
        System.out.println("=======after read===============");
        System.out.println(buffer.position() + " " + buffer.limit());
        buffer.compact();
        System.out.println("=======after compact===============");
        System.out.println(buffer.position() + " " + buffer.limit());
        //buffer.flip();
        System.out.println("=======after flip2===============");
        System.out.println(buffer.position() + " " + buffer.limit());
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        System.out.println("======================");
        System.out.println(buffer.position() + " " + buffer.limit());
    }

    @Test
    public void duplicateBufferTest() {
        CharBuffer buffer = CharBuffer.allocate(118);
        //buffer.position(3).limit(6).mark().position(5);
        CharBuffer dupeBuffer = buffer.duplicate();
        buffer.clear();

        buffer.put("sdasd");
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
        System.out.println("-----------");
        CharBuffer charBuffer = buffer.asReadOnlyBuffer();
        charBuffer.put("sadsadsad");
    }
}
