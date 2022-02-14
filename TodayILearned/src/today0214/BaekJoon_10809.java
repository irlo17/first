package today0214;

/*
	[문제]알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
		포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
		첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10809 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] idx = new int[26];
		for(int i=0; i<idx.length; i++) {
			idx[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			for(char ch='a'; ch<='z'; ch++) {
				if(str.charAt(i)==ch & idx[ch-'a'] == -1) { //중복된 알파벳이 나올 수 있으므로
						idx[ch-'a'] = i;
				}//if
			}//for-ch
		}//for-i
	
			for(int i=0; i<idx.length;  i++) {
				System.out.print(idx[i]+" ");
			}//for-i
			br.close();
	}//main()
}//class
