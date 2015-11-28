package MicrosoftCoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		try {

			new Solution().doIt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doIt() {
		permutation("HHVV");
		System.out.println(set);

		String[] inp = { "2 2 2", "2 2 3" };
		System.out.println(Arrays.deepToString(gridLand(inp)));
	}

	static void permutation(String str) {
		permutation("", str);
	}

	static TreeSet<String> set = new TreeSet<String>();
	static HashMap<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();

	static void permutation(String prefix, String str) {
		int len = str.length();
		if (len == 0) {
			set.add(prefix);
			return;
		}
		for (int i = 0; i < len; i++) {
			if (str.indexOf(str.charAt(i), i + 1) != -1)
				continue;
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
		}

	}

	static String[] gridLand(String[] inp) {
		String[] result = new String[inp.length];

		for (int j = 0; j < inp.length; j++) {
			StringBuilder sb = new StringBuilder();
			String[] xyk = inp[j].split(" ");
			int x = Integer.parseInt(xyk[0]);
			int y = Integer.parseInt(xyk[1]);
			int k = Integer.parseInt(xyk[2]);
			while (x != 0) {
				sb.append("H");
				x--;
			}
			while (y != 0) {
				sb.append("V");
				y--;
			}
			String str = sb.toString();
			
			if(map.containsKey(str)){
				set=map.get(str);
			}else{
				permutation(str);
				map.put(str, set);
			}
			
			int i = 0;
			for (String element : set) {
				str = element;
				if (i == k)
					break;
				i++;
			}
			result[j] = str;
		}

		return result;
	}

}
