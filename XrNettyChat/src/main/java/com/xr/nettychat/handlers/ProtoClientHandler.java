package com.xr.nettychat.handlers;

import com.xr.nettychat.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.Random;

public class ProtoClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output: " + msg);
        ctx.writeAndFlush("from client: " + LocalDateTime.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Random random = new Random();
        int typeNo = random.nextInt(3);
        System.out.println("type No is: " + typeNo);
        DataInfo.XrMessage xrMessage = null;
        switch (typeNo) {
            case 0:
                xrMessage = DataInfo.XrMessage.newBuilder()
                        .setMessageType(DataInfo.XrMessage.MessageType.StudentType)
                        .setStudent(DataInfo.Student.newBuilder().setName("kevin")
                                .setAge(32).setAddress("huaxin").build()).build();
                break;
            case 1:
                xrMessage = DataInfo.XrMessage.newBuilder()
                        .setMessageType(DataInfo.XrMessage.MessageType.AddressType)
                        .setAddress(DataInfo.Address.newBuilder().setAddrName("shanghai")
                                .setAddrNo(32).build()).build();
                break;
            case 2:
                xrMessage = DataInfo.XrMessage.newBuilder()
                        .setMessageType(DataInfo.XrMessage.MessageType.SchoolType)
                        .setSchool(DataInfo.School.newBuilder().setName("QinHua")
                                .setCity("Beijin").build()).build();
                break;
        }

        ctx.writeAndFlush(xrMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
