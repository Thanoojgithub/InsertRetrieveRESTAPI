package com.insertretrieverestapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.insertretrieverestapi.vo.Element;

@Component("insertRetrieveService")
public class InsertRetrieveServiceImpl implements InsertRetrieveService {

	private Map<String, Element> element;

	/**
	 * insert
	 */
	public void insert(String str) {
		if(null == getElement().get(str)){
			getElement().put(str, new Element(1, str, Calendar.getInstance().getTimeInMillis()));
		}else{
			Element ele = getElement().get(str);
			ele.setCount(ele.getCount() + 1);
			ele.setTimeStamp(Calendar.getInstance().getTimeInMillis());
			getElement().put(str, ele);
		}
	}

	/**
	 * retrieve
	 */
	public List<Map.Entry<String, Element>> retrieve() {
		List<Map.Entry<String, Element>> list = new ArrayList<Map.Entry<String, Element>>(getElement().entrySet());
		Collections.sort(list ,
				new Comparator<Map.Entry<String, Element>>() {
					public int compare(Map.Entry<String, Element> o1,
							Map.Entry<String, Element> o2) {
						int i = 0;
						if(o1.getValue().getCount() - o2.getValue().getCount() == 0){
							i = o1.getValue().getWord().compareTo(o2.getValue().getWord());
						}else{
							i = o1.getValue().getCount() - o2.getValue().getCount();
						}
						return i;
					}
				});
		return list;
	}

	public Map<String, Element> getElement() {
		if (element == null)
			element = new HashMap<String, Element>();
		return element;
	}

	
	

}
