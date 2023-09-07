package versaoBlock;

/**
 * Classe que representa um usuário que lê um livro
 * controlado por uma  fila.
 * Ele entra na fila para ler o livro em sequência.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.ArrayBlockingQueue;

public class Usuario extends Thread {

    /**
     * Fila que controla o acesso ao livro
     */
    private ArrayBlockingQueue<Integer> livro;

    /**
     * Criação do construtor, com a fila especificada
     * @param livro fila que controla o acesso ao livro.
     */
    public Usuario(ArrayBlockingQueue<Integer> livro) {
        this.livro = livro;
    }

    /**
     * Executa a thread do usuário, permitindo que ele leia o livro
     * e libere ele, colocando na fila novamente após a leitura.
     */
    public void run() {
        try {
           /**
            * Usuário entrou na fila para ler o livro
            */
            for (int i = 1; i < 11; i++) {
                System.out.println("Usuario " + i + " leu o livro.");
                livro.put(i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
