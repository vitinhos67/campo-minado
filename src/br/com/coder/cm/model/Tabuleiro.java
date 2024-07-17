package br.com.coder.cm.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {
	private int lines;
	private int columns;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();
	
	public Tabuleiro(int lines, int columns, int minas) {
		this.lines = lines;
		this.columns = columns;
		this.minas = minas;
		
		
		generateCampos();
		associateNeighbor();
		raffleMines();
	}

	private void raffleMines() {
		int mines = 0;
		do {
			Predicate<Campo> minado = c -> c.isUndermined();
			mines = (int) this.campos.stream().filter(minado).count();	
			int random = (int) (Math.random() * this.campos.size());
			campos.get(random).minar();
		} while(mines < this.minas);
	
	}

	private void associateNeighbor() {
		for(Campo  c1 : campos) {
			for(Campo c2: campos) {
				c1.addNeighBors(c2);
			}
		}
		
	}

	private void generateCampos() {
		for (int line = 0; line < this.lines; line++) {
			for (int column = 0; column < this.columns; columns++) {
				campos.add(new Campo(line, column));
			}
		}
	}

	public boolean goalAchieved() {
		return this.campos.stream().allMatch(c -> c.goalAchieved());
	}
	
	
	public void restart() {
		campos.stream().forEach(c -> c.restart());
	}
	
	
	
}
