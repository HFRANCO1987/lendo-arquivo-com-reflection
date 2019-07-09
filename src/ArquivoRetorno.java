/**
 * 
 *
 * Referente a Classe: ArquivoRetorno.java.
 * 
 * @author Henrique Santiago 
 * @version 1.0
 */
public class ArquivoRetorno {

	@Linha(value = "posicao1", inicio = 0, termino = 10)
	private String posicao1;

	@Linha(value = "posicao2", inicio = 10, termino = 20)
	private String posicao2;

	@Linha(value = "posicao3", inicio = 20, termino = 30)
	private String posicao3;

	public String getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(String posicao1) {
		this.posicao1 = posicao1;
	}

	public String getPosicao2() {
		return posicao2;
	}

	public void setPosicao2(String posicao2) {
		this.posicao2 = posicao2;
	}

	public String getPosicao3() {
		return posicao3;
	}

	public void setPosicao3(String posicao3) {
		this.posicao3 = posicao3;
	}
	
	@Override
	public String toString() {
		return "Posicao1: " + this.posicao1 + 
			   "\nPosicao2: " + this.posicao2 + 
			   "\nPosicao3: " + this.posicao3;
	}

}
