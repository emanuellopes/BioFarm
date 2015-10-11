package elementos;

import interfaces.Comida;
import interfaces.Fornecivel;
import main.BioFarm;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Mercado extends Elementos {
	/*
	 * Esta classe controla tudo o que tem a haver com o mercado
	 */
	/*-----construtor--------*/
	public Mercado(BioFarm biofarm) {
		super(new SingleImageCellRepresentation("/imagens/mercado.png"),biofarm);
	}

	// verificar se o elemento pode receber objectos do tipo comida
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida) ? true : false;
	}

	// receber um elemento do tipo comida
	@Override
	public void receberFornecivel(Fornecivel e) {
		// codigo para quando recebe um fornecivel
		if (e instanceof Comida
				&& (Elementos) ((Comida) e).forneceComida() != null) {
			//atualiza a informcao
			biofarm.atualizarInformacao("Elemento fornecido ao mercado - Orcamento aumentou "
					+ ((Comida) e).unidadesComida() * 10 + "$");
			biofarm.setOrcamento(biofarm.getOrcamento()
					+ ((Comida) e).unidadesComida() * 10);
			biofarm.remover((Elementos) ((Comida) e).forneceComida());
		}
	}

	// verifica se o mercado pode fornecer produtos
	@Override
	public boolean podeFornecer() {
		return false;
	}
}
