package br.com.screenmatch.modelos;

import br.com.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel{  //Todo Filme é um título

	private String diretor;

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
	
}
