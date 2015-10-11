package ElementosIteraveis;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import main.BioFarm;
import elementos.ElementosComEstado;
import estadosGalinhas.EstadoPinto;
import estadosGalinhas.EstadosGalinhas_pinto;

/**
 * @author  Emanuel Lopes
 */
public class Pinto extends ElementosComEstado implements Comida, Animais {
	/*
	 * Esta classe controla tudo o que tem a haver com os Cereais
	 */
	/**
	 * @uml.property  name="estadoPinto"
	 * @uml.associationEnd  
	 */
	private EstadosGalinhas_pinto estadoPinto;
	/*fim zona variaveis*/

	/*-----construtor--------*/
	public Pinto(BioFarm biofarm) {
		super(biofarm, "/imagens/pinto.png");
		contadorComida = 0;
		contadorAgua = 0;
		iteracoesSemReceber = 1;
		estadoPinto = new EstadoPinto(this);
	}
	

	//devolve as unidades de comida
	@Override
	public long unidadesComida() {
		return 3;
	}

	//funcao para iterar o cereal
	public void iterar() {
		//cenas para testar
		//contadorAgua++;
		//contadorCereal++;
		//acabou cenas de teste
		estadoPinto.iterarGalinha_pinto();
	}

	//verifica se o elemento fornecido Ã© do tipo Ã¡gua ou cereal
	@Override
	public boolean podeReceber(Fornecivel e) {
		return estadoPinto.podeReceber(e);
	}

	//recebe um fornecível
	@Override
	public void receberFornecivel(Fornecivel e) {
		if (e instanceof Cereal) {
			contadorComida++;
			biofarm.remover(((Cereal) e));
			biofarm.atualizarInformacao("Recebeu 1 unidade de Cereal - Cereal ="+contadorComida);
		} else if (e instanceof Agua) {
			contadorAgua++;
			biofarm.atualizarInformacao("Recebeu 1 unidade de água - Agua="+contadorAgua);
		}
		estadoPinto.receberFornecivel(e);
	}

	//reset aos contadores
	public void resetContadores() {
		iteracoesSemReceber = 0;
		contadorAgua = 0;
		contadorComida = 0;
	}
	
	//devolve se o objecto se pode ser fornecido a outro elemento da biofarm
	@Override
	public boolean podeFornecer() {
		return estadoPinto.podeFornecer();
	}

	//devolve comida
	@Override
	public Comida forneceComida() {
		return estadoPinto.forneceComida();
	}
 
	@Override
	public BioFarm getBiofarm() {
		return biofarm;
	}
	@Override
	public void setEstadoGalinhas(EstadosGalinhas_pinto estado) {
		estadoPinto=estado;		
	}
}
