package DBManagers;

import org.javalite.activejdbc.DB;

public class PromoManager {
    @SuppressWarnings("resource")
    public static void warm() {
        new DB("promos").open("org.postgresql.Driver", "jdbc:postgresql://postgres.dev:5432/promos_bookshout_com_development", "cart", "cart");
    }

}
