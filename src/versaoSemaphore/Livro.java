package versaoSemaphore;

/**
 * Esta classe representa um livro que pode ser emprestado e lido por vários usuários simultaneamente,
 * com semáforos para controle de acesso.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.Semaphore;

public class Livro {

    String nomeLivro = "O Iluminado";
    boolean livro_disponivel = true;

    /**
     * Empresta o livro para um usuário.
     * Apenas um usuário por vez pode emprestar o livro.
     * 
     * @param id identificador do usuário
     * @param semaforo  controla o acesso ao livro.
     */
    public void emprestar(int id, Semaphore semaforo) {
        try {
            semaforo.acquire(); // Adquire o semáforo (permite apenas um usuário por vez)

            while (!livro_disponivel) {
                Thread.sleep(100); // Aguarda um curto período para tentar novamente
            }

            livro_disponivel = false;
            System.out.println("Usuario " + id + " esta lendo o livro '" + nomeLivro + "'");

            Thread.sleep(3000);
            System.out.println("Usuario " + id + " terminou de ler o livro '" + nomeLivro + "'");

            livro_disponivel = true;

            System.out.println("Agora o livro '" + nomeLivro + "' esta disponivel para o proximo usuario.\n");
            semaforo.release(); // Libera o semáforo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
