package chapter1;

/**
 * 
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 *
 * Possible improvements after seeing the solution: - a method to count the size
 * of the output string could be created to return early, without having to
 * create the compressed string.
 */
public class Question5 {

	static String compressString(String str) {
		StringBuffer strBuf = new StringBuffer();

		if (str == null || str.equals("")) {
			return str;
		}

		String currentChar = "";
		int currentCounter = 0;

		for (int i = 0; i < str.length(); i++) {
			String nextChar = str.charAt(i) + "";

			if (i == 0) {
				currentChar = nextChar;
				currentCounter = 1;
			} else {
				if (nextChar.equals(currentChar)) {
					currentCounter++;
				} else {
					strBuf.append(currentChar);
					strBuf.append(currentCounter);
					currentChar = nextChar;
					currentCounter = 1;
				}
			}
		}

		strBuf.append(currentChar);
		strBuf.append(currentCounter);

		String compressedStr = strBuf.toString();

		return  (compressedStr.length() < str.length()) ? compressedStr : str;
	}

	public static void main(String[] args) {
		System.out.println(compressString("aaaaaaabbcbbbc"));
	}
}
