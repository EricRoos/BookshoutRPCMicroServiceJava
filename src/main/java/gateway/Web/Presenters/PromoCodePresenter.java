package Web.Presenters;

/**
 * Presenter class for promo codes, we need presenters as a way to filter out
 * params for consumption by the outside world. Most of the time we will be
 * doing deep complete copies. But in the case of a user we would not want to
 * expose that info.
 * 
 * This is also an opportunity to add any other meta information
 * 
 */
public class PromoCodePresenter {
    private String code;
    private int    id;

    public PromoCodePresenter(int id, String code) {
        super();
        this.id = id;
        this.code = code;
    }

    public static PromoCodePresenter fromThrift(thrift.PromoCode code) {
        return new PromoCodePresenter(1, code.getCode());
    }
}
