package test.netty.netty01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap boot = new Bootstrap(); // (1)
            boot.group(workerGroup); // (2)
            boot.channel(NioSocketChannel.class); // (3)
            boot.handler(new ChannelInitializer<SocketChannel>() {// (4)
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });
            ChannelFuture future = boot.connect(host, port).sync(); // (5)
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
