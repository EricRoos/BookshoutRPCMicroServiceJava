package Servers;
import static spark.Spark.*;

import com.google.gson.Gson;

import Clients.GatewayServiceClient;
public class APIServer {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        
        get("/users/:id", (req,res) ->{
        	int userId = Integer.parseInt(req.params("id"));
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	Gson gson = new Gson();        	
        	return gson.toJson(clnt.getUser(userId));
        });
        
        get("/promos/:id", (req,res) ->{
        	int promoId = Integer.parseInt(req.params("id"));
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	Gson gson = new Gson();        	
        	return gson.toJson(clnt.getPromo(promoId));
        });
        
    }
}
