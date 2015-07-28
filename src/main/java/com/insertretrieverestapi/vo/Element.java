package com.insertretrieverestapi.vo;

import java.io.Serializable;

public class Element implements Serializable, Comparable<Element>{

	private static final long serialVersionUID = 1L;

	private Integer count;
	private String word;
	private Long timeStamp;

	public Element(Integer count, String word, Long timeStamp) {
		super();
		this.count = count;
		this.word = word;
		this.timeStamp = timeStamp;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Element [count=" + count + ", word=" + word + ", timeStamp="
				+ timeStamp + "]";
	}

	@Override
	public int compareTo(Element e) {
		int i = 0;
		if(this.getCount() - e.getCount() == 0){
			i = this.getWord().compareTo(e.getWord());
		}else{
			i = this.getCount() - e.getCount();
		}
		return i;
	}
}
