package com.nhatdang2604.main;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nhatdang2604.services.ThriftProfileService;
import com.nhatdang2604.services.ThriftProfileServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages="com.nhatdang2604")
public class RumApplication implements CommandLineRunner {

    @Autowired
    private ThriftProfileServiceImpl thriftProfileServiceImpl;

    @Value("${server.port}")
    private int port;

	public static void main(String[] args) {
		SpringApplication.run(RumApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        TServerTransport serverTransport = new TServerSocket(port); // Port to listen on
        ThriftProfileService.Processor<ThriftProfileService.Iface> processor = new ThriftProfileService.Processor<>(thriftProfileServiceImpl);
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("Starting Thrift server...");
        server.serve();
    }

}
