package me.pepe.JuegoSSII.Questions;

import java.util.List;

public class Question {
	private String question;
	private List<String> sol;
	private String realSol;
	private int countsol = 0;
	private int time;
	public Question(String question, List<String> sol, String realSol, int time) {
		this.question = question;
		this.sol = sol;
		this.realSol = realSol;
		this.time = time;
		countsol = sol.size();
	}
	public String getQuestion() {
		return question;
	}
	public List<String> getSolution() {
		return sol;
	}
	public String getRealSolution() {
		return realSol;
	}
	public int countSol() {
		return countsol;
	}
	public int getTime() {
		return time;
	}
}
