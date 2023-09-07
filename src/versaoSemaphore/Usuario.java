package versaoSemaphore;

/**
 * Esta classe representa um usuário que empresta e lê um livro com 
 * semáforos como controle de acesso.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.Semaphore;

public class Usuario extends Thread {

    int id;
    Livro livro;
    Semaphore semaforo;

    /**
     * Construtor da classe com um id, um livro e um semáforo.
     * 
     * @param id identificador do usuário.
     * @param livro usuário irá emprestar e ler.
     * @param semaforo semáforo que controla o acesso ao livro.
     */
    public Usuario(int id, Livro livro, Semaphore semaforo) {
        this.id = id;
        this.livro = livro;
        this.semaforo = semaforo;
    }

     /**
      * Executa a thread do usuário, emprestando o livro com controle de acesso por semáforos.
      */
    public void run() {
        livro.emprestar(id, semaforo);
    }
}
