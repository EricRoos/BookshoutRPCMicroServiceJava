package Web.Middleware;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import Web.Middleware.Middleware;
import spark.Request;
import spark.Response;

public class HttpLogger extends Middleware{

	@Override
	public void handle(Request arg0, Response arg1) throws Exception {
		Logger.getLogger("web api").log(Level.INFO, arg0.requestMethod()+"  "+arg0.pathInfo());
		Gson gson = new Gson();
		Logger.getLogger("web app").log(Level.INFO, gson.toJson(arg0.queryMap().toMap()));
	}

}
