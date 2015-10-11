package retalho;

import javax.swing.JLabel;

import interfaces.Fornecivel;
import main.AnimarLabel;
import main.BioFarm;
import main.ReproduzirSom;
import ElementosIteraveis.Cereal;


public class FornecedorCereais extends FornecedorRetalho{

	private long precoFornecivel;
	public FornecedorCereais(JLabel lblinformacao) {
		super("/imagens/cereal.png", lblinformacao);
		precoFornecivel=3*10;
	}

	@Override
	public Fornecivel getElemento(BioFarm biofarm) {
		if(biofarm.getOrcamento()>=precoFornecivel){
			new ReproduzirSom().playMusicBackground("dinheiro.wav", false);
			return new Cereal(biofarm);
		}
		animarlabel.Animando("Não existe $$ Suficiente");
		new ReproduzirSom().playMusicBackground("error.wav", false);
		return null;

	}
}
