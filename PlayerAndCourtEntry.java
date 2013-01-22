package basicUserInterface;

//Java Bean

public class PlayerAndCourtEntry {
	private Player player = null;
	private Court court = null;
	
	public PlayerAndCourtEntry() {
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}
}
