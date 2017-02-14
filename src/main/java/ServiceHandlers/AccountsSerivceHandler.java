package ServiceHandlers;

import org.apache.thrift.TException;

import DBManagers.UserManager;
import thrift.BookshoutAccountsService;
import thrift.User;

public class AccountsSerivceHandler implements BookshoutAccountsService.Iface{

	public User createUser(String email, String password) throws TException {
		UserManager mgr = new UserManager();
		Domain.User newUser = mgr.create("", "", email);
		thrift.User ret = new thrift.User(newUser.getEmail());	
		mgr.close();
		return ret;
	}

	public User getUser(int id) throws TException {
		System.out.println("Getting user with id : " +id);
		UserManager mgr = new UserManager();
		thrift.User u = new thrift.User();
		Domain.User domainUser = mgr.find(id);
		System.out.println("Found user:" + domainUser);
		u.setEmail(domainUser.getEmail());
		mgr.close();
		return u;
	}
	
	public static void main(String[] args) throws TException{
		AccountsSerivceHandler hndlr = new AccountsSerivceHandler();
		System.out.println(hndlr.getUser(2));
	}
}
