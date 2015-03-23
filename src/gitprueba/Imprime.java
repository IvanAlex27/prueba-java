package gitprueba;

import java.util.List;

/**
 *
 * @author iacarrasco
 */
public class Imprime {

    public void imprimir(List<String> integrantres) {
        integrantres.stream().forEach((String persona) -> {
            System.out.println(persona);
        });
    }

}
