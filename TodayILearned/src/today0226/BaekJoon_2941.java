package today0226;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2941 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strLength = 0;
		
		for(int i=0; i<str.length(); i++) {
			strLength++;
		switch(str.charAt(i)) {
		
		case 'c' :  
			if(i<str.length()-1) {
				if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
					i++;
				}//if
			}//if
			break;
			
		case 'd' :  
			if(i<str.length()-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					i += 2;
			}else if(i<str.length()-1 && str.charAt(i+1) == '-') {
				i++;
			}else {
				break;
			}//if
			
		case 'l' :  
			if(i<str.length()-1 && str.charAt(i+1) == 'j') {
				i++;
			}//if
			break;
		case 'n' :  
			if(i<str.length()-1 && str.charAt(i+1) == 'j') {
				i++;
			}//if
			break;
		case 's' :  
			if(i<str.length()-1 && str.charAt(i+1) == '=') {
				i++;
			}//if
			break;
		case 'z' :  
				if(i<str.length()-1 && str.charAt(i+1) == '=') {
					i++;
				}//if
				break;
		}//switch
		}//for
		System.out.println(strLength);
		br.close();
	}//main()
}//class
