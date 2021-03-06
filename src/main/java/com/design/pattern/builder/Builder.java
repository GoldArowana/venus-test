package com.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
		}
	}
	
	public void produceSmsSender(int count){
		for(int i=0; i<count; i++){
			list.add(new SmsSender());
		}
	}
}
