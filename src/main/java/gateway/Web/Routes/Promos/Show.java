package Web.Routes.Promos;

import static spark.Spark.get;

import com.google.gson.Gson;

import Clients.PromosRPCClient;
import spark.Request;
import spark.Response;
import spark.Route;

public class Show implements Route {

    public static void register() {
        get("/promos/:id", new Web.Routes.Promos.Show());
    }

    @Override
    public Object handle(Request req, Response arg1) throws Exception {
        int promoId = Integer.parseInt(req.params("id"));
        PromosRPCClient clnt = new PromosRPCClient("localhost", 9091);
        thrift.Promo promo = clnt.getPromo(promoId);
        clnt.close();
        Gson gson = new Gson();
        return gson.toJson(promo);
    }

}
