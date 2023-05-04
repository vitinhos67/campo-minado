package br.com.coder.cm.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private int line;
	private int column;
	
	
	private boolean open = false;
	private boolean undermined = false;
	private boolean marked = false;
	
	private List<Campo> neighbors =  new ArrayList();
	
	Campo(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
}
