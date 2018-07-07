package com.ipd12.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Book {
	@Id
	private int id;
	private String title;
	private String authorname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorname=" + authorname + "]";
	}

}
