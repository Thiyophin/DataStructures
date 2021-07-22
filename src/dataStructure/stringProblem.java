package dataStructure;
public class stringProblem {
	// Method to convert "AAAbbC" to "3A2b1C"
	public static void solve(String str) {
		int i = 0;
		String str2 = "";
		char []charArray = str.toCharArray();
		while(i<str.length()) {
			int count = 1;
			i++;
			while(i<str.length() && charArray[i-1] == charArray[i]) {
				count++;
				i++;
			}
			str2 = str2+count+charArray[i-1];
		}
		System.out.println(str2);
	}
public static void main(String[] args) {
	String str = "AAABBCC";
	solve(str);
}
}
