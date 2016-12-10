
public class PrincessCard extends Card {

	PrincessCard() {
		super("Princess", 8); // konstruktor

	}

	public static void play() {

		int iAmThisNumber = 0;
		for (int x = 0; x < 4; x++) {
			int a = Main.daoPlayers.players.get(x).getMyTime();

			if (a == 1) {
				iAmThisNumber = x;
				break;

			}
			System.out.print("Princess burn your letter...");
			Main.daoPlayers.players.get(iAmThisNumber).losse();

		}

	}
}
