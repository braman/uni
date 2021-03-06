package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;
import java.util.Date;

public class TermDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8821127227200701814L;
	
	
	private Long termId;
	private String name;
	private Date startDate;
	private Date endDate;
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long id) {
		this.termId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
