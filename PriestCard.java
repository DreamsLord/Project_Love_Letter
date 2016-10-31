import java.util.Scanner;

public class PriestCard extends Card {

	static Scanner in = new Scanner(System.in);

	PriestCard() {
		super("Priest", 2);

	}

	static void play() {
		int userInput;

		System.out.println("Change Player who show you his card");
		userInput = in.nextInt();

		Player inputPlayer = Main.daoPlayers.players.get(userInput - 1);
		System.out.println(inputPlayer.getPlayerNumber());
		System.out.println(Main.daoPlayers.players.get(userInput - 1).showCard());

	}
}
