package retalho;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;

/**
 * @author  Emanuel Lopes
 */
public class Retalho implements GridPanelEventHandler {
	/**
	 * @uml.property  name="fornecedores"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private FornecedorRetalho[] fornecedores;

	private GridPanel gridRetalho;
	/**
	 * @uml.property  name="selecionado"
	 * @uml.associationEnd  
	 */
	private FornecedorRetalho selecionado;
	private JLabel lblInformacao;
	public Retalho(GridPanel gridRetalho, JLabel lblInformacao) {
		super();
		this.gridRetalho = gridRetalho;
		this.lblInformacao = lblInformacao;
		selecionado = null;
		fornecedores = new FornecedorRetalho[gridRetalho.getNumberOfRows()];
		fornecedores[0] = new FornecedorGalinhas(lblInformacao);
		fornecedores[1] = new FornecedorOvos(lblInformacao);
		fornecedores[2] = new FornecedorPintos(lblInformacao);
		fornecedores[3] = new FornecedorCereais(this.lblInformacao);
		

		for (int i = 0; i < 4; i++) {
			adicionar(fornecedores[i], i);
		}
		gridRetalho.setEventHandler(this);
	};

	public void adicionar(FornecedorRetalho fornecedorRetalho, int i) {
		gridRetalho.put(i, 0, fornecedorRetalho.getImagem());
		atualizar();
	}

	public void atualizar() {
		gridRetalho.repaint();
	}
	
	/**
	 * @return
	 * @uml.property  name="selecionado"
	 */
	public FornecedorRetalho getSelecionado(){
		return selecionado;
	}
	
	public void desselecionar(){
		selecionado.desselecionar();
		selecionado=null;
		atualizar();
	}
	

	@Override
	public void mouseDragged(MouseEvent evt, int row, int column) {
		
	}

	@Override
	public void mouseExited(MouseEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent evt, int row, int column) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent evt, int row, int column) {
		if (selecionado != null) {
			selecionado.desselecionar();
		}
		if(selecionado!=fornecedores[row]){
			fornecedores[row].selecionar();
			selecionado = fornecedores[row];
		}else{
			selecionado=null;
		}
		atualizar();
	}

	@Override
	public void mouseReleased(MouseEvent evt, int row, int column) {
		// TODO Auto-generated method stub

	}
}
