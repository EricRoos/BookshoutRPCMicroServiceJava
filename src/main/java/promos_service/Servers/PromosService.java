package Servers;

import org.apache.thrift.TProcessor;
import org.apache.thrift.transport.TTransportException;

import DBManagers.PromoManager;
import RPC.Servers.RPCServerBase;
import thrift.BookshoutPromosService;

public class PromosService extends RPCServerBase {

    @Override
    protected TProcessor getProcessor() {
        return new BookshoutPromosService.Processor<BookshoutPromosService.Iface>(new PromosServiceHandler());
    }

    @Override
    protected void warmResources() {
        PromoManager.warm();
    }

}
