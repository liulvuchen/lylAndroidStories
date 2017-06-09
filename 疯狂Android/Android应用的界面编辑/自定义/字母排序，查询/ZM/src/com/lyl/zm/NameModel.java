package com.lyl.zm;

public class NameModel {
	
	private String realName;
	private String pinyinName;
	private char firstLetter;
	
	public NameModel() {
		super();
	}
	public NameModel(String realName) {
		super();
		this.realName = realName;
	}
	public NameModel(String realName, String pinyinName, char firstLetter) {
		super();
		this.realName = realName;
		this.pinyinName = pinyinName;
		this.firstLetter = firstLetter;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPinyinName() {
		return pinyinName;
	}
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}
	public char getFirstLetter() {
		return firstLetter;
	}
	public void setFirstLetter(char firstLetter) {
		this.firstLetter = firstLetter;
	}

}
