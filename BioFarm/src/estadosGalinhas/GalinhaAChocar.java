package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import ElementosIteraveis.Cereal;

public class GalinhaAChocar extends EstadosGalinhas_pinto{
	/*
	 * Esta classe controla tudo o que tem a haver com o Estado galinha a chocar
	 */
	/*---------Construtor---------*/
	public GalinhaAChocar(Animais galinha){
		this.galinha_pinto = galinha;
		galinha.setImagem("/imagens/galinha_a_chocar.png");
	}
	//funcao para iterar o estado da galinha
	@Override
	public void iterarGalinha_pinto() {
		if (galinha_pinto.getContadorIteracoes() >= 10) {
			galinha_pinto.resetContadores();
		}
		galinha_pinto.contadorIterar();
	}

	//verifica se o elemento fornecido é do tipo água ou cereal
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida || e instanceof Agua)? true: false;
	}
	
	//recebe um fornecível
	@Override
	public void receberFornecivel(Fornecivel e) {
		if (galinha_pinto.getContadorIteracoes() <= 10
				&& galinha_pinto.getcontadorAgua() >= 5
				&& galinha_pinto.getcontadorComida() >= 10) {
				galinha_pinto.setEstadoGalinhas(new GalinhaOvoChocado(galinha_pinto));
				galinha_pinto.resetContadores();
		}
	}
	
	//forneceComida
	@Override
	public Comida forneceComida() {
		return null;
	}
	
	//devolve unidades de comida
	@Override
	public long unidadesComida() {
		return 2;
	}
	
	//verifica se pode devolver alguma coisa
	@Override
	public boolean podeFornecer() {
		return false;
	}
}
