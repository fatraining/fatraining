package model;

import java.io.Serializable;

public class Result9Table implements Serializable {
	private static final long serialVersionUID = 1L;
	// 表示させたいカラム
	private String name;
	private String food;
	private String drink;
	private String color;

	public Result9Table() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}