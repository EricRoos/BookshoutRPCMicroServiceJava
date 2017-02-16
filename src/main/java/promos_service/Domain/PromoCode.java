package Domain;

public class PromoCode {
    private int    id;
    private String customCode;
    private Promo  promo;

    public PromoCode() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PromoCode(int id, String customCode, Promo promo) {
        super();
        this.id = id;
        this.customCode = customCode;
        this.promo = promo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

}
