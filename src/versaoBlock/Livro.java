package versaoBlock;

/**
 * Classe que representa o Livro.
 * Essa classe pode ser lida por vários usuários, que consomem o livro por um determinado tempo. 
 * A classe controla o acesso através de uma fila.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.ArrayBlockingQueue;

public class Livro extends Thread {

    /**
     * Fila que controla o acesso ao livro.
     */
    private ArrayBlockingQueue<Integer> livro;

    
         /**
         * Cria uma nova instancia de livro.
         * 
         * @param livro Fila que controla o acesso ao livro.
         */
    public Livro(ArrayBlockingQueue<Integer> livro) {
        this.livro = livro;
    }

    /**
     * Executa a thread do livro, permitindo que os usuarios tenham
     * acesso ao livro e o leiam.
     */
    public void run() {
        try {
            /**
             * Usuário saindo da fila
             */
            for (int i = 1; i < 11; i++) {
                livro.take();
                System.out.println("Usuario " + i + " terminou de ler o livro. Agora o livro esta disponivel.");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
