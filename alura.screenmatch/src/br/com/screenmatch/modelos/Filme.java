package br.com.screenmatch.modelos;

import br.com.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel { // Todo Filme é um título

	private String diretor;

	public Filme(String nome, int anoDeLancamento) {
		this.setNome(nome);
	}


	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public int getClassificacao() {
		// TODO Auto-generated method stub
		return (int) (pegaMedia() / 2);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
	}

}
