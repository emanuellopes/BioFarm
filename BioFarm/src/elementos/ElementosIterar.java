package elementos;

import main.BioFarm;
import pt.ipleiria.estg.dei.gridpanel.SingleImageWithStateCellRepresentation;
import interfaces.Fornecivel;

public abstract class ElementosIterar extends
		Elementos<SingleImageWithStateCellRepresentation> {
	/*
	 * Esta SuperClasse Possui­ todos os elementos que têm o metodo iterar
	 */
	/** zona variaveis */
	/**
	 * @uml.property name="iteracoesSemReceber"
	 */
	protected int iteracoesSemReceber;
	/**
	 * @uml.property name="contadorAgua"
	 */
	protected int contadorAgua;
	/**
	 * @uml.property name="contadorComida"
	 */
	protected int contadorComida;

	// construtor
	public ElementosIterar(SingleImageWithStateCellRepresentation imagem,
			BioFarm biofarm) {
		super(imagem, biofarm);
	}

	// funcao que irá ser usada para iterar os elementos
	public abstract void iterar();

	@Override
	public boolean podeReceber(Fornecivel e) {
		return false;
	}

	@Override
	public void receberFornecivel(Fornecivel e) {
	}

	@Override
	public boolean podeFornecer() {
		return false;
	}

	public void setImagem(String caminho) {
		imagem = new SingleImageWithStateCellRepresentation(caminho);
		biofarm.mudarImagem(this);
	}

	// devolve o contador da agua
	public int getcontadorAgua() {
		return contadorAgua;
	}

	// devole o contador da comida
	public int getcontadorComida() {
		return contadorComida;
	}

	// devolve o contador das iteracoes
	public int getContadorIteracoes() {
		return iteracoesSemReceber;
	}

	// aumenta o contador
	public void contadorIterar() {
		iteracoesSemReceber++;
	}
}
