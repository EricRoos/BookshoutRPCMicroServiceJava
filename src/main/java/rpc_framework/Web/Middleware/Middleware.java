package Web.Middleware;

import spark.Filter;

public abstract class Middleware implements Filter {

    public static void register(Middleware w) {
        spark.Spark.before(w);
    }

}
