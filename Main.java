
import java.util.Scanner;

class Main {
	static Scanner in = new Scanner(System.in);
	static DaoPlayers daoPlayers = new DaoPlayers();

	public static void main(String[] args) {

		CardStack cardStack = new CardStack();
		cardStack.shuffle();
		addPlayer();
		do {

			playerTurn();
		} while (!(CardStack.getSize() <= 1 || Board.getActivGame() < 2));
		endGame();

	}

	private static void addPlayer() {

		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();

		player1.setPlayerNumber(1);
		player2.setPlayerNumber(2);
		player3.setPlayerNumber(3);
		player4.setPlayerNumber(4);

		player1.setMyTime(0);
		player2.setMyTime(0);
		player3.setMyTime(0);
		player4.setMyTime(0);

		player1.setActive(false);
		player2.setActive(false);
		player3.setActive(false);
		player4.setActive(false);
		int numberOfPlayers;

		do {
			System.out.println("How many players will play");
			numberOfPlayers = in.nextInt();
			switch (numberOfPlayers) {
			case 4:
				player1.setActive(true);
				player2.setActive(true);
				player3.setActive(true);
				player4.setActive(true);

				player1.getCard();
				player2.getCard();
				player3.getCard();
				player4.getCard();

				break;
			case 3:
				player1.setActive(true);
				player2.setActive(true);
				player3.setActive(true);

				player1.getCard();
				player2.getCard();
				player3.getCard();

				break;

			case 2:
				player1.setActive(true);
				player2.setActive(true);

				player1.getCard();
				player2.getCard();
				break;

			default:
				System.out.println("You should choose since 2 to 4 players");

			}
		} while (!(numberOfPlayers == 4 || numberOfPlayers == 3 || numberOfPlayers == 2));
		daoPlayers.addPlayer(player1);
		daoPlayers.addPlayer(player2);
		daoPlayers.addPlayer(player3);
		daoPlayers.addPlayer(player4);
	}

	private static void playerTurn() {

		Board.setActivGame(4);

		for (int i = 0; i < 4; i++) {

			if (Board.getActivGame() < 2) {
				System.out.println("You are alone in the castle");
				break;

			}
			System.out.println("----");
			System.out.println("Card on CardStack are" + CardStack.getSize());
			if (CardStack.getSize() <= 1 || Board.getActivGame() < 2) {
				break;
			}
			Player nowPlayer = daoPlayers.getPlayer().get(i);
			if (nowPlayer.getActiv() == false) {
				int a = Board.getActivGame() - 1;
				Board.setActivGame(a);

				System.out.print("Player " + nowPlayer.getPlayerNumber() + " is not in Game");

			} else {
				nowPlayer.setMyTime(1);
				nowPlayer.getCard(); // DOBIERANIE KARTY
				int loadUserInput;
				Card inputCard;

				do {
					do {
						System.out.println("Player" + nowPlayer.getPlayerNumber());
						System.out.println("Twoje karty");
						System.out.println(nowPlayer.showCard()); // POKAZYWANIE
																	// KART

						System.out.println("Wybierz karte (1 lub 2)");

						Board.checkCountess();
						loadUserInput = in.nextInt();
					} while (loadUserInput > 2 || loadUserInput < 1);
					int userInput = loadUserInput - 1;
					inputCard = nowPlayer.hand.get(userInput);
					System.out.println(inputCard);
					nowPlayer.disscard.add(inputCard);

				} while (Board.getiHaveCountess() == 1 && (inputCard.getNumber() == 5 || inputCard.getNumber() == 6));

				switch (inputCard.getNumber()) { // ZAGRYWANIE KARTY
				case 1:
					GuardCard.play();
					break;
				case 2:
					PriestCard.play();
					break;
				case 3:
					BaronCard.play();
					break;
				case 4:
					HandmaidCard.play();
					break;
				case 5:
					PrinceCard.play();
					break;
				case 6:
					KingCard.play();
					break;
				case 7:
					CountessCard.play();
					break;
				case 8:
					PrincessCard.play();
					break;
				default:
					System.out.println("You should choice number on your hand(first 1 or second 2");
				}
				nowPlayer.hand.remove(inputCard);
				nowPlayer.setMyTime(0);

			}

		}
	}

	private static void endGame() {
		System.out.println("End Game");
		System.out.println("End Game");
		System.out.println(" -<>-");

		//for (int x = 0; x < winPlayers.size(); x++) {
		//	System.out.print(winPlayers.get(x).getPlayerNumber());
		//	System.out.println(winPlayers.get(x).getCard());

		//}

	}
}