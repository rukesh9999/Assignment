package com.api.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * store entity class
 * @author Rukesh
 *
 */


@Entity
@Table(name="store",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"id"}),
		@UniqueConstraint(columnNames = {"url"}),
		@UniqueConstraint(columnNames = {"uniqueKey"})
})
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id",unique =true,nullable = false)
	private Integer id;
	
	@Column(name="url",unique =true,nullable=false)
	private String url;
	
	@Column(name="uniqueKey",unique =true,nullable=false)
	private String uniqueKey;
	
	@Column(name="count",unique =false,nullable=false)
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
