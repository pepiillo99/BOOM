package me.pepe.JuegoSSII;

import java.awt.Toolkit;

import me.pepe.GameAPI.GameAPI;
import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.TextureManager.TextureManager;
import me.pepe.JuegoSSII.Questions.QuestionManager;
import me.pepe.JuegoSSII.Screen.LoadScreen;

public class Main {
	public static void main(String args[]) {
		new Main();
	}
	private static Main instance;
	private QuestionManager questionManager;
	private GameAPI gameAPI;
	public Main() {
		instance = this;
		this.questionManager = new QuestionManager();
		this.gameAPI = new GameAPI();
		Game game = new Game("GameSSII", 1200, 700, Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/logo.png")));
		game.getWindows().setResizable(false);
		game.getScreenManager().registerNewScreen("load", new LoadScreen(game.getWindows(), game));
		game.setScreen("load");
		game.start();
	}
	public static Main getInstance() {
		return instance;
	}
	public QuestionManager getQuestionManager() {
		return questionManager;
	}
	public TextureManager getTextureManager() {
		return gameAPI.getTextureManager();
	}
}
