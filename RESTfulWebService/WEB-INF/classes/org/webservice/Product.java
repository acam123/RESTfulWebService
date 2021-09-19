package org.webservice;

import java.util.ArrayList;

/**
* @author Aidan Campbell
*/

public class Product{  
	private String name;
	private String desc;
	private ArrayList<Album> albums = new ArrayList<Album>();

	public void create(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public void addAlbum(Album album) {
		this.albums.add(album);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}

	public void update() {
		
	}

	public void delete() {
		
	}
} 