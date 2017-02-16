package Web.Responses;

import java.util.List;

public class PaginatedResponse<K> {
	private List<K> items;
	private int total_items;
	private int total_pages;
	private int current_page;
	
	public PaginatedResponse() {
		super();
	}
	public PaginatedResponse(List<K> items, int total_items, int total_pages, int current_page) {
		super();
		this.items = items;
		this.total_items = total_items;
		this.total_pages = total_pages;
		this.current_page = current_page;
	}
	public List<K> getItems() {
		return items;
	}
	public void setItems(List<K> items) {
		this.items = items;
	}
	public int getTotal_items() {
		return total_items;
	}
	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	
}
