package versaoBlock;

/**
 * Classe main que inicia a simulação do exercício proposto.
 * Os usuários e livros são representados por threads
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
/**
 * método que inicia a simulação
 * @param args  argumentos de linha de comando, que não são utilizados
 */
    public static void main(String[] args) {

        /**
         * Criação de uma fila que controla o acesso ao livro com capacidade de 10 usuários
         */
        ArrayBlockingQueue<Integer> livro = new ArrayBlockingQueue<Integer>(10);

       /**
        *  Chamada das classes Usuario e Livro
        */ 
        Usuario usuario = new Usuario(livro);
        Livro book = new Livro(livro);

        /**
         * Inicia as threads para simular a leitura do livro por usuário
         */
        usuario.start();
        book.start();
    }
}
