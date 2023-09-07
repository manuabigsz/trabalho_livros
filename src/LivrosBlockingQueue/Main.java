package LivrosBlockingQueue;

/**
 * @Giovanna Cavalcante Carvalho
 * @Débora Rebelatto de Vila
 */

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    
    //Criação da main 
    public static void main(String[] args) {
        
        //Implementação da fila 
        ArrayBlockingQueue<Integer> livro = new ArrayBlockingQueue<Integer>(10);
        
        //Chamada das classes Usuario e Livro
        Usuario usuario = new Usuario(livro);
        Livro book = new Livro(livro);
        
        //Inicialização das threads
        usuario.start();
        book.start();
    }
}
