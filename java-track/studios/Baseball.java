
public class Baseball {
	private int mNumber;
	private String mName;
	private char mBats;
	private int mHits;
	private int mGames;
	private int mRBI;
	
	public Baseball(int number, String name, char bats, int hits, int games, int RBI){
		mNumber = number;
		mName = name;
		mBats = bats;
		mHits = hits;
		mGames = games;
		mRBI = RBI;
	}
	
	public void addRBI(int number){
		this.mRBI += number;
	}
	
	public void addHit(int number){
		this.mHits += number;
	}
	
	public void addGame(int number){
		this.mGames += number;
	}
	
	public int getHits(){
		return this.mHits;
	}
	
	public int getGames(){
		return this.mGames;
	}
	
	public int getRBI(){
		return this.mRBI;
	}
	
	public static void main(String[] args){
	Baseball player = new Baseball(32, "John", 'r', 56, 75, 100);
	player.addHit(20);
	player.addGame(50);
	player.addRBI(7);
	System.out.println(player.getHits());
	System.out.println(player.getGames());
	System.out.println(player.getRBI());
	}
}
