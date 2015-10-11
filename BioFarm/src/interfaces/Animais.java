package interfaces;

import main.BioFarm;
import estadosGalinhas.EstadosGalinhas_pinto;

public interface Animais {
	public int getcontadorComida();
	public void resetContadores();
	public int getcontadorAgua();
	public int getContadorIteracoes();
	public void contadorIterar();
	public void setEstadoGalinhas(EstadosGalinhas_pinto estado);
	public void setImagem(String caminho);
	public BioFarm getBiofarm();
}
