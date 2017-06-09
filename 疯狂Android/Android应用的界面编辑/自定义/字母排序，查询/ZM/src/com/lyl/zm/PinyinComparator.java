package com.lyl.zm;

import java.util.Comparator;

public class PinyinComparator implements Comparator<NameModel>{

	@Override
	public int compare(NameModel lhs, NameModel rhs) {
		
		return lhs.getPinyinName().compareTo(rhs.getPinyinName());
		
	}

}
