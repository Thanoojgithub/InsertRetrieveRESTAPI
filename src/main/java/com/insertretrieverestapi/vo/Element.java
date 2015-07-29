package com.insertretrieverestapi.vo;

import java.io.Serializable;

public class Element implements Serializable, Comparable<Element> {

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
		return "count=" + count + ", word=" + word;
	}

	@Override
	public int compareTo(Element e) {
		int i = 0;
		if (this.getCount() - e.getCount() == 0) {
			i = this.getWord().compareTo(e.getWord());
		} else {
			i = e.getCount() - this.getCount();
		}
		return i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
}
