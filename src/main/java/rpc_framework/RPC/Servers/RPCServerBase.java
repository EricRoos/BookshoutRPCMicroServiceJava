package RPC.Servers;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public abstract class RPCServerBase {

	public void start(int port) throws TTransportException {
		TServerTransport serverTransport;
		serverTransport = new TServerSocket(port);
		TServer server = new TSimpleServer(new Args(serverTransport).processor(getProcessor()));
		warmResources();
		Runnable simple = new Runnable(){
			public void run() {
				server.serve();				
			}	
		};
		new Thread(simple).start();
		
	}
	
	public static void start(Class<? extends RPCServerBase> server, int port) throws TTransportException, InstantiationException, IllegalAccessException {
		server.newInstance().start(port);
	}
	protected abstract org.apache.thrift.TProcessor getProcessor();
	protected abstract void warmResources();
	
}
