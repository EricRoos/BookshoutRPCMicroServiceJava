package Servers;
import org.apache.thrift.TProcessor;
import org.apache.thrift.transport.TTransportException;

import DBManagers.PromoManager;
import RPC.Servers.Base;
import thrift.BookshoutPromosService;

public class PromosService extends Base{

	@Override
	protected TProcessor getProcessor() {
		return new BookshoutPromosService.Processor<BookshoutPromosService.Iface>(new PromosServiceHandler());
	}

	@Override
	protected void warmResources() {
		PromoManager.warm();		
	}
	
	public static void main(String[] args) throws TTransportException, InstantiationException, IllegalAccessException {
		Base.start(PromosService.class, 9091);
	}
	
}
