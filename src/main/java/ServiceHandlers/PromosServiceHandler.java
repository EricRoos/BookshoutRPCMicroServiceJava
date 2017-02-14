package ServiceHandlers;

import java.util.List;

import org.apache.thrift.TException;

import DBManagers.PromoManager;
import thrift.BookshoutPromosService;
import thrift.Promo;
import thrift.PromoCode;

public class PromosServiceHandler implements BookshoutPromosService.Iface{

	@Override
	public Promo getPromo(int id) throws TException {
		PromoManager mgr = new PromoManager();
		thrift.Promo p = new thrift.Promo();
		Domain.Promos.Promo domainPromo = mgr.find(id);
		p.setName(domainPromo.getName());
		mgr.close();
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
