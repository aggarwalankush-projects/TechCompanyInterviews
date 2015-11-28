package MicrosoftCoding;

import java.util.HashSet;

public class PalindromeSolution {

	public static void main(String[] args) {
		try {
			System.out.println(new PalindromeSolution().doIt("aad"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public int doIt(String s){
		HashSet<Integer> oddIndexes=checkPalindrome(s);
		int oddindexes=oddIndexes.size()-1;
		StringBuilder sb=new StringBuilder(s);
		Integer[] array=oddIndexes.toArray(new Integer[0]);
		for (int i = 0; i < oddindexes; i++) {
		}
		return 0;
	}
	
	HashSet<String> set=new HashSet<String>();
	
	public HashSet<Integer> checkPalindrome(String input) {
		HashSet<Integer> oddIndexes=new HashSet<Integer>();
		int[] count = new int[26];
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			count[ch - 'a']++;
		}
		for (int cnt : count) {
			if (cnt % 2 == 1){
				oddIndexes.add(input.indexOf((char)cnt));
			}
		}
		return oddIndexes;
	}
	
	public boolean isPalindrome(String input) {
		
		int[] count = new int[26];
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			count[ch - 'a']++;
		}
		int oddOccur = 0;
		for (int cnt : count) {
			if (oddOccur > 1) // more than 1 char should have odd frequency
				return false;
			if (cnt % 2 == 1){
				oddOccur++;
			}
		}
		return true;
	}

	public  void permutation(String str) { 
	    permutation("", str); 
	}

	private  void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) set.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
