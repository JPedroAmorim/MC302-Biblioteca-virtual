// Alexandre Luciano Barbosa	165232
// João Pedro de Amorim 		176131
// Leonardo Rodrigues Marques	178610

package trabalho1;
import telas.TelaInicial;
import java.io.*;

/* Classe main: Ponto de partida do sistema. É responsável por chamar os métodos login e de opcoesUsuario, da classe Gerenciador.
 * Contém testaSistema(), utilizado para demonstrar o sistema.
*/

public class Main {

    public static int testMode = 0; // Variável que indica se o sistema está em modo de teste ou não.

    public static void main(String[] args) throws SistemaExcecao {

        new TelaInicial().setVisible(true);

    }
}
