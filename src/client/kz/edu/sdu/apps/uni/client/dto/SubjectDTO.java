package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;


public class SubjectDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6416798925929771380L;
	
	
	private Long subjectId;
	private String subjectCode;
	private String title;
	private String description;
	private CourseDTO courseDTO;
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseDTO getCourseDTO() {
		return courseDTO;
	}
	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

	
}
