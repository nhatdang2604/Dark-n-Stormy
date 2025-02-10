package com.nhatdang2604.adapters;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nhatdang2604.services.ThriftProfileService;

@Component
public class ThriftAdapter {

    @Value("${thrift.server.host}")
    private String thriftServerHost;

    @Value("${thrift.server.port}")
    private int thriftServerPort;

    public String getProfile(String name) throws TTransportException {

        TTransport transport = new TSocket(thriftServerHost, thriftServerPort);

        try {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftProfileService.Client client = new ThriftProfileService.Client(protocol);
            
            return client.getProfile(name);
        } catch (TException e) {
            e.printStackTrace();
            return null;
        } finally {
            transport.close();
        }
    }
}
