package versaoSemaphore;

/**
 * Classe main que inicia a simulação do exercício proposto.
 * Ela cria uma instância da classe Livro, um objeto semáforo e inicia várias 
 * threads de Usuário para simular os leitores.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.Semaphore;

public class Main {
/**
 * método que inicia a simulação
 * @param args argumentos de linha de comando, que não são utilizados
 */
    public static void main(String[] args) {
        Livro livro = new Livro();
        Semaphore semaforo = new Semaphore(1);// Inicializa o semáforo com 1 permissão (acesso exclusivo)

        // Criação de 10 threads de Usuário para simular os leitores
        for (int i = 1; i < 11; i++) {
            Usuario usuario = new Usuario(i, livro, semaforo);
            usuario.start();
        }
    }
}
