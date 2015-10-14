package model;

import java.io.Serializable;

public class Result12Table implements Serializable {

	private static final long serialVersionUID = 1L;

	private String competition_number;
	private String registration_number;
	private String sport;
	private String name;
	private int id;

	public Result12Table() {
	}

	public String getCompetition_number() {
		return competition_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompetition_number(String competition_number) {
		this.competition_number = competition_number;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
