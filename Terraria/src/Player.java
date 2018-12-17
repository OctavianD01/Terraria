
public class Player {
	int[] pos;
	double velocity;
	
	int health;
	int stamina;
	int hunger;
	int thirst;
	
	Item[][] inventory;
	Item[] equipment;
	
	public Player(int[] pos) {
		this.pos = pos;
		velocity = 0;
		
		health = 100;
		stamina = 100;
		hunger = 0;
		thirst = 0;
		
		inventory = new Item[15][6];
		equipment = new Item[6];
	}
	
}
