package me.pepe.JuegoSSII.Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.pepe.GameAPI.Game.Game;
import me.pepe.GameAPI.Game.Objects.GameObject;
import me.pepe.GameAPI.Screen.Screen;
import me.pepe.GameAPI.TextureManager.Animation;
import me.pepe.GameAPI.TextureManager.Texture.Texture;
import me.pepe.GameAPI.Utils.GameAudio;
import me.pepe.GameAPI.Utils.GameLocation;
import me.pepe.GameAPI.Utils.ObjectDimension;
import me.pepe.GameAPI.Utils.Utils;
import me.pepe.GameAPI.Windows.KeyInput;
import me.pepe.GameAPI.Windows.MouseInput;
import me.pepe.GameAPI.Windows.Windows;
import me.pepe.GameAPI.Windows.Buttons.MouseButtons;
import me.pepe.JuegoSSII.Main;
import me.pepe.JuegoSSII.Objects.Button;
import me.pepe.JuegoSSII.Questions.Question;

public class GameScreen extends Screen {
	private long time = 0;
	private int money = 0;
	private int ingame = 200;
	private int selected = 0;
	private String renderSol = "";
	private Font font = new Font("Aria", Font.PLAIN, 40);
	private List<Integer> correct = new ArrayList<Integer>();
	private Question question = Main.getInstance().getQuestionManager().getRandomQuestion();
	private List<Question> questions = new ArrayList<Question>();
	private boolean roundFinished = false;
	private boolean win = false;
	private long finishTime = 0;
	public GameScreen(Windows windows, Game game) {
		super(windows, game);
		setKeyInput(new KeyInput() {
			@Override
			public void tick() {}
			@Override
			public void onKeyPressed(int key) {}
			@Override
			public void onKeyReleased(int key) {}			
		});
		setMouseInput(new MouseInput() {
			@Override
			public void tick() {}
			@Override
			public void onClick(MouseButtons mouseButton) {}
			@Override
			public void onWheelMoved(MouseButtons mouseButton) {}
			@Override
			public void onButtonPressed(MouseButtons mouseButton) {
				if (mouseButton.equals(MouseButtons.LEFT_CLICK)) {
					ArrayList<GameObject> sec_list = new ArrayList<GameObject>();
			        sec_list = (ArrayList<GameObject>) ((ArrayList<GameObject>) getGameObjects()).clone();
					for (GameObject go : sec_list) {
						if (go instanceof Button) {
							Button but = (Button) go;
							if (but.isOver()) {
								but.onClick();
							}
						}
					}
				}
			}
			@Override
			public void onButtonReleased(MouseButtons mouseButton) {}			
		});
	}
	@Override
	public void internalTick() {
		if (roundFinished && (finishTime + 2500) - System.currentTimeMillis() <= 0) {
			if (!win) {
				getGame().setScreen("winlose");
			} else {
				if (question != null) {
					questions.remove(question);
				}
			}
			if (questions.isEmpty()) {
				getGame().setScreen("winlose");
			} else {
				createGame();
			}
		}
	}
	@Override
	protected void paintLevel(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(450, 100, 300, 300);
		g.setColor(Color.BLACK);
		g.fillRect(550, 75, 100, 50);
		if (question.countSol() == 4) {
			int x = 535;
			if (!correct.contains(1)) {
				g.setColor(new Color(255, 0, 0, selected == 1 ? 255 : 100));
				g.fillRect((x+=25) - (selected == 1 ? 1 : 0), 75, selected == 1 ? 7 : 5, selected == 1 ? 40 : 35);
			} else {
				x+=25;
			}
			if (!correct.contains(2)) {
				g.setColor(new Color(0, 255, 0, selected == 2 ? 255 : 100));
				g.fillRect((x+=25) - (selected == 2 ? 1 : 0), 75, selected == 2 ? 7 : 5, selected == 2 ? 40 : 35);
			} else {
				x+=25;
			}
			if (!correct.contains(3)) {
				g.setColor(new Color(255, 255, 0, selected == 3 ? 255 : 100));
				g.fillRect((x+=25) - (selected == 3 ? 1 : 0), 75, selected == 3 ? 7 : 5, selected == 3 ? 40 : 35);
			} else {
				x+=25;
			}
			if (!correct.contains(4)) {
				g.setColor(new Color(0, 0, 255, selected == 4 ? 255 : 100));
				g.fillRect((x+=25) - (selected == 4 ? 1 : 0), 75, selected == 4 ? 7 : 5, selected == 4 ? 40 : 35);
			} else {
				x+=25;
			}
		} else {
			int x = 535;
			if (!correct.contains(1)) {
				g.setColor(new Color(255, 0, 0, selected == 1 ? 255 : 100));
				g.fillRect((x+=40) - (selected == 1 ? 1 : 0), 75, selected == 1 ? 7 : 5, selected == 1 ? 40 : 35);
			} else {
				x+=40;
			}
			if (!correct.contains(2)) {
				g.setColor(new Color(0, 0, 255, selected == 2 ? 255 : 100));
				g.fillRect((x+=40) - (selected == 2 ? 1 : 0), 75, selected == 2 ? 7 : 5, selected == 2 ? 40 : 35);
			} else {
				x+=40;
			}
		}
		g.setColor(Color.WHITE);
		g.setFont(font);
		if (roundFinished) {
			if (win) {
				drawCenteredString(g, "Dinero: +" + ingame + "€", new Rectangle(570, 240, 50, 10), font);
			} else {
				drawCenteredString(g, "Dinero: " + money + "€", new Rectangle(570, 240, 50, 10), font);
			}
		} else {
			drawCenteredString(g, "Dinero: " + money + "€", new Rectangle(115, 250, 50, 10), font);
		}
		if (!roundFinished) {
			drawCenteredString(g, "En juego: " + ingame + "€", new Rectangle(570, 240, 50, 10), font);
			drawCenteredString(g, "Tiempo: " + ((time - System.currentTimeMillis()) / 1000), new Rectangle(960, 225, 50, 10), font);	
		}
		if (roundFinished) {
			if (win) {
				g.setColor(Color.GREEN);
				drawCenteredString(g, "Respuesta correcta: " + question.getRealSolution(), new Rectangle(570, 425, 50, 10), font.deriveFont(20F));
			} else {
				g.setColor(Color.RED);
				drawCenteredString(g, "Respuesta incorrecta: " + renderSol, new Rectangle(570, 425, 50, 10), font.deriveFont(20F));
			}
		} else {
			if (renderSol.isEmpty()) {
				drawCenteredString(g, question.getQuestion(), new Rectangle(570, 425, 50, 10), font.deriveFont(20F));
			} else {
				if (question.countSol() == 2) {
					if (selected == 1) {
						g.setColor(Color.RED);
					} else if (selected == 2) {
						g.setColor(Color.BLUE);
					}
				} else {
					if (selected == 1) {
						g.setColor(Color.RED);
					} else if (selected == 2) {
						g.setColor(Color.GREEN);
					} else if (selected == 3) {
						g.setColor(Color.YELLOW);
					} else if (selected == 4) {
						g.setColor(Color.BLUE);
					}
				}
				drawCenteredString(g, renderSol, new Rectangle(570, 425, 50, 10), font.deriveFont(30F));
			}
		}
	}
	@Override
	public Color getBackground() {
		return Color.DARK_GRAY;
	}
	private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int line = 0;
	    for (String s : text.split("\r\n")) {
		    int x = rect.x + (rect.width - metrics.stringWidth(s)) / 2;
		    int y = (int) (rect.y + ((rect.height - metrics.getHeight()) / 2) + (metrics.getAscent() * 1.1));
		    g.setFont(font);
		    g.drawString(s, x, y + (line * metrics.getAscent()));
		    line++;
	    }
	}
	public void restartGame() {
		money = 0;
		questions = Main.getInstance().getQuestionManager().getQuestions();
	}
	public void createGame() {
		restartAnimations();
		win = false;
		selected = 0;
		renderSol = "";
		roundFinished = false;
		question = questions.get(Utils.random.nextInt(questions.size()));
		time = System.currentTimeMillis() + (question.getTime() * 1000);
		correct.clear();
		restartObjects(Button.class);
		if (question.countSol() == 4) {
			int x = 200;
			for (int i = 0; i < 4; i++) {
				int ii = i;
				addGameObject(new Button(i == 0 ? Color.RED : i == 1 ? Color.GREEN : i == 2 ? Color.YELLOW : Color.BLUE, "", new GameLocation(x + (200 * i), 550), getGame(), new ObjectDimension(50, 50)) {
					@Override
					public void onClick() {
						if (!roundFinished) {
							if (question.getRealSolution().equals(question.getSolution().get(ii))) {
								roundFinished = true;
								finishTime = System.currentTimeMillis();
								Animation animation = new Animation(new Texture[] {Main.getInstance().getTextureManager().getTexture("Explosion"), Main.getInstance().getTextureManager().getTexture("Explosion1"), Main.getInstance().getTextureManager().getTexture("Explosion2"), Main.getInstance().getTextureManager().getTexture("Explosion1"), Main.getInstance().getTextureManager().getTexture("Explosion")}, 200, new GameLocation(450, 100), new ObjectDimension(300, 300)) {
									@Override
									public void onFinish() {}									
								};
								addAnimation(animation);
								new GameAudio("explosion.wav") {
									@Override
									public void onFinish() {}		
								};
							} else {
								correct.add(ii+1);
								removeGameObject(this);
								if (question.getSolution().size() - correct.size() == 1) {
									money += ingame;
									roundFinished = true;
									finishTime = System.currentTimeMillis();
									win = true;
								}
							}
						}
					}
					@Override
					public void onOver() {
						if (!roundFinished) {
							selected = ii +1;
							renderSol = question.getSolution().get(ii);
						}
					}
					@Override
					public void onUnOver() {
						if (!roundFinished) {
							selected = 0;
							renderSol = "";
						}
					}
				});	
			}
		} else {
			int x = 200;
			for (int i = 0; i < 2; i++) {
				int ii = i;
				addGameObject(new Button(i == 0 ? Color.RED : Color.BLUE, "", new GameLocation(x + (600 * i), 550), getGame(), new ObjectDimension(50, 50)) {
					@Override
					public void onClick() {
						if (!roundFinished) {
							if (question.getRealSolution().equals(question.getSolution().get(ii))) {
								roundFinished = true;
								finishTime = System.currentTimeMillis();
								Animation animation = new Animation(new Texture[] {Main.getInstance().getTextureManager().getTexture("Explosion"), Main.getInstance().getTextureManager().getTexture("Explosion1"), Main.getInstance().getTextureManager().getTexture("Explosion2"), Main.getInstance().getTextureManager().getTexture("Explosion1"), Main.getInstance().getTextureManager().getTexture("Explosion")}, 200, new GameLocation(450, 100), new ObjectDimension(300, 300)) {
									@Override
									public void onFinish() {}									
								};
								addAnimation(animation);
								new GameAudio("explosion.wav") {
									@Override
									public void onFinish() {}								
								};
							} else {
								correct.add(ii+1);
								removeGameObject(this);
								if (question.getSolution().size() - correct.size() == 1) {
									money += ingame;
									roundFinished = true;
									finishTime = System.currentTimeMillis();
									win = true;
								}
							}
						}
					}
					@Override
					public void onOver() {
						if (!roundFinished) {
							selected = ii +1;
							renderSol = question.getSolution().get(ii);
						}
					}
					@Override
					public void onUnOver() {
						if (!roundFinished) {
							selected = 0;
							renderSol = "";
						}
					}
				});	
			}
		}
	}
	public boolean isWinned() {
		return win;
	}
}
