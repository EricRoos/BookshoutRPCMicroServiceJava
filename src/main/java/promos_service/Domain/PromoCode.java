package Domain;

import org.javalite.activejdbc.annotations.DbName;

@DbName("promos")
public class PromoCode extends PromoDomainBase {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomCode() {
        return (String) this.get("custom_code");
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
