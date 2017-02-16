package Clients;


import org.apache.thrift.TException;

import RPC.Clients.RPCClientBase;
import thrift.BookshoutPromosService;
import thrift.EntityList;
import thrift.Promo;
import thrift.PromoCode;


public class PromosRPCClient extends RPCClientBase implements BookshoutPromosService.Iface{
	
	public PromosRPCClient(String host, int port) throws Exception {
		super(BookshoutPromosService.Client.class, host, port);
	}

	
	@Override
	public Promo getPromo(int id) throws TException {
		return getClient().getPromo(id);
	}

	@Override
	public PromoCode createCode(Promo promo) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityList getPromoCodes(Promo promo) throws TException {
		return getClient().getPromoCodes(promo);
	}

	public BookshoutPromosService.Client getClient(){
		return (BookshoutPromosService.Client)clnt;
	}

}
