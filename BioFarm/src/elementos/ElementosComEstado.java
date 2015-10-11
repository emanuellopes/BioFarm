package elementos;

import main.BioFarm;
import pt.ipleiria.estg.dei.gridpanel.SingleImageWithStateCellRepresentation;

/**
 * @author  Emanuel Lopes
 */
public abstract class ElementosComEstado extends ElementosIterar{

	/*---------zona variaveis---------*/
	/**
	 * @uml.property  name="estado"
	 */
	private boolean estado;
	/*fim zona variaveis*/
	/*---------zona variaveis---------*/
	/*fim zona variaveis*/
	/*-----construtor--------*/
	public ElementosComEstado(BioFarm biofarm,String caminho) {
		super(new SingleImageWithStateCellRepresentation(caminho),biofarm);
		estado=true;
	}

	//funcao para iterar os elementos, o codigo para esta funcao esta em cada elemento
	@Override
	public void iterar() {}
	
	//desactiva o elemento
	public void desactivar(){
		estado=false;
		imagem.disable();
		biofarm.atualizar();
	}
	
	//ativa o elemento
	public void ativar(){
		estado=true;
		imagem.enable();
		biofarm.atualizar();
	}
	
	//devolve o estado do elemento
	/**
	 * @return
	 * @uml.property  name="estado"
	 */
	public boolean getEstado(){
		return estado;
	}
}
