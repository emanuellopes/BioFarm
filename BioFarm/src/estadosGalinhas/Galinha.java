package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import main.BioFarm;
import main.ReproduzirSom;
import pt.ipleiria.estg.dei.gridpanel.SingleImageWithStateCellRepresentation;
import ElementosIteraveis.Cereal;
import elementos.Elementos;
import elementos.ElementosIterar;
import elementos.Ovo;

/**
 * @author  Emanuel Lopes
 */
public class Galinha extends ElementosIterar implements Fornecivel, Comida, Animais{
	/*
	 * Esta classe controla tudo o que tem a haver com os Cereais
	 */
	/*---------zona variaveis---------*/
	/**
	 * @uml.property  name="estadoGalinha"
	 * @uml.associationEnd  
	 */
	private EstadosGalinhas_pinto estadoGalinha;
	/*fim zona variaveis*/
	
	/*-----construtor--------*/
	public Galinha(BioFarm biofarm){
		super(new SingleImageWithStateCellRepresentation("/imagens/galinha_sem_ovo.png"),biofarm);
		iteracoesSemReceber=1;
		contadorComida = 0;
		contadorAgua = 0;
		estadoGalinha = new GalinhaInicial(this);
	}
	//devolve a biofarm
	public BioFarm getBiofarm(){
		return biofarm;
	}
	/*
	 * iterar a galinha, que irão delegar para os vários estados
	 */
	public void iterar(){
		if (Math.random()<0.05)
			new ReproduzirSom().playMusicBackground("galinha.wav", false);
		estadoGalinha.iterarGalinha_pinto();
	}
	

	//reset aos contadores
	public void resetContadores(){
		iteracoesSemReceber=0;
		contadorAgua=0;
		contadorComida= 0;
	}
		
	//modifica o estado da galinha
	public void setEstadoGalinhas(EstadosGalinhas_pinto estado){
		estadoGalinha= estado;
	}
	//devolve o estado das galinhas
	public EstadosGalinhas_pinto getEstadoGalinhas(){
		return estadoGalinha;
	}
	
	/*
	 * verifica se o elemento fornecido, pode ser recebido
	 * O metodo irá ser delegado para o estadoGalinha
	 */
	@Override
	public boolean podeReceber(Fornecivel e) {
		return estadoGalinha.podeReceber(e);
	}

	/*
	 * Recebe a Agua e a comida e delega o resto da funÃ§Ã£o para o EstadoGalinha
	 */
	@Override
	public void receberFornecivel(Fornecivel e) {
		//atualiza os contadores e delega para o estado receberForncecivel
		if(e instanceof Comida && !(e instanceof Ovo)){
			contadorComida++;
			//remove o cereal da biofarm
			biofarm.remover((Elementos) ((Comida )e).forneceComida());
			biofarm.atualizarInformacao("Recebeu 1 unidade de Cereal - Comida ="+contadorComida);
		}else if(e instanceof Agua){
			contadorAgua++;
			biofarm.atualizarInformacao("Recebeu 1 unidade de Ã?gua - Agua="+contadorAgua);
		}
		estadoGalinha.receberFornecivel(e);
	}

	//devolve as unidades de comida
	@Override
	public long unidadesComida() {
		return estadoGalinha.unidadesComida();
	}

	//delega para o estadoGalinha
	@Override
	public boolean podeFornecer() {
		return estadoGalinha.podeFornecer();
	}

	//delega para o estadoGalinha
	@Override
	public Comida forneceComida() {
		return estadoGalinha.forneceComida();
	}
}
