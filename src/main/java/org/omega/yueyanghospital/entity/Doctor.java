package org.omega.yueyanghospital.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("doctor")
public class Doctor {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column("pinyin_name")
	private String pinyinName;
	
	@Column
	private String surname;
	
	@Column("pinyin_surname")
	private String pinyinSurname;
	
	@Column
	private String title;
	
	@Column
	private String department;
	
	@Column("work_time")
	private String workTime;
	
	@Column
	private String description;
	
	@Column("skill_desc")
	private String skillDesc;
	
	@Column("file_path")
	private String filePath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyinName() {
		return pinyinName;
	}
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPinyinSurname() {
		return pinyinSurname;
	}
	public void setPinyinSurname(String pinyinSurname) {
		this.pinyinSurname = pinyinSurname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
