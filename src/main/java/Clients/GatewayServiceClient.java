package Clients;

import java.util.List;

import org.apache.thrift.TException;

import thrift.BookshoutAccountsService;
import thrift.BookshoutPromosService;

import thrift.Promo;
import thrift.PromoCode;
import thrift.User;

public class GatewayServiceClient implements BookshoutAccountsService.Iface, 
											BookshoutPromosService.Iface
											
{
	@Override
	public User createUser(String email, String password) throws TException {
		AccountsRPCClient clnt = new AccountsRPCClient("localhost", 9090);
		thrift.User u = clnt.createUser(email, password);
		clnt.close();
		return u;
	}
	@Override
	public User getUser(int id) throws TException {
		AccountsRPCClient clnt = new AccountsRPCClient("localhost", 9090);
		thrift.User u =  clnt.getUser(id);
		clnt.close();
		return u;
	}

	@Override
	public Promo getPromo(int id) throws TException {
		PromosRPCClient clnt = new PromosRPCClient("localhost", 9091);
		thrift.Promo p = clnt.getPromo(id);
		clnt.close();
		return p;
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
