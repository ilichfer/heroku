package com.api.dto;

/**
 *
 * @author valbuena
 */


public class LibroDto {

	private String id;					
	private String bibleId;				
	private String abbreviation	;
	private String name;			
	private String nameLong;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBibleId() {
		return bibleId;
	}
	public void setBibleId(String bibleId) {
		this.bibleId = bibleId;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameLong() {
		return nameLong;
	}
	public void setNameLong(String nameLong) {
		this.nameLong = nameLong;
	}		
            
}
