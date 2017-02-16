import org.apache.thrift.transport.TTransportException;

import RPC.Servers.RPCServerBase;
import Servers.PromosService;

public class PromoServiceDriver {

    public static void main(String[] args) throws TTransportException, InstantiationException, IllegalAccessException {
        RPCServerBase.start(PromosService.class, 9091);
        
    }

}
