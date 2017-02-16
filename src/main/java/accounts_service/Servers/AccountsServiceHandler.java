package Servers;

import org.apache.thrift.TException;

import DBManagers.UserManager;
import thrift.BookshoutAccountsService;
import thrift.User;

public class AccountsServiceHandler implements BookshoutAccountsService.Iface{

	@Override
    public User createUser(String email, String password) throws TException {
		UserManager mgr = new UserManager();
		Domain.User newUser = mgr.create("", "", email);
		thrift.User ret = new thrift.User(newUser.getEmail());	
		return ret;
	}

	@Override
    public User getUser(int id) throws TException {
		UserManager mgr = new UserManager();
		thrift.User u = new thrift.User();
		Domain.User domainUser = mgr.find(id);
		u.setEmail(domainUser.getEmail());
		return u;
	}
}
