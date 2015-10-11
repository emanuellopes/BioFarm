package main;

/**
 * @author  Emanuel Lopes
 */
public class Posicao {
	/**
	 * @uml.property  name="linha"
	 */
	private int linha;
	/**
	 * @uml.property  name="coluna"
	 */
	private int coluna;

	public Posicao(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}

	public Posicao(Posicao posicaoDoElemento) {
		this(posicaoDoElemento.getLinha(), posicaoDoElemento.getColuna());
	}

	/**
	 * @return
	 * @uml.property  name="linha"
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @return
	 * @uml.property  name="coluna"
	 */
	public int getColuna() {
		return coluna;
	}

	public Posicao posicaoDelta(int dLinha, int dColuna) {
		return new Posicao(linha + dLinha, coluna + dColuna);
	}

	public Posicao posicaoDelta(Posicao posicaoDelta) {
		return posicaoDelta(posicaoDelta.getLinha(), posicaoDelta.getColuna());
	}

	public boolean isAdjacente(Posicao posicao) {
		return Math.sqrt(Math.pow(linha - posicao.getLinha(), 2)
				+ Math.pow(coluna - posicao.getColuna(), 2)) == 1;
	}

	public Posicao simetrica() {
		return new Posicao(-linha, -coluna);
	}

}
