package interview.test.solutions;

public class FindPlayerFromSequence {

	static int findPlayer(String s) {

		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {

			if (Character.getNumericValue(s.charAt(i)) != 6)
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {

		int player = findPlayer("3664265");
		if (player == 0)
			System.out.println("-1");
		else
			System.out.println(player);

	}

}
