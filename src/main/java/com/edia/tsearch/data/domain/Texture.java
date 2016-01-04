package com.edia.tsearch.data.domain;
 
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
 
@Entity
public class Texture implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Texture() {
 
	};
 
	public Texture(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	};
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	private String title;
	
	@Lob
	private String content;
	
	

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getContent() {
		return content;
	}

	
	public void setContent(String content) {
		this.content = content;
	}
 
}