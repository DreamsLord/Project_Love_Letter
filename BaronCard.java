
public class BaronCard extends Card {

	BaronCard() {
		super("Baron", 3); // konstruktor
	}

	public static void play() {
		Board.CheckPlayer(false);
		playBaron();
	}

	private static void playBaron() {
		int inputPlayer = Board.getInputPlayer();
		int iAmThisNumber = 0;
		for (int x = 0; x < 4; x++) {
			int a = Main.daoPlayers.players.get(x).getMyTime();

			if (a == 1) {
				iAmThisNumber = x ;
				break;
			}

		}
		int myNumberCard = Main.daoPlayers.players.get(iAmThisNumber).hand.get(0).getNumber();
		int himNumerCard = Main.daoPlayers.players.get(inputPlayer).hand.get(0).getNumber();
		System.out.print("Your Card" + Main.daoPlayers.players.get(iAmThisNumber).showCard());
		System.out.print("Him Card" + Main.daoPlayers.players.get(inputPlayer).showCard());
		System.out.print("---------------------");
		if (myNumberCard > himNumerCard) {
			System.out.print("You are more importer than this...,");
			Main.daoPlayers.players.get(inputPlayer).losse();

		} else if (myNumberCard == himNumerCard) {

			System.out.println("You are this same...");

		} else {
			
			Main.daoPlayers.players.get(iAmThisNumber).losse();
			System.out.print("You are less importer than this great person...,");

		}
	}
}
