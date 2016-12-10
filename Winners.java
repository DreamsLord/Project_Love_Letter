import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Winners {
	static private List<Player> winPlayers = new ArrayList<Player>();

	public static void showWinners() {
		listWinPlayer();
		showListWinPlayers();
		GetScoreWinPlayer();

	}

	private static void listWinPlayer() {

		for (int x = 0; x < Main.daoPlayers.players.size(); x++) {

			if (Main.daoPlayers.players.get(x).getActiv() == true) {
				winPlayers.add(Main.daoPlayers.players.get(x));

			}

		}
	}

	private static void showListWinPlayers() {
		for (int x = 0; x < winPlayers.size(); x++) {
			System.out.print(winPlayers.get(x).getPlayerNumber());
			System.out.print(winPlayers.get(x).showCard());

		}
	}

	private static void GetScoreWinPlayer() {
		if (winPlayers.size() == 1) {
			winPlayers.get(0).setScore(+1);
			System.out.print("This players is winner" + winPlayers.get(0).getPlayerNumber());
		} else {
			int max = 0;
			int y = 0;
			for (int x = 0; x < winPlayers.size(); x++) {
				y = winPlayers.get(x).showCard().get(0).getNumber();
				if (y > max) {
					y = max;
				}

			}
			for (int x = 0; x < winPlayers.size(); x++) {
				if (max == winPlayers.get(x).showCard().get(0).getNumber()) {
					winPlayers.get(x).setScore(+1);
					System.out.print("This players is winner" + winPlayers.get(x).getPlayerNumber());
				}
			}

		}
	}
}
