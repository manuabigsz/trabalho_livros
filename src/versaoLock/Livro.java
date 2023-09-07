package versaoLock;

/**
 * Classe que representa o Livro.
 * Essa classe pode ser lida por vários usuários, que consomem o livro por um determinado tempo
 * controle de acesso usando locks.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livro {

    private Lock lock = new ReentrantLock();
    private Condition disponivel = lock.newCondition();
    private int usuarioAtual = 1;

    /**
     * Empresta o livro para um usuário com uma determinada ordem.
     * Aguarda até que seja a vez do usuário de acordo com a ordem especificada.
     * 
     * @param ordem do usuario que deseja ler
     * @throws InterruptedException lança se a thread for interrmpida enquanto espera sua vez
     */
    public void emprestarLivro(int ordem) throws InterruptedException {
        lock.lock();
        try {
            while (ordem != usuarioAtual) {
                disponivel.await(); // Aguarda até que seja a vez do usuário
            }
            System.out.println("Usuario " + ordem + " esta lendo o livro.");
        } finally {
            lock.unlock();
        }
    }

    /**
     * Devolve o livro após a leitura e permite que o próximo usuário leia.
     * Notifica todos os usuários que o livro está disponível.
     */
    public void devolverLivro() {
        lock.lock();
        try {
            System.out.println("Usuario " + usuarioAtual + " terminou de ler o livro. Agora o livro esta disponivel.");
            usuarioAtual++;
            disponivel.signalAll(); // Notifica todos os usuários que o livro está disponível
        } finally {
            lock.unlock();
        }
    }
}
