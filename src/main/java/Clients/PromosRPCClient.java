package Clients;


import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


import thrift.BookshoutPromosService;
import thrift.Promo;
import thrift.PromoCode;

public class PromosRPCClient implements BookshoutPromosService.Iface{
	private TTransport transport;
	private BookshoutPromosService.Client clnt;
	
	public PromosRPCClient(String host, int port) throws TTransportException{
		transport = new TSocket(host, port);
		transport.open();
		TProtocol protocol = new  TBinaryProtocol(transport);
		clnt = new BookshoutPromosService.Client(protocol);	
	}
	
	public void close(){
		transport.close();
	}
	
	@Override
	public Promo getPromo(int id) throws TException {
		return clnt.getPromo(id);
	}

	@Override
	public PromoCode createCode(Promo promo) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromoCode> getPromoCodes(Promo promo) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
