import java.util.regex.Pattern;

public class Board {
	private static int iHaveCountess = 0;
	private static int activGame = 4;
	private static int inputPlayer = 0;
	private static int noCanPlay=0;

	public static int getNoCanPlay() {
		return noCanPlay;
	}

	public static void setNoCanPlay(int noCanPlay) {
		Board.noCanPlay = noCanPlay;
	}

	public static int getInputPlayer() {
		return inputPlayer;
	}

	public static int getActivGame() {
		return activGame;
	}

	public static void setActivGame(int activGame) {
		Board.activGame = activGame;
	}

	public static void setInputPlayer(int inputPlayer) {
		Board.inputPlayer = inputPlayer;
	}

	public static int getiHaveCountess() {
		return iHaveCountess;
	}

	public static void setiHaveCountess(int iHaveCountess) {
		Board.iHaveCountess = iHaveCountess;
	}

	public static void CheckPlayer(boolean onHimSelf) {
		Board.setInputPlayer(0);
		Board.setNoCanPlay(0);

		boolean activeInputPlayer;
		String loadInputPlayer;
		int good;
		int allPlayerhaveHandMaidChack = 0;
		
		for (int x = 0; x < 4; x++) {
			int b = 0;
			if (Main.daoPlayers.players.get(x).getActiv() == true) {
				int a = Main.daoPlayers.players.get(x).disscard.size() - 1;
				if (a > 0) {
					b = Main.daoPlayers.players.get(x).disscard.get(a).getNumber();
				}

				if (b == 4) {
					allPlayerhaveHandMaidChack += 1;

				}
			} else {
				allPlayerhaveHandMaidChack += 1;
			}

		}
		if (!(allPlayerhaveHandMaidChack > 2 && onHimSelf == false)) {
			do {
				good = 1;
				// czy liczba i czy 1 do 4
				do {
					System.out.println("Choice player ");
					loadInputPlayer = Main.in.next();
					Pattern goodNumber = Pattern.compile("[1-4]");
					if (goodNumber.matcher(loadInputPlayer).matches()) {

						try {
							inputPlayer = Integer.valueOf(loadInputPlayer);

						} catch (NumberFormatException nfe) {
							System.out.print("Somethink Wrong , choice number since 1 to 4");
						}

					} else {
						System.out.print("choice number player(1-4)");

					}

				} while (inputPlayer == 0);

				System.out.println("------");
				inputPlayer -= 1;// odejmuje 1 zeby ponizej mogl znalesc w
									// tablicy

				activeInputPlayer = Main.daoPlayers.getPlayer().get(inputPlayer).getActiv();

				// Czy aktywny?else Czy to ja ?
				if (activeInputPlayer == false) {
					good = 0;
					System.out.println("This player is not in Game, choice another player, please");

				} else {

					if (Main.daoPlayers.players.get(inputPlayer).getMyTime() == 1 && onHimSelf == false) {

						good = 0;
						System.out.print("You can't play on youself, choice again");
					}

				}
				// Czy ma pokojowke?
				int isItHandMaid = (Main.daoPlayers.players.get(inputPlayer).disscard.size()) - 1;

				if (isItHandMaid >= 0) {

					if (Main.daoPlayers.players.get(inputPlayer).disscard.get(isItHandMaid).getNumber() == 4) {
						good = 0;
						System.out.println(inputPlayer + "play Handmaid you can't do him anythink");
					}
				}

			} while (good == 0);
			// pokojowka?

			Board.setInputPlayer(inputPlayer);
		} else {
			System.out.println("Everyboady have Handmaid, and you can't play on yourself... sorry");
			Board.setNoCanPlay(1);

		}

	}

	public static void checkCountess() {
		int iAmThisNumber = 0;
		for (int x = 0; x < 4; x++) {
			int a = Main.daoPlayers.players.get(x).getMyTime();

			if (a == 1) {
				iAmThisNumber = x;
				break;
			}

		}
		Board.setiHaveCountess(0);
		int myNumberCard1 = Main.daoPlayers.players.get(iAmThisNumber).hand.get(0).getNumber();
		int myNumberCard2 = Main.daoPlayers.players.get(iAmThisNumber).hand.get(1).getNumber();
		if ((myNumberCard1 == 7 && myNumberCard1 == 6) || (myNumberCard2 == 7 && myNumberCard2 == 6)
				|| (myNumberCard1 == 7 && myNumberCard2 == 5) || (myNumberCard1 == 7 && myNumberCard2 == 5)) {
			System.out.println("You can't play King or Prince card when you have Countress Card");
			Board.setiHaveCountess(1);

		}
	}
}
