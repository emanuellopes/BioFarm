package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecedor;
import interfaces.Fornecivel;
import elementos.Ovo;
import ElementosIteraveis.Cereal;
import main.BioFarm;
import main.Posicao;

public class GalinhaInicial extends EstadosGalinhas_pinto {
	/*
	 * Esta classe controla tudo o que tem a haver com o Estado galinha Inicial
	 */
	/*---------Construtor---------*/
	public GalinhaInicial(Animais galinha) {
		this.galinha_pinto = galinha;
	}
	//iterar estado galinha
	@Override
	public void iterarGalinha_pinto() {
		if((galinha_pinto.getcontadorComida()<3 || galinha_pinto.getcontadorAgua()<2)&& galinha_pinto.getContadorIteracoes()>=10){
			galinha_pinto.resetContadores();
		}
		galinha_pinto.contadorIterar();
	}
	
	//verifica se o elemento fornecido é do tipo água, cereal ou ovo
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida || e instanceof Agua || e instanceof Ovo)? true: false;
	}

	//recebe um fornecível
	@Override
	public void receberFornecivel(Fornecivel e) {
		//verifica se pode receber o ovo e verifica se tem as condicoes para produzir o ovo
		if((galinha_pinto.getcontadorComida()>=3 && galinha_pinto.getcontadorAgua()>=2)|| e instanceof Ovo){
			galinha_pinto.setEstadoGalinhas(new GalinhaComOvo(galinha_pinto));
			galinha_pinto.resetContadores();
		}
	}
	//devolve as unidades de comida
	@Override
	public long unidadesComida() {
		return 10;
	}

	//fornece a galinha
	@Override
	public Comida forneceComida() {
		return (Comida) galinha_pinto;
	}
	//verifica se a galinha pode fornecer
	@Override
	public boolean podeFornecer() {
		return true;
	}
}