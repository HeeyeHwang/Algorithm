package programmers.hash;

import java.util.Arrays;

public class PhoneNumberList {
	public boolean hash2(String[] phoneBook) {

		Arrays.sort(phoneBook);

		System.out.println(Arrays.toString(phoneBook));
		String stnd;
		for (int i = 0; i < phoneBook.length; i++) {
			stnd = phoneBook[i];

			for (int j = i + 1; j < phoneBook.length; j++) {

				if (phoneBook[j].startsWith(stnd)) {
					return false;
				}
			}
		}

		return true;
	}
}
