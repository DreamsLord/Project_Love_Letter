
public class KingCard extends Card {

	KingCard() {
		super("King", 6);

	}

	public static void play() {
		Board.CheckPlayer(false);
		playKing();
	}

	private static void playKing() {
		int inputPlayer = Board.getInputPlayer();

		int iAmThisNumber = 0;
		for (int x = 0; x < 4; x++) {
			int a = Main.daoPlayers.players.get(x).getMyTime();

			if (a == 1) {
				iAmThisNumber = x;
				break;
			}

		}
		System.out.println(Main.daoPlayers.players.get(inputPlayer).showCard());

		Main.daoPlayers.players.get(iAmThisNumber).hand.add(Main.daoPlayers.players.get(inputPlayer).hand.get(0));
		Main.daoPlayers.players.get(inputPlayer).hand.remove(0);
		Main.daoPlayers.players.get(inputPlayer).hand.add(Main.daoPlayers.players.get(iAmThisNumber).hand.get(0));
		Main.daoPlayers.players.get(iAmThisNumber).hand.remove(0);
	}

}
