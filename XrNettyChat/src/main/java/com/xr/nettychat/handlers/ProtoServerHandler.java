package com.xr.nettychat.handlers;

import com.xr.nettychat.protobuf.DataInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

public class ProtoServerHandler extends SimpleChannelInboundHandler<DataInfo.XrMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.XrMessage msg) throws Exception {

        DataInfo.XrMessage.MessageType messageType = msg.getMessageType();
        if (messageType == DataInfo.XrMessage.MessageType.StudentType) {
            DataInfo.Student student = msg.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAddress());
            System.out.println(student.getAge());
        } else if (messageType == DataInfo.XrMessage.MessageType.AddressType) {
            DataInfo.Address address = msg.getAddress();
            System.out.println(address.getAddrName());
            System.out.println(address.getAddrNo());
            System.out.println();
        } else if (messageType == DataInfo.XrMessage.MessageType.SchoolType) {
            DataInfo.School school = msg.getSchool();
            System.out.println(school.getName());
            System.out.println(school.getCity());
            System.out.println();

        } else {
            System.out.println("unsupported message Type: " + messageType);
        }
    }
}
