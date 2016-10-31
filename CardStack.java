import java.util.Stack;
import java.util.Collections;

public class CardStack {

	private static Stack<Card> stack;

	CardStack() {
		stack = new Stack<Card>();
		stack.push(new GuardCard());
		stack.push(new GuardCard());
		stack.push(new GuardCard());
		stack.push(new GuardCard());
		stack.push(new GuardCard()); // 5
		stack.push(new PriestCard());
		stack.push(new PriestCard()); // 2
		stack.push(new BaronCard());
		stack.push(new BaronCard()); // 2
		stack.push(new PrinceCard()); // 2
		stack.push(new KingCard());
		stack.push(new CountessCard());
		stack.push(new PrinceCard());

	}

	public static Card getCard() {
		return stack.pop();

	}

	public void shuffle() {
		Collections.shuffle(stack);
	}

	public String toString() {
		return stack.toString();
	}
}
