package gitprueba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Probando las bondades de java 8 utilizando expresiones lambda,
 * <code>Collections.EMPTY_MAP</code> y <code>Collections.EMPTY_LIST</code>
 *
 * @author iacarrasco
 */
public class GitPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            System.out.println("Que la fuerza los acompañe");
            System.out.println("Hola bola de Cuechos ");
            System.out.println("Yo soy Cuecho! perros y perras :) ");
            System.out.println("Estan hechos unos san bernardos!!!! ");

            Map<String, List<String>> gruposIntegrantes = new HashMap<>();
            List<String> integrantres = new ArrayList<>();

            integrantres.add("Oscar");
            integrantres.add("Luis");
            integrantres.add("Ivan");
            integrantres.add("Pavel");

            Imprime imprime = new Imprime();
            imprime.imprimir(integrantres);

            gruposIntegrantes.put("Cuechos", integrantres);

            throw new Excepcion(new Throwable(""), Excepcion.CAUSE.OBJETO_EXISTENTE, "Suelten a los perros");
        } catch (Excepcion e) {
            if (e.getCauseBy() == Excepcion.CAUSE.OBJETO_EXISTENTE) {
                System.out.println(e.getMessage());
            }
        }

    }

}
