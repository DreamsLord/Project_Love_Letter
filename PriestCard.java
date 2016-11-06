import java.util.Scanner;

public class PriestCard extends Card {

	static Scanner in = new Scanner(System.in);

	PriestCard() {
		super("Priest", 2);

	}
	static void play(){
		Board.CheckPlayer(false);
		priestPlay();
	}

	static void priestPlay() {
		int userInput=Board.getInputPlayer();
		

		
		userInput = Board.getInputPlayer();

		Player inputPlayer = Main.daoPlayers.players.get(userInput );
		System.out.println(inputPlayer.getPlayerNumber());
		System.out.println(Main.daoPlayers.players.get(userInput ).showCard());

	}
}
