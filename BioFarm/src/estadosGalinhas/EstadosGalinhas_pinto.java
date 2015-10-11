package estadosGalinhas;

import interfaces.Animais;
import interfaces.Comida;
import interfaces.Fornecedor;
import interfaces.Fornecivel;

/**
 * @author  Emanuel Lopes
 */
public abstract class EstadosGalinhas_pinto implements Fornecivel, Fornecedor, Comida{
	/*SuperClass para os Vários estados das galinhas
	 * GalinhaInicial
	 * GalinhaComOvo
	 * GalinhaAChocar
	 * GalinhaOvoChocado
	 */
	/*funcao abstrata que itera as galinhas
	*
	*/
	/**
	 * @uml.property  name="galinha_pinto"
	 * @uml.associationEnd  
	 */
	protected Animais galinha_pinto;
	public abstract void iterarGalinha_pinto();
}
