package Atividade;

public enum TipoDePlano {
	Básico(80.0), intermediário(120.0), Premium(180.0);
	
	private Double Valor;

	private TipoDePlano(Double Valor) {
		this.Valor = Valor;
	}

	public Double getValor() {
		return Valor;
	}
}
