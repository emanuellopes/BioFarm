package ElementosIteraveis;

import interfaces.Agua;
import interfaces.Comida;
import interfaces.Fornecivel;
import main.BioFarm;
import elementos.Elementos;
import elementos.ElementosComEstado;


public class Familia extends ElementosComEstado{
	/*
	 * Esta classe controla tudo o que tem a haver com a Familia
	 */
	
	
	/*-----construtor--------*/
	public Familia(BioFarm biofarm) {
		super(biofarm,"/imagens/familia.png");
		iteracoesSemReceber=1;
		contadorAgua=0;
		contadorComida=0;
	}
	
	//funcao para iterar os objectos
	public void iterar(){
		if(getEstado()==true){
			if((contadorAgua<5 || contadorComida<10)&& iteracoesSemReceber>=20){
				resetContadores();
				desactivar();
			}
		}
		iteracoesSemReceber++;
	}
	
	//reset aos contadores
	private void resetContadores(){
		iteracoesSemReceber=0;
		contadorAgua=0;
		contadorComida= 0;
	}
	//verifica se o elemento pode ser recebido
	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida || e instanceof Agua)? true : false;
	}

	//receber o elemento fornecivel
	@Override
	public void receberFornecivel(Fornecivel e) {
		if(e instanceof Agua){
			contadorAgua++;
			biofarm.atualizarInformacao("Recebeu 1 unidade de Ã�gua - Agua="+contadorAgua);
		}else if(e instanceof Comida && (Elementos) ((Comida )e).forneceComida()!=null){
			contadorComida++;
			biofarm.atualizarInformacao("Recebeu 1 unidade de Comida - Comida ="+contadorComida);
			biofarm.remover((Elementos) ((Comida )e).forneceComida());
		}
		if (contadorAgua>=5 && contadorComida>=20 && iteracoesSemReceber<=20){
			ativar();
			resetContadores();
		}
	}
	//verifica se o elemento pode fornecer outro elemento da biofarm
	@Override
	public boolean podeFornecer() {
		return false;
	}
}
