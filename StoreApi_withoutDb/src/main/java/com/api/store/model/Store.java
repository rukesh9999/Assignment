package com.api.store.model;





public class Store {
	

	private Integer id;
	
	private String url;
	
	private String uniqueKey;
	
	private Integer count;

	
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Store(Integer id, String url, String uniqueKey, Integer count) {
		super();
		this.id = id;
		this.url = url;
		this.uniqueKey = uniqueKey;
		this.count = count;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", url=" + url + ", uniqueKey=" + uniqueKey + ", count=" + count + "]";
	}
	
	

}
