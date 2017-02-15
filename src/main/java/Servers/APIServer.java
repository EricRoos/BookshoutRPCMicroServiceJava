package Servers;
import static spark.Spark.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import APIPresenters.PromoCodePresenter;
import APIResponse.PaginatedResponse;
import Clients.GatewayServiceClient;
import thrift.EntityList;

public class APIServer {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        
        get("/users/:id", (req,res) ->{
        	Logger.getLogger("global").log(Level.INFO, "GET /users/"+req.params("id"));
        	int userId = Integer.parseInt(req.params("id"));
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	Gson gson = new Gson();        	
        	return gson.toJson(clnt.getUser(userId));
        });
        
        get("/promos/:id", (req,res) ->{
        	Logger.getLogger("global").log(Level.INFO, "GET /promos/"+req.params("id"));
        	int promoId = Integer.parseInt(req.params("id"));
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	Gson gson = new Gson();        	
        	return gson.toJson(clnt.getPromo(promoId));
        });
        
        get("/promos/:id/promo_codes", (req, res)->{    
        	Logger.getLogger("global").log(Level.INFO, "GET /promos/"+req.params("id")+"/promo_codes");
        	int promoId = Integer.parseInt(req.params("id"));
        	thrift.Promo promo = new thrift.Promo(promoId, null);
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	       	
        	EntityList list = clnt.getPromoCodes(promo);
        	
        	List<PromoCodePresenter> codePresenters = list.getData().getPromoCodes()
        			.stream()
        			.map(PromoCodePresenter::fromThrift)
        			.collect(Collectors.toList());
        	
        	PaginatedResponse<PromoCodePresenter> response = new PaginatedResponse<PromoCodePresenter>();
        	response.setItems(codePresenters);
        	response.setCurrent_page(list.getCurrentPage());
        	response.setTotal_items(list.getNumRecords());
        	
        	Gson gson = new Gson(); 
        	return gson.toJson(response);
        	
        });
        
    }
}
