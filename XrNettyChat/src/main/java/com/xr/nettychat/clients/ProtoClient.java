package com.xr.nettychat.clients;

import com.xr.nettychat.initializers.ProtoClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProtoClient {

    public static void main(String[] args) throws Exception {

        EventLoopGroup loopGroup = new NioEventLoopGroup();

        try {
            Bootstrap clientBoot = new Bootstrap();
            clientBoot.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ProtoClientInitializer());

            ChannelFuture channelFuture = clientBoot.connect("localhost", 8080).sync();
            channelFuture.channel().closeFuture().sync();

/*            Channel channel = clientBoot.connect("localhost", 8080).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }*/
        } finally {
            loopGroup.shutdownGracefully();
        }
    }

}
