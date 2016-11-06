import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private int PlayerNumber;
	private boolean active;
	private int myTime;

	public int getMyTime() {
		return myTime;
	}

	public void setMyTime(int myTime) {
		this.myTime = myTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean getActiv() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setPlayerNumber(Integer number) {
		this.PlayerNumber = number;
	}

	public int getPlayerNumber() {
		return PlayerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getCard() {
		hand.add(CardStack.getCard());

	}

	public List<Card> showCard() {
		return hand;
	}

	public void losse() {
		active = false;
		disscard.add(hand.get(0));
		System.out.println(hand.get(0));
		hand.remove(0);

	}

	public List<Card> hand = new ArrayList<Card>(2);
	public List<Card> disscard = new ArrayList<Card>();

}