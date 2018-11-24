package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="trainee")
public class Trainee {

	@Id
	@Column(name="trainee_id")
	@NotNull(message="Enter Trainee ID")
	private Integer traineeId;
	
	@Column(name="traineeName")
	@NotEmpty(message="Enter Trainee Name")
	private String traineeName;

	@Column(name="traineeDomain")
	private String domain;
	
	@Column(name="traineeLocation")
	private String traineeLocation;
	public String getTraineeName() {
		return traineeName;
	}
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeid) {
		this.traineeId = traineeid;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	
}
