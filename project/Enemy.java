public interface Enemy {
	public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger);
	public boolean checkInventory(Player player, GameManager gm, UI ui);
}