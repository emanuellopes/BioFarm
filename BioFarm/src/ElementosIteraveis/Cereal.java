package ElementosIteraveis;

import interfaces.Agua;
import interfaces.Comida;
import interfaces.Fornecivel;
import main.BioFarm;
import elementos.ElementosComEstado;

public class Cereal extends ElementosComEstado implements Comida{
	/*
	 * Esta classe controla tudo o que tem a haver com os Cereais
	 */

	/*-----construtor--------*/
	public Cereal(BioFarm biofarm){
		super(biofarm,"/imagens/cereal.png");
		iteracoesSemReceber=1;
		contadorAgua=0;
	}
	
	//funcao para iterar o cereal
	public void iterar(){
		if(getEstado()==true){
			if(iteracoesSemReceber>=10 && contadorAgua<=0){
				//desactiva o cereal
				resetContadores();
				desactivar();
			}
		}else{
			if(iteracoesSemReceber>=10){
				//faz reset ao contador caso o estado do cereal seja desactivado e
				// caso as iteracoes sejam >=10
				resetContadores();
			}
		}
		iteracoesSemReceber++;
	}

	//reset aos contadores
	public void resetContadores(){
		iteracoesSemReceber=0;
		contadorAgua=0;
	}
	
	//devolve as unidades de comida
	@Override
	public long unidadesComida(){
		return 1;
	}
	//verifica se o elemento fornecido é do tipo água
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Agua);
	}
	
	//recebe um fornecível
	@Override
	public void receberFornecivel(Fornecivel e) {
		//activa o elemento caso o fornecimento esteja dentro dos parametros
		if(e instanceof Agua){
			contadorAgua++;
			biofarm.atualizarInformacao("Recebeu 1 unidade de água");
			if(contadorAgua>=1 && iteracoesSemReceber<10){
				ativar();
				resetContadores();
			}
		}
	}

	//devolve se o objecto se pode ser fornecido a outro elemento da biofarm
	@Override
	public boolean podeFornecer() {
		return getEstado();
	}
	//devolve comida
	@Override
	public Comida forneceComida() {
		return this;
	}
}
