package com.xr.nettychat;

import com.google.protobuf.InvalidProtocolBufferException;
import com.xr.nettychat.protobuf.DataInfo;

public class MainStarter {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("kevin")
                .setAge(32).setAddress("huaxin").build();
        byte[] bytes = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student1);
        System.out.println();

    }
}
