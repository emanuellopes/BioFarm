package estadosGalinhas;

import interfaces.Agua;
import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;
import elementos.Elementos;
import elementos.Ovo;
import ElementosIteraveis.Pinto;
import main.BioFarm;
import main.Posicao;


public class GalinhaOvoChocado extends EstadosGalinhas_pinto{
	/*
	 * Esta classe controla tudo o que tem a haver com o Estado galinha Inicial
	 */
	/*---------Construtor---------*/
	public GalinhaOvoChocado(Animais galinha_pinto){
		this.galinha_pinto = galinha_pinto;
		galinha_pinto.setImagem("/imagens/galinha_sem_ovo.png");
		//fornece o pinto á  biofarm
		fornecePinto(((Elementos) galinha_pinto).getPosicao().getLinha(), 
				((Elementos) galinha_pinto).getPosicao().getColuna(),1, galinha_pinto.getBiofarm());
	}
	
	//funcao para calcular e devolver um pinto Ã  biofarm
	//A função é recursiva, é chamada se não existir um local para plantar o pinto
	private void fornecePinto(int linha, int coluna, int posicaoAdjacente, BioFarm biofarm) {
		Elementos elementos[][]= biofarm.getElementos();
		int minLinha=linha-posicaoAdjacente;
		int maxLinha=linha+posicaoAdjacente;
		int minColuna= coluna-posicaoAdjacente;
		int maxColuna = coluna+posicaoAdjacente;
		if(minLinha<0){
			minLinha=0;
		}else if(maxLinha>elementos.length){
			maxLinha=elementos.length;
		}
		if(minColuna<0){
			minColuna=0;
		}else if(maxColuna>elementos[0].length){
			maxColuna=elementos[0].length-1;
		}

		for(int i=minLinha;i<maxLinha; i++){
			for(int j=minColuna;j<maxColuna; j++){
				if(elementos[i][j]==null){
					biofarm.adicionar(new Pinto(biofarm), new Posicao(i, j));
					return;
				}
			}
		}
		fornecePinto(linha, coluna, posicaoAdjacente+1, biofarm);
	}
	
	@Override
	public void iterarGalinha_pinto() {	
		//modifica para a galinha inicial na primeira iteracao
		galinha_pinto.setEstadoGalinhas(new GalinhaInicial(galinha_pinto));
		galinha_pinto.resetContadores();
	}

	@Override
	public boolean podeReceber(Fornecivel e) {
		return (e instanceof Comida || e instanceof Agua)? true: false;
	}

	@Override
	public void receberFornecivel(Fornecivel e) {
	}

	@Override
	public boolean podeFornecer() {
		return false;
	}

	@Override
	public long unidadesComida() {
		return 0;
	}

	@Override
	public Comida forneceComida() {
		return null;
	}
}
