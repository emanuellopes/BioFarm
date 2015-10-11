package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import ElementosIteraveis.Cereal;
import ElementosIteraveis.Pinto;

public class EstadoPinto extends EstadosGalinhas_pinto{

	/*---------Construtor---------*/
	public EstadoPinto(Animais pinto) {
		this.galinha_pinto = pinto;
	}
	//verifica se pode receber
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Agua || e instanceof Cereal) ? true : false;
	}
	//recebe um fornecivel
	@Override
	public void receberFornecivel(Fornecivel e) {
		if (((Pinto)galinha_pinto).getEstado() == false) {
			if (galinha_pinto.getcontadorAgua() >= 1 && galinha_pinto.getcontadorComida() >= 2
					&& galinha_pinto.getContadorIteracoes() < 10) {
				//activa o pinto
				((Pinto)galinha_pinto).ativar();
				galinha_pinto.resetContadores();
			}
		}
	}

	//se pode fornecer
	@Override
	public boolean podeFornecer() {
		return true;
	}
	//quantas unidades de comida vale
	@Override
	public long unidadesComida() {
		return 3;
	}
	
	//fornece comida
	@Override
	public Comida forneceComida() {
		return (Comida)galinha_pinto;
	}

	//iterarPinto
	@Override
	public void iterarGalinha_pinto() {
		if ((galinha_pinto.getcontadorAgua() < 1 && galinha_pinto.getcontadorComida() < 2)
				&& galinha_pinto.getContadorIteracoes() >= 10) {
			//desactivar o pinto
			((Pinto)galinha_pinto).desactivar();
			galinha_pinto.resetContadores();
		}
		if (((Pinto)galinha_pinto).getEstado() == true) {
			if (galinha_pinto.getContadorIteracoes() >= 15) {
				//caso passe no teste, remove o pinto e adiciona uma galinha no mesmo sitio
				galinha_pinto.setImagem("/imagens/galinha_sem_ovo.png");
				galinha_pinto.setEstadoGalinhas(new GalinhaInicial(galinha_pinto));
				galinha_pinto.resetContadores();
			}
		}
		if (((Pinto)galinha_pinto).getEstado() == false && galinha_pinto.getContadorIteracoes() >= 10) galinha_pinto.resetContadores();
		galinha_pinto.contadorIterar();
	}
}
