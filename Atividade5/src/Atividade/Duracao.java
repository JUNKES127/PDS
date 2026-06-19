package Atividade;

public enum Duracao {
	Mensal(0), Semestral(10), Anual(20);
	
	private int Descontos;

	private Duracao(int Descontos) {
		this.Descontos = Descontos;
	}

	public int getDescontos() {
		return Descontos;
	}

	public void setDescontos(int descontos) {
		Descontos = descontos;
	}
}
