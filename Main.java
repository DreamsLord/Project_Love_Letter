import java.util.Scanner;

class Main {
	static Scanner in = new Scanner(System.in);
	static DaoPlayers daoPlayers = new DaoPlayers();

	public static void main(String[] args) {

		CardStack cardStack = new CardStack();
		cardStack.shuffle();
		addPlayer();
		playerTurn();

	}

	public static void addPlayer() {

		Player player1 = new Player();  
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		
		player1.setPlayerNumber(1);
		player2.setPlayerNumber(2);
		player3.setPlayerNumber(3);
		player4.setPlayerNumber(4);
		

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

	public static void playerTurn() {
		
		for (int i = 0; i < 4; i++) {
			System.out.println( "----");
			Player nowPlayer = daoPlayers.getPlayer().get(i);
			if (nowPlayer.getActiv() == false) {
				System.out.print("Player "+ nowPlayer.getPlayerNumber()+" is not in Game");

			} else {
				nowPlayer.getCard();                    // DOBIERANIE KARTY
				int userInput;
				do {
					System.out.println( "Player" + nowPlayer.getPlayerNumber());
					System.out.println("Twoje karty");
					System.out.println(nowPlayer.showCard());                    //POKAZYWANIE KART

					System.out.println("Wybierz karte (1 lub 2)");

					userInput = in.nextInt() - 1;
					Card inputCard = nowPlayer.hand.get(userInput);
					System.out.println(inputCard);
					nowPlayer.disscard.add(inputCard);
					nowPlayer.hand.remove(inputCard);

					switch (inputCard.getNumber()) {                          // ZAGRYWANIE KARTY
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
				} while (userInput > 2 || userInput < -1);

			}

		}
	}
}
