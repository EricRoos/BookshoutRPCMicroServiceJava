package Web.Routes.PromoCodes;

import static spark.Spark.get;

import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import Clients.PromosRPCClient;
import Web.Presenters.PromoCodePresenter;
import Web.Responses.PaginatedResponse;
import spark.Request;
import spark.Response;
import spark.Route;
import thrift.EntityList;

public class Show implements Route {

    public static void register() {
        get("/promos/:id/promo_codes", new Web.Routes.PromoCodes.Show());
    }

    @Override
    public Object handle(Request req, Response resp) throws Exception {
        int promoId = Integer.parseInt(req.params("id"));
        thrift.Promo promo = new thrift.Promo(promoId, null);
        PromosRPCClient clnt = new PromosRPCClient("localhost", 9091);
        EntityList list = clnt.getPromoCodes(promo);
        clnt.close();

        List<PromoCodePresenter> codePresenters = list.getData().getPromoCodes().stream()
                .map(PromoCodePresenter::fromThrift).collect(Collectors.toList());

        PaginatedResponse<PromoCodePresenter> response = new PaginatedResponse<PromoCodePresenter>();
        response.setItems(codePresenters);
        response.setCurrent_page(list.getCurrentPage());
        response.setTotal_items(list.getNumRecords());

        Gson gson = new Gson();
        return gson.toJson(response);
    }

}
