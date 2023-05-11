package br.com.coder.cm.model;

import java.util.ArrayList;
import java.util.List;

import br.com.coder.cm.exception.ExplosionException;

public class Campo {

	private int line;
	private int column;
	
	
	private boolean open = false;
	private boolean undermined = false;
	private boolean marked = false;
	
	
	
	private List<Campo> neighbors =  new ArrayList();
	
	public Campo(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public boolean addNeighBors(Campo neighbor) {
		boolean differentLine = line != neighbor.line;
		boolean differentColumn = column != neighbor.column;
		boolean diagonal = differentColumn && differentLine;
		
		int deltaLine = Math.abs(line - neighbor.line);
		int deltaColumn = Math.abs(column - neighbor.column);
		int delta = deltaColumn + deltaLine;
		
		
		boolean case1 = delta == 1 && !diagonal;
		boolean case2 = delta == 2 && diagonal;
		
		if(case1 || case2) {
			this.neighbors.add(neighbor);
			
			return true;
		} 
		
		
		return false;
	}
	
	
	public void changeMarking() {
		if(!this.open) {
			this.marked = !this.marked;
		}
	}
	
	public boolean openCampo() {
		
		if(!open && !marked) {
			
			this.open = true;
			
			
			if(undermined) {
				throw new ExplosionException();
			}
			
			if(neighborhoodSecurity()) {
				neighbors.forEach(t -> {
					System.out.println(t);
					t.openCampo();
				});
			}
			
			
			return true;
		}
		
		return false;
		
	}
	
	
	public int getLine() {
		return line;
	}

	public boolean isOpen() {
		return open;
	}

	public List<Campo> getNeighbors() {
		return neighbors;
	}
	
	public boolean isUndermined() {
		return this.undermined;
	}
	

	boolean neighborhoodSecurity() {
		return neighbors.stream().noneMatch(v -> v.undermined);
	}
	
	public boolean isMarked() {
		return this.marked;
	}
	
	public void minar() {
			this.undermined = true;

	}
	
	public boolean isOpened() {
		return this.open;
	}

	public boolean goalAchieved() {
		
		boolean unraveled = !this.undermined && this.open;
		boolean protectedCampo = this.undermined && this.marked;
		
		return unraveled || protectedCampo;
	}
	
	public long underminedOnNeighboourd() {
		return neighbors.stream().filter(v -> v.undermined).count();
	}
	
	void restart() {
		
		this.open = false;
		this.marked = false;
		this.undermined = false; 
		
	}
	
	public String toString() {
		
		if(this.marked) {
			return "X";
		}
		
		else if(this.open && this.undermined) {
			return "*";
		}
		else if(this.open && underminedOnNeighboourd() > 0) {
			return Long.toString(underminedOnNeighboourd());
		}
		else if(this.open) {
			return " ";
		} else {
			return "?";
		}
	}
	
	
	
}
