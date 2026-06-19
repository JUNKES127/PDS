package model;

public class Pessoa {
	private String nome, cpf, email;
	private int idade;

	public Pessoa(String nome, String cpf, String email, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nopme) {
		this.nome = nopme;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	

}
