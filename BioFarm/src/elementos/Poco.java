package elementos;

import interfaces.Agua;
import interfaces.Fornecivel;
import main.BioFarm;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Poco extends Elementos implements Agua {

	//construtor
	public Poco(BioFarm biofarm) {
		super(new SingleImageCellRepresentation("/imagens/agua.png"),biofarm);
	}
	//n√£o pode receber elementos
	@Override
	public boolean podeReceber(Fornecivel e) {
		return false;
	}

	@Override
	public void receberFornecivel(Fornecivel e) {
	}
	
	//fornece Agua
	@Override
	public Agua forneceAgua() {
		return this;
	}
	//retorna as unidades que a ·gua vale
	@Override
	public int unidadesAgua() {
		return 1;
	}
	
	//verifica se pode fornecer
	@Override
	public boolean podeFornecer() {
		return true;
	}
}
