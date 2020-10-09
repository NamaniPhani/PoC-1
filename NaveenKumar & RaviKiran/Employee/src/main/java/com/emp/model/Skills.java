package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Skills {
	@Id
	@GeneratedValue
	@Column(name="skills_id")
	private Integer skillsId;
	@Column
	private String skill;
	public Integer getSkillsId() {
		return skillsId;
	}
	public void setSkillsId(Integer skillsId) {
		this.skillsId = skillsId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Skills [skillsId=" + skillsId + ", skill=" + skill + "]";
	}
}

	