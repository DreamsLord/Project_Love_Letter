import java.util.regex.Pattern;

public class GuardCard extends Card {

	GuardCard() {
		super("Guard", 1);

	}

	public static void play() {

		Board.CheckPlayer(false);
		guardPlay();
	}
	
public static void guardPlay() {
		System.out.println("/n  wchice number of card has this player");
		int inputCard = 0;
		
		
		int inputPlayer=Board.getInputPlayer();
		do {

			String loadInputCard = Main.in.next();

			Pattern goodNumber = Pattern.compile("[2-9]");

			if (goodNumber.matcher(loadInputCard).matches()) {

				try {
					inputCard = Integer.valueOf(loadInputCard);

				} catch (NumberFormatException nfe) {
					System.out.print("Zły format , wpisz kartę od 2 lub 8,  nie mozesz zagrac na strazniczke (1");
				}
			}
		} while (inputCard == 0);

		int playerCard;
		playerCard = Main.daoPlayers.players.get(inputPlayer).hand.get(0).getNumber();
		System.out.println("jego reka" + playerCard);
		System.out.println("wybrany numer przez Ciebie" + inputCard);
		
		if (playerCard == inputCard) {
			Main.daoPlayers.players.get(inputPlayer).losse();
			System.out.println("You are right!");
		} else {
			System.out.println("You are wrong");
	}
}
}


