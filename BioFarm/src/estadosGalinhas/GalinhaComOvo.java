package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import ElementosIteraveis.Cereal;
import main.BioFarm;

public class GalinhaComOvo extends EstadosGalinhas_pinto{
	/*
	 * Esta classe controla tudo o que tem a haver com o Estado galinha com ovo
	 */
	/*---------Construtor---------*/
	public GalinhaComOvo(Animais galinha){
		this.galinha_pinto = galinha;
		galinha.setImagem("/imagens/galinha_com_ovo.png");
	}
	
	//funcao para iterar o estado da galinha
	@Override
	public void iterarGalinha_pinto() {
		if(galinha_pinto.getContadorIteracoes()>=10){
			galinha_pinto.resetContadores();
			galinha_pinto.setEstadoGalinhas(new GalinhaAChocar(galinha_pinto));
		}
		galinha_pinto.contadorIterar();
	}

	//verifica se o elemento fornecido é do tipo água ou cereal
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida || e instanceof Agua)? true: false;
	}
	
	
	@Override
	public void receberFornecivel(Fornecivel e) {
		//Esta função não faz nada porque a parte principal já está a ser implementa na classe Galinha
		//na classe galinha a funcao recebe a agua e a comida	
	}
	
	//fornece comida
	@Override
	public Comida forneceComida() {
		galinha_pinto.setEstadoGalinhas(new GalinhaInicial(galinha_pinto));
		galinha_pinto.setImagem("/imagens/galinha_sem_ovo.png");
		return null;
	}
	
	//devolve as unidades de comida
	@Override
	public long unidadesComida() {
		return 2;
	}
	//verifica se pode fornecer
	@Override
	public boolean podeFornecer() {
		return true;
	}
}
