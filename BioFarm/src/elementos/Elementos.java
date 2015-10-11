package elementos;

import interfaces.Fornecedor;
import interfaces.Fornecivel;

import java.awt.Color;

import main.AnimarLabel;
import main.BioFarm;
import main.Posicao;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;

/**
 * @author  Emanuel Lopes
 */
public abstract class Elementos<T extends CellRepresentation> implements Fornecivel,Fornecedor{
	/*SuperClass Elementos que usa genericos, esta class irão englobar todos os elementos inseridos
	 * na grid
	 */
	/*---------zona variaveis---------*/
	/**
	 * @uml.property  name="imagem"
	 */
	protected T imagem;
	
	/**
	 * @uml.property  name="biofarm"
	 * @uml.associationEnd  inverse="elementos:main.Biofarm"
	 */
	protected BioFarm biofarm;
	private boolean selecionado;
	
	/**
	 * @uml.property  name="posicao"
	 * @uml.associationEnd  inverse="elementos:main.Posicao"
	 */
	private Posicao posicao;
	/*fim zona variaveis*/
	
	/*-----construtor--------*/
	public Elementos(T imagem, BioFarm biofarm) {
		super();
		this.imagem = imagem;
		this.biofarm = biofarm;
		posicao = null;
		selecionado=false;
	}
	
	//devolve a imagem
	/**
	 * @return
	 * @uml.property  name="imagem"
	 */
	public T getImagem(){
		return imagem;
	}
	
	//quando um elemento é clicado na grid muda para a cor vermelha
	public void selecionar() {
		selecionado=true;
		imagem.setBackgroundColor(new Color(191,8,0));
	}
	//deseleciona o elemento selecionado
	public void desselecionar() {
		selecionado=false;
		imagem.removeBackgroundColor();
	}
	//quando um elemento é valido muda para a cor verde
	public void elementoValido(){
		imagem.setBackgroundColor(Color.green);
	}
	//quando um elemento é inválido muda para a cor azul
	public void elementoInvalido(){
		imagem.setBackgroundColor(Color.blue);
	}
	
	//quando um elemento recebe algum objecto, a cor muda para amarelo
	public void elementoRecebe(){
		imagem.setBackgroundColor(Color.yellow);		
	}
	
	
	//devolve a posicao do elemento
	/**
	 * @return
	 * @uml.property  name="posicao"
	 */
	public Posicao getPosicao(){
		return posicao;
	}
	
	//set Posicao de um elemento
	public void setPosicao(int row, int column){
		posicao = new Posicao(row, column);
	}
}
