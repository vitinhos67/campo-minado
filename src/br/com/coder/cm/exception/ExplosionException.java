package br.com.coder.cm.exception;

public class ExplosionException extends RuntimeException {

	private static final long serialVersionUID = 933734127174063210L;

	public String getMessage() {
		return "Game Over";
	}
	
}
