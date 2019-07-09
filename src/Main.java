import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;


/**
 * Referente a Classe: Main.java.
 * 
 * Classe de execução
 * 
 * @author Henrique Santiago 
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) throws IOException {

		String linha;
		BufferedReader objReader = null;
		try {
			/**
			 * O endereço do arquivo deve ser alterado para o endereço onde está o seu arquivo
			 * 
			 * File: representa o arquivo informado
			 * Doc: https://docs.oracle.com/javase/8/docs/api/java/io/File.html
			 */
			File file = new File("c:\\arquivos\\teste.txt");
			
			/**
			 * 
			 * BufferedReader: Permite fazer a leitura do arquivo(fluxo) de entrada.
			 * Doc: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
			 */
			objReader = new BufferedReader(new FileReader(file));
			
			/**
			 * De acordo com a condição, percorre linha por linha fazendo a leitura
			 */
			while ((linha = objReader.readLine()) != null) {
				/**
				 * Executa o método atualizaObjeto que retorna um objeto do tipo ArquivoRetorno já preenchido
				 * com os dados da linha
				 * 
				 * Veja o método {@see Main#atualizaOjeto(T,String)}
				 */
				ArquivoRetorno retorno = atualizarOjeto(new ArquivoRetorno(), linha);
				System.out.println(retorno.toString());
				System.out.println();
			}
		}catch (Exception e) {
			if (objReader != null)
			     objReader.close();
		}
	}

	/**
	 * Retorna um objeto do tipo especificado já preenchido com a linha do arquivo lido no momento
	 *  
	 * @author <a href="mailto:henriquesantiagofranco@gmail.com">Henrique Santiago</a>
	 * @param <T>
	 * @param objeto
	 * @param linha
	 * @return
	 */
	static <T> T atualizarOjeto(T objeto, String linha) {
		if (linha != null && linha != ""){
			
			//Retorna a classe de tempo de execução
			Class<? extends Object> entityClass = objeto.getClass();

			//Recupera os campos(atributos) que foram declarados nas classe
			Field[] fields = entityClass.getDeclaredFields();

			//Percorre campo(atributo) por campo da classe
			for (Field currentField : fields) {
				try {
					//Modififica o acesso do campo(atributo), permitido realizar alteração no mesmo
					currentField.setAccessible(true);
					//Teste se o campo(atributo) possui anotação Linha
					if (currentField.isAnnotationPresent(Linha.class)) {
						//Se anotação estiver no campo(atributo), recupera a mesma para utilização
						Linha col =	(Linha) currentField.getAnnotation(Linha.class);
						if (currentField != null) {
							//Faz uma validação para descobrir se objeto passado é do tipo Boleto
							if (objeto instanceof ArquivoRetorno){
								//Verifica se o nome do campo(atributo) é igual ao informado na anotação linha
								if (currentField.getName().equals(col.value())){
									//Se o campo for igual seta no campo(atributo) o valor da linha com base nas posições de inicio e termino
									currentField.set(objeto, linha.substring(col.inicio(), col.termino()).trim());
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return objeto;
	}
}
