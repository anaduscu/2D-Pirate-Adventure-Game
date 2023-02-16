public class Characters{

	/*
	 * The Character class contains all the common relevant information about 
     * a respective chracter (Player or Animal) including name and death status
	 */

	/*instance variables*/
	private boolean death;

	public Characters(boolean death) {
		this.death = death;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
    }

	public boolean getDeath() {
		return this.death;
    }

}// end of Character class