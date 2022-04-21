package com.catalog.com.exceptions;

import java.util.Date;

public class CatalogException {

	private Date timestamp;
	private String title;
	private String description;
	
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CatalogException(Date timestamp, String title, String description) {
		this.timestamp = timestamp;
		this.title = title;
		this.description = description;
	}
	
	
	
}
