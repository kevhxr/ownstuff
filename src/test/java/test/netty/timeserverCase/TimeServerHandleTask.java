package test.netty.timeserverCase;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServerHandleTask implements Runnable {

    SocketChannel socketChannel;

    public TimeServerHandleTask(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer requestBuffer = ByteBuffer.allocate("GET CURRENT TIME".length());
            //尝试读取数据，因为是非阻塞，所以如果没有数据会立即返回。
            int bytesRead = socketChannel.read(requestBuffer);
            //如果没有读取到数据，说明当前SocketChannel并没有发送请求，不需要处理
            if (bytesRead <= 0) {
                return;
            }
            while (requestBuffer.hasRemaining()) {
                socketChannel.read(requestBuffer);
            }
            String requestStr = new String(requestBuffer.array());
            if (!"GET CURRENT TIME".equals(requestStr)) {
                String bad_request = "Bad_request";
                ByteBuffer responseBuffer = ByteBuffer.allocate(bad_request.length());
                responseBuffer.put(bad_request.getBytes());
                responseBuffer.flip();
                socketChannel.write(responseBuffer);
            } else {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStr = format.format(new Date());
                System.out.println(timeStr);
                ByteBuffer responseBuffer = ByteBuffer.allocate(timeStr.length());
                responseBuffer.put(timeStr.getBytes());
                responseBuffer.flip();
                socketChannel.write(responseBuffer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
