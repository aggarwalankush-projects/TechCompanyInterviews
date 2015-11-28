package MicrosoftCoding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewSolution {

	public static void main(String[] args) {
		try {
			
			new NewSolution().doIt("sample1.txt");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static boolean checkPalindrome(String input)
	{
	        int [] count = new int[26];
	        for( int i = 0; i < input.length(); i++ )
	        {
	            char ch = input.charAt(i);
	            count[ch-'a']++;
	        }
	        int oddOccur = 0;
	        for( int cnt:count )
	        {
	            if( oddOccur > 1) // more than 1 char should have odd frequency
	                return false;
	            if( cnt%2 == 1 )
	                oddOccur++;
	        }
	        return true;
	}

	
	
	
	public void doIt(String fname) throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(fname));
		String line;
		List<String> list=new ArrayList<String>();
		while((line=br.readLine())!=null){
			line=line.replace(";", "#");
			line=line.trim();
			if(line.endsWith("Used")){
				list.add(line);
			}else if(line.equalsIgnoreCase("//----")){
				Collections.sort(list);
				for(String s: list){
					s=s.replace("#", ";");
					System.out.println(s);
				}
				System.out.println("//----");
				list.clear();
			} 
		}
		br.close();
	}
	
}

