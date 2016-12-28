package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeValidate {

	public static boolean isValidSerialization(String preorder) {
	    List<String> list = new ArrayList<String>();
	    String[] arr = preorder.split(",");
	 
	    for(int i=0; i<arr.length; i++){
	        list.add(arr[i]);
	 
	        while(list.size()>=3 
	            && list.get(list.size()-1).equals("#")
	            && list.get(list.size()-2).equals("#")
	            && !list.get(list.size()-3).equals("#")){
	 
	            list.remove(list.size()-1);
	            list.remove(list.size()-1);
	            list.remove(list.size()-1);
	 
	            list.add("#");
	        }
	 
	    }
	 
	    if(list.size()==1 && list.get(0).equals("#"))
	        return true;
	    else
	        return false;
	}

	public static void main(String[] args) {
		String string = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(string));

		string = "9,3,4,#,#,1,#,#,2,#,6,#,#,#";
		System.out.println(isValidSerialization(string));

		string = "9, 3, 4, #, #, 1, #, #, # ";
		System.out.println(isValidSerialization(string));
	}
}


