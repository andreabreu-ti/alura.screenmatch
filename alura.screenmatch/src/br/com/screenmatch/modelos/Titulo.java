package br.com.screenmatch.modelos;

public class Titulo {

	/*
	 * Conceito de Classe --> Especificar o que o Filme tem Abstração: O que o filme
	 * tem Tudo que uma classe tem e o que uma classe faz Informações importantes
	 * que a classe precisa / Informações importantes
	 */

	/*
	 * Private Modificadores de acesso / ou Visibilidade
	 */
	private String nome;
	private int anoDeLancamento;
	private boolean incluidoNoPlano;
	private double somaAvaliacao;
	private int totalDeAvaliacao;
	private int duracaoEmMinutos;

	/*
	 * Metodo acessor do modificador (Privado)
	 */
	public int getTotalDeAvaliacao() {
		return totalDeAvaliacao;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public boolean isIncluidoNoPlano() {
		return incluidoNoPlano;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public void setIncluidoNoPlano(boolean incluidoNoPlano) {
		this.incluidoNoPlano = incluidoNoPlano;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	/*
	 * Métodos - vão fazer alguma coisa
	 */
	public void exibeFichaTecnica() {
		System.out.println("Nome do Filme: " + nome);
		System.out.println("Ano de Lançamento: " + anoDeLancamento);
	}

	public void avalia(double nota) {
		somaAvaliacao += nota;
		totalDeAvaliacao++;
	}

	public double pegaMedia() {
		return somaAvaliacao / totalDeAvaliacao;
	}
}
