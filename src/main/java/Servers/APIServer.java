package Servers;
import static spark.Spark.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import Clients.GatewayServiceClient;
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
        	int promoId = Integer.parseInt(req.params("id"));
        	GatewayServiceClient clnt = new GatewayServiceClient();
        	Gson gson = new Gson();        	
        	return gson.toJson(clnt.getPromo(promoId));
        });
        
    }
}
