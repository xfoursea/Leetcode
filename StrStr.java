/*
 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * */

package leetcode2;

public class StrStr {

	public static void main(String[] args) {
		System.out.println(strStr("Mississiauga", "ssi"));
	}
	static String strStr(String haystack, String needle) {
		if( needle==null || needle.length()==0 ) return haystack;
		if(haystack==null || haystack.length()<needle.length())
		    return null;
		
		int i=0; int j=0; int len=0;
		while(i < haystack.length() && j< needle.length() ){
			if(haystack.charAt(i)==needle.charAt(j)){
				i++;
				j++;
				len++;
			}else{
				
				i=(i-len)+1;
				len=0;
				j=0;	
				
			}
		}
		if(len==needle.length())
			return haystack.substring(i-len);
		else
		    return null;
	}

}
