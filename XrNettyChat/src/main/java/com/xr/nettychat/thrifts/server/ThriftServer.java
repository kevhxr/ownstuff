package com.xr.nettychat.thrifts.server;

import com.xr.nettychat.thrifts.generated.PersonService;
import com.xr.nettychat.thrifts.service.PersonServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServer {
    public static void main(String[] args) throws Exception {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8080);
        THsHaServer.Args args1 = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        args1.protocolFactory(new TCompactProtocol.Factory());
        args1.transportFactory(new TFramedTransport.Factory());
        args1.processorFactory(new TProcessorFactory(processor));

        TServer tServer = new THsHaServer(args1);
        System.out.println("Thrift server started!!");
        tServer.serve();
    }
}
