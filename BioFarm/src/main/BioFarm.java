package main;

import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecivel;

import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JLabel;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import retalho.Retalho;
import ElementosIteraveis.Cereal;
import ElementosIteraveis.Familia;
import ElementosIteraveis.Pinto;
import elementos.Elementos;
import elementos.ElementosIterar;
import elementos.Mercado;
import elementos.Ovo;
import elementos.Poco;
import estadosGalinhas.Galinha;

/**
 * @author  Emanuel Lopes
 */
public class BioFarm implements GridPanelEventHandler {

	private GridPanel gridBiofarm;
	private JLabel lblOrcamento;
	private JLabel lblInformacao;
	/**
	 * @uml.property  name="elementos"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Elementos elementos[][];
	private LinkedList<ElementosIterar> elementositeraveis;
	/**
	 * @uml.property  name="objSelecionado"
	 * @uml.associationEnd  
	 */
	private Elementos objSelecionado;
	/**
	 * @uml.property  name="retalho"
	 * @uml.associationEnd  
	 */
	private Retalho retalho;
	/**
	 * @uml.property  name="lastElementMouseMoved"
	 * @uml.associationEnd  
	 */
	
	private Elementos lastElementMouseMoved;
	/**
	 * @uml.property  name="animarlabel"
	 * @uml.associationEnd  
	 */
	private AnimarLabel animarlabel; 
	
	// construtor
	public BioFarm(GridPanel grid, JLabel lblOrcamento, JLabel lblInformacao,
			Retalho retalho) {
		this.gridBiofarm = grid;
		this.gridBiofarm.setEventHandler(this);
		this.lblOrcamento = lblOrcamento;
		this.lblOrcamento.setText(Long.toString(1000));
		this.lblInformacao = lblInformacao;
		this.retalho = retalho;
		animarlabel = new AnimarLabel(lblInformacao);
		objSelecionado = null;
		lastElementMouseMoved = null;
		elementositeraveis = new LinkedList<ElementosIterar>();
		elementos = new Elementos[grid.getNumberOfRows()][grid
				.getNumberOfColumns()];

		// declara que todos os elementos são null
		for (Elementos[] e : elementos) {
			e = null;
		}

		// adiciona elementos na biofarm, gri principal
		adicionar(new Familia(this), new Posicao(5, 5));
		adicionar(new Cereal(this), new Posicao(3, 3));
		adicionar(new Cereal(this), new Posicao(3, 4));
		adicionar(new Cereal(this), new Posicao(3, 5));
		adicionar(new Cereal(this), new Posicao(3, 6));
		adicionar(new Cereal(this), new Posicao(3, 7));
		adicionar(new Cereal(this), new Posicao(3, 8));
		adicionar(new Cereal(this), new Posicao(0, 8));
		adicionar(new Cereal(this), new Posicao(0, 9));
		adicionar(new Cereal(this), new Posicao(0, 10));
		adicionar(new Cereal(this), new Posicao(0, 11));
		adicionar(new Cereal(this), new Posicao(0, 1));
		adicionar(new Cereal(this), new Posicao(0, 2));
		adicionar(new Cereal(this), new Posicao(5, 1));
		adicionar(new Poco(this), new Posicao(6, 6));
		adicionar(new Mercado(this), new Posicao(4, 5));
		adicionar(new Galinha(this), new Posicao(0, 7));
		adicionar(new Galinha(this), new Posicao(1, 7));
		adicionar(new Pinto(this), new Posicao(3, 8));
	}

	// Função para adicionar os elementos na grid
	public void adicionar(Elementos elemento, Posicao posicao) {
		gridBiofarm.put(posicao.getLinha(), posicao.getColuna(), elemento.getImagem());
		elemento.setPosicao(posicao.getLinha(), posicao.getColuna());
		elementos[posicao.getLinha()][posicao.getColuna()] = elemento;
		atualizar();
	}

	// Tem o mesmo efeito que a fun��o acima, mas esta adiciona os elementos que
	// interam, para uma linkedList
	public void adicionar(ElementosIterar elemento, Posicao posicao) {
		adicionar((Elementos) elemento, posicao);
		elementositeraveis.add(elemento);
	}

	// muda a imagem de um elemento
	public void mudarImagem(Elementos e) {
		gridBiofarm.clear(e.getPosicao().getLinha(), e.getPosicao().getColuna());
		gridBiofarm.put(e.getPosicao().getLinha(), e.getPosicao().getColuna(),
				e.getImagem());
		atualizar();
	}

	// atualizar a grid
	public void atualizar() {
		gridBiofarm.repaint();
	}

	// itera os elementos que se encontram na lista iterar
	public void iterar() {
		for (ElementosIterar elemento : elementositeraveis) {
			elemento.iterar();
		}
	}

	// devolve o orcamento
	public long getOrcamento() {
		return Long.parseLong(lblOrcamento.getText());
	}

