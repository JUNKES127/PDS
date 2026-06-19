package Atividade;

public enum Semanal {
	Duas(0), Três(20), Cinco(50);
	
	private int acrescimo;

	private Semanal(int acrescimo) {
		this.acrescimo = acrescimo;
	}

	public int getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(int acrescimo) {
		this.acrescimo = acrescimo;
	}
}
