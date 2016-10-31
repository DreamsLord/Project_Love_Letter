import java.util.ArrayList;
import java.util.List;

public class DaoPlayers {
	List<Player> players = new ArrayList<Player>(4);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public void addPlayer(Player player){
		players.add(player);
	}
	public List<Player>getPlayer(){
		return players;
	}

	
	
	
	

}
