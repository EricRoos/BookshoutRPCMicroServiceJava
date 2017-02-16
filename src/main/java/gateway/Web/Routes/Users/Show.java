package Web.Routes.Users;

import static spark.Spark.get;

import com.google.gson.Gson;

import Clients.AccountsRPCClient;
import spark.Request;
import spark.Response;
import spark.Route;

public class Show implements Route{
	public static void register() {
		get("/users/:id", new Web.Routes.Users.Show());
	}
	
	@Override
	public Object handle(Request req, Response resp) throws Exception {        
    	int userId = Integer.parseInt(req.params("id"));

		AccountsRPCClient clnt = new AccountsRPCClient("localhost", 9090);
		thrift.User u =  clnt.getUser(userId);
		clnt.close();
    	Gson gson = new Gson();        	
    	return gson.toJson(u);
	}

}
