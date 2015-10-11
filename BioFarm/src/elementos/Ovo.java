package elementos;

import interfaces.Comida;
import interfaces.Fornecivel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Ovo implements Comida, Fornecivel{
	
	/*---------zona variaveis---------*/
	private SingleImageCellRepresentation imagem;
	/*fim zona variaveis*/
	
	/*-----construtor--------*/
	public Ovo() {
		super();
		this.imagem = new SingleImageCellRepresentation("/imagens/ovo.png");
	}
	
	//devolve as unidades de comida
	@Override
	public long unidadesComida() {
		return 2;
	}

	//fornece a comida, neste caso fornece se estiver junto com a galinha
	@Override
	public Comida forneceComida() {
		return null;
	}

	//estas funções em baixo servem para que o elemento ovo seja do tipo fornecivel
	@Override
	public boolean podeReceber(Fornecivel e) {
		return false;
	}

	@Override
	public void receberFornecivel(Fornecivel e) {}
}
