package com.rg.eventappweb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Event {

	private String title;
	@Id
	private Integer id;

	public Event(){
		this.id = new Random().nextInt();
	}
	public Event(String title) {
		this();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Event [title=" + title + ", id=" + id + "]";
	}

	
	
}
