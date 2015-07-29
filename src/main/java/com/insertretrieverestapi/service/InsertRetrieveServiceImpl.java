package com.insertretrieverestapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
		if (null == getElement().get(str)) {
			getElement().put(
					str,
					new Element(1, str, Calendar.getInstance()
							.getTimeInMillis()));
		} else {
			Element ele = getElement().get(str);
			ele.setCount(ele.getCount() + 1);
			ele.setTimeStamp(Calendar.getInstance().getTimeInMillis());
			getElement().put(str, ele);
		}
	}

	/**
	 * retrieve
	 */
	public List<Element> retrieve() {
		List<Element> list = new ArrayList<Element>();
		Iterator<String> iterator = getElement().keySet().iterator();
		while (iterator.hasNext()) {
			Element ele = getElement().get(iterator.next());
			/**
			 * test case - 0.30 minutes
			 */
			if (System.currentTimeMillis() - ele.getTimeStamp() > 18000) {
				if (ele.getCount() > 1) {
					ele.setCount(ele.getCount() - 1);
					list.add(ele);
				} else {
					iterator.remove();
				}
			} else {
				list.add(ele);
			}
		}
		Collections.sort(list);
		return list;
	}

	public Map<String, Element> getElement() {
		if (element == null)
			element = new HashMap<String, Element>();
		return element;
	}

}
