package blogz;

public abstract class Entity {
	private final int uid;
	protected static int counter = 1;
	
	public Entity(){
		this.uid = counter;
		Entity.counter = counter + 1;
	}
	
	public int getID(){
		return this.uid;
	}
	
}
