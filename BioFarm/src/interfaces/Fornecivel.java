package interfaces;

public interface Fornecivel {
	/*Interface usada para verificar se o elemento pode receber um elemento fornecivel
	 * e receber o elemento 
	 */
	public boolean podeReceber(Fornecivel e);
	public void receberFornecivel(Fornecivel e);
}
