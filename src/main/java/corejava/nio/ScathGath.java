package corejava.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ScathGath {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        int messageLenge = 2 + 3 + 4;
        ByteBuffer[] bufferArr = new ByteBuffer[3];
        //定义不同长度的Buffer
        bufferArr[0] = ByteBuffer.allocate(3);
        bufferArr[1] = ByteBuffer.allocate(2);
        bufferArr[2] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLenge) {
                long read = socketChannel.read(bufferArr);
                byteRead += read;
                System.out.println("byteRead" + byteRead);
                Arrays.asList(bufferArr).stream().map(byteBuffer ->
                        "position" + byteBuffer.position() + "," + "limit" + byteBuffer.limit()
                ).forEach(System.out::println);

            }
            System.out.println(messageLenge);
            Arrays.asList(bufferArr).forEach(i -> i.flip());
            long byteWrite = 0;
            while (byteWrite < messageLenge) {
                long write = socketChannel.write(bufferArr);

                byteWrite += write;
            }
            Arrays.asList(bufferArr).forEach(byteBuffer -> byteBuffer.clear());
            System.out.println("byteRead:" + byteRead + "byteWrite:" + byteWrite + "messageLenge:" + messageLenge);
        }
    }
}