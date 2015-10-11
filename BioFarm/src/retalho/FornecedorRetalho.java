package retalho;

import interfaces.Comida;
import interfaces.Fornecivel;

import java.awt.Color;

import javax.swing.JLabel;

import main.AnimarLabel;
import main.BioFarm;
import main.Posicao;
import ElementosIteraveis.Cereal;
import elementos.Elementos;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

/**
 * @author  Emanuel Lopes
 */
public abstract class FornecedorRetalho{

	
	/**
	 * @uml.property  name="imagem"
	 */
	protected SingleImageCellRepresentation imagem;
	protected boolean selecionado;
	protected JLabel lblinformacao;
	/**
	 * @uml.property  name="animarlabel"
	 * @uml.associationEnd  
	 */
	protected AnimarLabel animarlabel;
	public FornecedorRetalho(String caminhoImagem, JLabel lblinformacao) {
		super();
		this.imagem = new SingleImageCellRepresentation(caminhoImagem);
		this.lblinformacao = lblinformacao;
		selecionado = false;
		animarlabel = new AnimarLabel(lblinformacao);
	}

	/**
	 * @return
	 * @uml.property  name="imagem"
	 */
	public SingleImageCellRepresentation getImagem() {
		return imagem;
	}

	public void selecionar() {
		selecionado=true;
		imagem.setBackgroundColor(new Color(191,8,0));
	}

	public void desselecionar() {
		selecionado=false;
		imagem.removeBackgroundColor();
	}
	
	public abstract Fornecivel getElemento(BioFarm biofarm);
}