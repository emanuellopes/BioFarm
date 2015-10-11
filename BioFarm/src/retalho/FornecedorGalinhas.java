package retalho;

import interfaces.Fornecivel;

import javax.swing.JLabel;

import main.AnimarLabel;
import main.BioFarm;
import main.ReproduzirSom;
import estadosGalinhas.Galinha;




public class FornecedorGalinhas extends FornecedorRetalho{
	
	private long precoFornecivel;
	public FornecedorGalinhas(JLabel lblinformacao) {
		super("/imagens/galinha_sem_ovo.png", lblinformacao);
		precoFornecivel=10*10;
	}

	@Override
	public Fornecivel getElemento(BioFarm biofarm) {
		if(biofarm.getOrcamento()>=precoFornecivel){
			new ReproduzirSom().playMusicBackground("dinheiro.wav", false);
			return new Galinha(biofarm);
		}
		animarlabel.Animando("Não existe $$ Suficiente");
		new ReproduzirSom().playMusicBackground("error.wav", false);
		return null;
		
	}
}
