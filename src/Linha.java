

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 *
 * Referente a Classe: Linha.java.
 * 
 * Value: Refere-se ao nome do campo(atributo) que será setado no objeto
 * inicio: Onde irá iniciar a contagem
 * termino: Fim da contagem
 * 
 * Inicio e Termino devem ser cosinderados por linha
 * 
 * @author Henrique Santiago 
 * @version 1.0
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Linha {

	String value();
	int inicio();
	int termino();
}
