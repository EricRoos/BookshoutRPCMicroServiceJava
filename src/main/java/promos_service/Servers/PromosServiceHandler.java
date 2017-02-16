package Servers;

import java.util.stream.Collectors;

import org.apache.thrift.TException;

import DBManagers.PaginatedQueryResponse;
import DBManagers.PromoManager;
import thrift.BookshoutPromosService;
import thrift.EntityList;
import thrift.ListData;
import thrift.Promo;
import thrift.PromoCode;

public class PromosServiceHandler implements BookshoutPromosService.Iface {

    @Override
    public Promo getPromo(int id) throws TException {
        PromoManager mgr = new PromoManager();
        thrift.Promo p = new Promo();
        Domain.Promo domainPromo = mgr.find(id);
        p.setName(domainPromo.getName());
        return p;
    }

    @Override
    public PromoCode createCode(Promo promo) throws TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntityList getPromoCodes(Promo promo) throws TException {
        int page = 1;
        int perPage = 10;
        Domain.Promo domainPromo = new Domain.Promo();
        domainPromo.setId(promo.getId());

        PromoManager mgr = new PromoManager();

        PaginatedQueryResponse<Domain.PromoCode> resp = mgr.getPaginatedPromoCodes(domainPromo, page, perPage);

        EntityList list = new EntityList();
        ListData data = new ListData();
        data.setPromoCodes(resp.getData().stream().map((code) -> new thrift.PromoCode(promo, code.getCustomCode()))
                .collect(Collectors.toList()));

        list.setData(data);
        list.setCurrentPage(page);
        list.setNumRecords(resp.getNumRecords());
        list.setPageSize(resp.getPageSize());

        return list;

    }

}
