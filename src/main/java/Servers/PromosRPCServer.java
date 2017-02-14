package Servers;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import ServiceHandlers.PromosServiceHandler;
import thrift.BookshoutPromosService;

import org.apache.thrift.server.TServer.Args;

public class PromosRPCServer {
	public static PromosServiceHandler handler;
	public static BookshoutPromosService.Processor<BookshoutPromosService.Iface> processor;
	
	public static void main(String[] args){
		handler = new PromosServiceHandler();
		processor = new BookshoutPromosService.Processor<BookshoutPromosService.Iface>(handler);
		Runnable simple = new Runnable(){
			public void run() {
				simple(processor);				
			}	
		};
		new Thread(simple).start();
	}
	public static void simple(BookshoutPromosService.Processor<BookshoutPromosService.Iface> processor){
	      TServerTransport serverTransport;
		try {
			serverTransport = new TServerSocket(9091);
		      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

		      // Use this for a multithreaded server
		      // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

		      System.out.println("Starting the simple server...");
		      server.serve();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
