package me.pepe.JuegoSSII.Utils;

public enum TexturePath {
	EXPLOSION("Explosion", "images/Explosion.png"),
	EXPLOSION1("Explosion1", "images/Explosion1.png"),
	EXPLOSION2("Explosion2", "images/Explosion2.png"),
	LOGO("Logo", "images/logo.png");
	

	private String name; 
	private String path;
	
	TexturePath(String name, String path) {
		this.name = name;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
}