	// modifica o orcamento
	public void setOrcamento(long orcamento) {
		lblOrcamento.setText(Long.toString(orcamento));
	}

	// remove os elementos da grid
	public void remover(Elementos elemento) {
		// remove o elemento da grid
		gridBiofarm.clear(elemento.getPosicao().getLinha(), elemento.getPosicao()
				.getColuna());
		// remove o elemento do array e da linkedList
		elementos[elemento.getPosicao().getLinha()][elemento.getPosicao()
				.getColuna()] = null;
		elementositeraveis.remove(elemento);
		atualizar();
	}

	@Override
	public void mouseDragged(MouseEvent arg0, int row, int column) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	// listener para quando o rato se move pela grid
	@Override
	public void mouseMoved(MouseEvent arg0, int row, int column) {
		if (objSelecionado == null || objSelecionado == elementos[row][column]
				|| elementos[row][column] == null) {
			// deseleciona o elemento ativo caso o proximo elemento seja vazio
			if (lastElementMouseMoved != null) {
				lastElementMouseMoved.desselecionar();
				atualizar();
				return;
			}
			return;
		}
		// Atraves do movimento do rato verifica se o elemtento pode receber o
		// outro elemento
		// verde pode receber
		// azul não pode receber
		if (lastElementMouseMoved != null) {
			lastElementMouseMoved.desselecionar();
		}
		if (elementos[row][column].podeReceber(objSelecionado)
				&& objSelecionado.podeFornecer()) {
			elementos[row][column].elementoValido();
		} else {
			elementos[row][column].elementoInvalido();
		}
		lastElementMouseMoved = elementos[row][column];
		atualizar();
	}

	@Override
	public void mousePressed(MouseEvent arg0, int row, int column) {
		// verifica se o retalho tem algum elemento para fornecer
		if (retalho.getSelecionado() != null) {
			Fornecivel fornecivel_temp = retalho.getSelecionado().getElemento(
					this);
			if (fornecivel_temp == null)
				return;
			if (fornecivel_temp instanceof Ovo
					&& elementos[row][column] instanceof Animais
					&& elementos[row][column].podeReceber(fornecivel_temp)) {
				((Fornecivel) elementos[row][column])
						.receberFornecivel(fornecivel_temp);
				// desconta o dinheiro do orcamento
				setOrcamento(getOrcamento()
						- ((Comida) fornecivel_temp).unidadesComida() * 10);
				animarlabel.Animando("Ovo adicionado -"+ ((Comida) fornecivel_temp).unidadesComida() * 10 +" $");
				// ao fornecer o elemento do retalho fica desselecionado
				retalho.desselecionar();
				return;
			} else if (fornecivel_temp instanceof Ovo || elementos[row][column] != null) {
				// impedir que um ovo seja plantado sem que seja na galinha e
				// caso um elemento seja !=null
				return;
			}
			adicionar((ElementosIterar) fornecivel_temp, new Posicao(row,
					column));
			// desconta o dinheiro do orcamento
			setOrcamento(getOrcamento()
					- ((Comida) fornecivel_temp).unidadesComida() * 10);
			animarlabel.Animando("Elemento adicionado -"+ ((Comida) fornecivel_temp).unidadesComida() * 10 +" $");
			retalho.desselecionar();
			return;
		}
		// verifica se o elemento pode receber e fornecer-se
		if (objSelecionado != null && elementos[row][column] != null) {
			if (elementos[row][column].podeReceber(objSelecionado)
					&& elementos[row][column] != objSelecionado
					&& objSelecionado.podeFornecer()) {
				elementos[row][column].receberFornecivel(objSelecionado);
				elementos[row][column].elementoRecebe();
			}
		}
		selecionarItem(row, column);
	}

	//atualiza a informacao da label
	public void atualizarInformacao(String text){
		animarlabel.Animando(text);
	}
	
	// seleciona um item na biofarm
	private void selecionarItem(int row, int column) {
		// verificar se o elemento da grid não é vazio
		if (elementos[row][column] != null) {
			if (objSelecionado == null) {
				elementos[row][column].selecionar();
				objSelecionado = elementos[row][column];
			} else if (objSelecionado == elementos[row][column]
					|| objSelecionado != null) {
				objSelecionado.desselecionar();
				objSelecionado = null;
			}
		}
		atualizar();
	}

	// muda os elementos de local
	@Override
	public void mouseReleased(MouseEvent arg0, int row, int column) {
		if (objSelecionado != null && elementos[row][column] == null) {
			if (objSelecionado instanceof Familia
					|| objSelecionado instanceof Poco
					|| objSelecionado instanceof Mercado)
				return;
			remover(objSelecionado);
			adicionar(objSelecionado, new Posicao(row, column));
			objSelecionado.desselecionar();
			objSelecionado = null;

		}
	}

	// devolve os elementos da biofarm
	/**
	 * @return
	 * @uml.property  name="elementos"
	 */
	public Elementos[][] getElementos() {
		return elementos;
	}
}
