package com.design.pattern.visit;

public interface Subject {
	public void accept(Visitor visitor);
	public String getSubject();
}
