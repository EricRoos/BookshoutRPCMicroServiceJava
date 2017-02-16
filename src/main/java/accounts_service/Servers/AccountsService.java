package Servers;
import org.apache.thrift.TProcessor;
import org.apache.thrift.transport.TTransportException;

import DBManagers.PromoManager;
import RPC.Servers.RPCServerBase;
import thrift.BookshoutAccountsService;

public class AccountsService extends RPCServerBase{

	@Override
	protected TProcessor getProcessor() {
		return new BookshoutAccountsService.Processor<BookshoutAccountsService.Iface>(new AccountsServiceHandler());
	}

	@Override
	protected void warmResources() {
		PromoManager.warm();		
	}
	
	public static void main(String[] args) throws TTransportException, InstantiationException, IllegalAccessException {
		RPCServerBase.start(AccountsService.class, 9090);
		
 	}
}
