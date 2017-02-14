package ServiceHandlers;

import org.apache.thrift.TException;

import DBManagers.UserManager;
import thrift.BookshoutAccountsService;
import thrift.User;

public class AccountsServiceHandler implements BookshoutAccountsService.Iface{

	public User createUser(String email, String password) throws TException {
		UserManager mgr = new UserManager();
		Domain.Accounts.User newUser = mgr.create("", "", email);
		thrift.User ret = new thrift.User(newUser.getEmail());	
		mgr.close();
		return ret;
	}

	public User getUser(int id) throws TException {
		UserManager mgr = new UserManager();
		thrift.User u = new thrift.User();
		Domain.Accounts.User domainUser = mgr.find(id);
		u.setEmail(domainUser.getEmail());
		mgr.close();
		return u;
	}
	
	public static void main(String[] args) throws TException{
		AccountsServiceHandler hndlr = new AccountsServiceHandler();
		System.out.println(hndlr.getUser(2));
	}
}
