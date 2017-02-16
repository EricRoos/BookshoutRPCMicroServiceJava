package RPC.Clients;

import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class RPCClientBase {
	private TTransport transport;
	protected TServiceClient clnt;
	public RPCClientBase(Class<? extends org.apache.thrift.TServiceClient> clazz, String host, int port) throws Exception {
		transport = new TSocket(host, port);
		transport.open();
		TProtocol protocol = new  TBinaryProtocol(transport);
		clnt = clazz.getConstructor(TProtocol.class).newInstance(protocol);
	}
	
	
	public void close(){
		transport.close();
	}
}
