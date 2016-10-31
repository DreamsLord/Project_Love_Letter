
public class GuardCard extends Card {

	GuardCard() {
		super("Guard", 1);

	}

	public static void play() {
		boolean activeInputPlayer;
		String loadInputPlayer;
		int inputPlayer = 0;

		do {
			do {// Sprawdza Czy to wczytana wartość jest liczba
				System.out.println("Choice player who you want to kill his hand");
				loadInputPlayer = Main.in.next();

				try {
					inputPlayer = Integer.valueOf(loadInputPlayer);

				} catch (NumberFormatException nfe) {
					System.out.print("Zły format , wpisz liczbę np 1 lub 4");
				}
			} while (inputPlayer == 0);
			inputPlayer -=1;// odejmuje 1 zeby ponizej mogl znalesc w tablicy
			// Sprawdza czy wybieramy aktywnego gracza

			if (inputPlayer < Main.daoPlayers.players.size() && inputPlayer >= 0) {
				

				activeInputPlayer = Main.daoPlayers.getPlayer().get(inputPlayer).getActiv();
				System.out.println("activeInputPlayer" + activeInputPlayer);
				System.out.println("input player" + inputPlayer);

				if (activeInputPlayer == false) {
					System.out.println("This player is not in Game, choice another player, please");
				}
			} else {
				System.out.println("Players in Game is only 4, Try choice again");
			}

		} while (activeInputPlayer = false || 0 > inputPlayer && inputPlayer > 5);

		System.out.println("wchice number of card has this player");

		int inputCard = Main.in.nextInt();

		int playerCard;
		playerCard = Main.daoPlayers.players.get(inputPlayer).hand.get(0).getNumber();
		System.out.println(playerCard);
		System.out.println(inputCard);

		if (playerCard == inputCard) {
			Main.daoPlayers.players.get(inputPlayer).losse();
			System.out.println("You are right!");
		} else {
			System.out.println("You are wrong");

		}
	}
}
