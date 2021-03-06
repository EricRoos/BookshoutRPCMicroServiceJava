package Clients;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import thrift.BookshoutAccountsService;
import thrift.User;

public class AccountsRPCClient implements BookshoutAccountsService.Iface {

    private BookshoutAccountsService.Client clnt;
    private TTransport                      transport;

    public AccountsRPCClient(String host, int port) throws TTransportException {
        transport = new TSocket(host, port);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        clnt = new BookshoutAccountsService.Client(protocol);
    }

    public void close() {
        transport.close();
    }

    @Override
    public User createUser(String email, String password) throws TException {
        return clnt.createUser(email, password);
    }

    @Override
    public User getUser(int id) throws TException {
        return clnt.getUser(id);
    }
}
