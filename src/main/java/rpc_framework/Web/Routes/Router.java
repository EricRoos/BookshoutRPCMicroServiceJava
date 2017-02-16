package Web.Routes;

import spark.Route;

public class Router {
	public enum VERB{
		GET, POST, PUT, DELETE
		
	}
	public static void register(Router.VERB verb, String path, Route route) {
		switch(verb){
		case GET:
			spark.Spark.get(path, route);
			break;
		case POST:
			spark.Spark.post(path, route);
			break;
		case DELETE:
			spark.Spark.delete(path, route);
			break;
		case PUT:
			spark.Spark.put(path, route);
			break;
		default:
			break;
		}
	}
}
