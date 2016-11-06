
public class PrinceCard extends Card {

	PrinceCard() {
		super("Prince", 5);

	}

	public static void play() {
		Board.CheckPlayer(true);
		playPrince();
	}

	private static void playPrince() {
		int inputPlayer = Board.getInputPlayer();
		System.out.println(Main.daoPlayers.players.get(inputPlayer).showCard());
		Main.daoPlayers.players.get(inputPlayer).disscard.add(Main.daoPlayers.players.get(inputPlayer).hand.get(0));
		Main.daoPlayers.players.get(inputPlayer).hand.remove(0);
		Main.daoPlayers.players.get(inputPlayer).getCard();

	}

}
