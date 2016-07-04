package cn.com.mx.model;

public class Wheel {
	String name;
	int size;
	String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Wheel() {
		super();
		this.color="black";
		this.name="miqilin";
		this.size = 17;
	}
	
}
