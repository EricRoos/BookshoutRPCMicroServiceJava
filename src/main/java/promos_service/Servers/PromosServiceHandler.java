package Servers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.thrift.TException;

import com.google.gson.Gson;

import thrift.BookshoutPromosService;
import thrift.EntityList;
import thrift.ListData;
import thrift.Promo;
import thrift.PromoCode;

public class PromosServiceHandler implements BookshoutPromosService.Iface {

    @Override
    public Promo getPromo(int id) throws TException {
        thrift.Promo p = new Promo();
        Domain.Promo domainPromo = Domain.Promo.findById(id);
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
        Domain.Promo domainPromo = Domain.Promo.findById(promo.getId());
        
        List<Domain.PromoCode> codes = domainPromo.getAll(Domain.PromoCode.class).limit(perPage).offset((page-1)*perPage);

        EntityList list = new EntityList();
        ListData data = new ListData();
        data.setPromoCodes(codes.stream().map((code) -> new thrift.PromoCode(promo, code.getCustomCode()))
                .collect(Collectors.toList()));

        list.setData(data);
        list.setCurrentPage(page);
        list.setNumRecords(domainPromo.countTotalPromoCodes().intValue());
        list.setPageSize(perPage);
        return list;

    }

}
