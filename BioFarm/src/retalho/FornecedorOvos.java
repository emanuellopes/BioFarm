package retalho;

import javax.swing.JLabel;

import interfaces.Comida;
import interfaces.Fornecivel;
import ElementosIteraveis.Cereal;
import main.AnimarLabel;
import main.BioFarm;
import main.Posicao;
import main.ReproduzirSom;
import elementos.Elementos;
import elementos.Ovo;


public class FornecedorOvos extends FornecedorRetalho{
	private long precoFornecivel;
	public FornecedorOvos(JLabel lblinformacao) {
		super("/imagens/ovo.png", lblinformacao);
		precoFornecivel=2*10;
	}

	@Override
	public Fornecivel getElemento(BioFarm biofarm) {
		if(biofarm.getOrcamento()>=precoFornecivel){
			new ReproduzirSom().playMusicBackground("dinheiro.wav", false);
			return new Ovo();
		}
		animarlabel.Animando("Não existe $$ Suficiente");
		new ReproduzirSom().playMusicBackground("error.wav", false);
		return null;
	}
}
