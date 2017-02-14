package Clients;

import org.apache.thrift.TException;

import thrift.BookshoutAccountsService;
import thrift.User;

public class GatewayServiceClient implements BookshoutAccountsService.Iface{

	public User createUser(String email, String password) throws TException {
		AccountsRPCClient clnt = new AccountsRPCClient("localhost", 9090);
		thrift.User u = clnt.createUser(email, password);
		clnt.close();
		return u;
	}

	public User getUser(int id) throws TException {
		AccountsRPCClient clnt = new AccountsRPCClient("localhost", 9090);
		thrift.User u =  clnt.getUser(id);
		clnt.close();
		return u;
	}
	
	public static void main(String[] args) throws TException{
		GatewayServiceClient clnt = new GatewayServiceClient();
		System.out.println(clnt.getUser(2).getEmail());
	}

}
