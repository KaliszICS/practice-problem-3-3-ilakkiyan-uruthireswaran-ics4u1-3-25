import java.util.ArrayList;


public class PracticeProblem {

	public static ArrayList<String> perms(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			result.add("");
			return result;
		}
		generatepermuntations(str, "", result);
		return result;
	}

	private static void generatepermuntations(String str, String prefix, ArrayList<String> result) {
		if (str.length() == 0) {
			result.add(prefix);
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String newString = str.substring(0, i) + str.substring(i + 1);
			generatepermuntations(newString, prefix + ch, result);
		}
	}

	public static ArrayList<String> permsUnique(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			result.add("");
			return result;
		}

		generatePermuntations(str.toCharArray(), 0, result);
		return result;
	}

	private static void generatePermuntations(char[] chars, int index, ArrayList<String> result) {
		if (index == chars.length) {
			String perm = new String(chars);
			if (!result.contains(perm)) {
				result.add(perm);
			}
		}
		for (int i = index; i < chars.length; i++) {
			swap(chars, index, i);
			generatePermuntations(chars, index + 1, result);
			swap(chars, index, i);
		}
	}

	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	public static void main(String args[]) {
		ArrayList<String> result = perms("12345");
		System.out.println(result);

		ArrayList<String> result2 = permsUnique("aabccd");
		System.out.println(result2);
	}

	

}
