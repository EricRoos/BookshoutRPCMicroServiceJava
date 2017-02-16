package Web.Servers;

import Web.Middleware.Middleware;
import Web.Routes.Router;

public class API {
    public static void main(String[] args) {

        Middleware.register(new Web.Middleware.HttpLogger());
        Router.register(Router.VERB.GET, "/users/:id", new Web.Routes.Users.Show());
        Router.register(Router.VERB.GET, "/promos/:id", new Web.Routes.Promos.Show());
        Router.register(Router.VERB.GET, "/promos/:id/promo_codes", new Web.Routes.PromoCodes.Show());

    }
}
