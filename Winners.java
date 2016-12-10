import java.util.ArrayList;

import java.util.List;

public class Winners {
	static private List<Player> winPlayers = new ArrayList<Player>();

	public static void main(String[] args) {
		listWinPlayer();
	}

	private static void listWinPlayer() {

		for (int x = 0; x < Main.daoPlayers.players.size(); x++) {

			if (Main.daoPlayers.players.get(x).getActiv() == true)
				winPlayers.add(Main.daoPlayers.players.get(x));

		}

	}
// CONNTINUES THIS <<<<<<<<<<<>>>>>>>>>>>>>>>>
	
	
}