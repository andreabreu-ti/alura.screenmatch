package br.com.screenmatch.modelos;

public class Serie extends Titulo {

	public Serie(String nome, int anoDeLancamento) {
		super(nome, anoDeLancamento);
	}

	private int temporadas;
	private boolean ativa;
	private int episodiosPorTemporada;
	private int minutosPorEpisodio;

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public int getEpisodiosPorTemporada() {
		return episodiosPorTemporada;
	}

	public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
		this.episodiosPorTemporada = episodiosPorTemporada;
	}

	public int getMinutosPorEpisodio() {
		return minutosPorEpisodio;
	}

	public void setMinutosPorEpisodio(int minutosPorEpisodio) {
		this.minutosPorEpisodio = minutosPorEpisodio;
	}

	// Anotação @Override - possibilita a sobrescrita de um método
	@Override
	public int getDuracaoEmMinutos() {

		return temporadas * episodiosPorTemporada * minutosPorEpisodio;
	}

}
