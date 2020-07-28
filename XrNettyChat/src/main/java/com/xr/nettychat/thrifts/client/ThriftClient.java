package com.xr.nettychat.thrifts.client;

import com.xr.nettychat.thrifts.generated.Person;
import com.xr.nettychat.thrifts.generated.PersonService;
import com.xr.nettychat.thrifts.service.PersonServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) throws Exception {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8080), 600);
        TProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            tTransport.open();
            Person person = client.getPersonByUserName("kevin");
            System.out.println(person.getUesrname());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println();
            System.out.println("--------------------------");
            System.out.println();

            Person person2 = new Person();
            person2.setUesrname("kevin22");
            person2.setAge(32);
            person2.setMarried(true);
            client.savePerson(person2);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            tTransport.close();
        }
    }
}
