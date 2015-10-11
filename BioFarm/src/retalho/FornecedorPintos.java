package retalho;


import javax.swing.JLabel;

import interfaces.Comida;
import interfaces.Fornecivel;
import ElementosIteraveis.Cereal;
import ElementosIteraveis.Pinto;
import main.AnimarLabel;
import main.BioFarm;
import main.Posicao;
import main.ReproduzirSom;
import elementos.Elementos;

public class FornecedorPintos extends FornecedorRetalho {

	private long precoFornecivel;

	public FornecedorPintos(JLabel lblinformacao) {
		super("/imagens/pinto.png", lblinformacao);
		precoFornecivel=3*10;
	}

	@Override
	public Fornecivel getElemento(BioFarm biofarm) {
		if(biofarm.getOrcamento()>=precoFornecivel){
			new ReproduzirSom().playMusicBackground("dinheiro.wav", false);
			return new Pinto(biofarm);
		}
		animarlabel.Animando("Não existe $$ Suficiente");
		new ReproduzirSom().playMusicBackground("error.wav", false);
		return null;
	}
}
