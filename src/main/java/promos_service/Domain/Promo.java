package Domain;

import java.util.HashSet;
import java.util.Set;


public class Promo {
	private int id;
	private String name;
	private Set<PromoCode> promoCodes = new HashSet<PromoCode>(0);
	
	public Promo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promo(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<PromoCode> getPromoCodes() {
		return promoCodes;
	}

	public void setPromoCodes(Set<PromoCode> promoCodes) {
		this.promoCodes = promoCodes;
	}
	
}
