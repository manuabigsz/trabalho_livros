package LivrosBlockingQueue;

/**
 * @Giovanna Cavalcante Carvalho
 * @Débora Rebelatto de Vila
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Livro extends Thread {
  
    //Criação da variavel na fila
    private ArrayBlockingQueue<Integer> livro;

    //Criação do construtor passando a variavel
    public Livro(ArrayBlockingQueue<Integer> livro) {
        this.livro = livro;
    }
    
    public void run(){
        try{
            //Usuario saindo da fila
            for (int i = 1; i < 11; i++) {
                livro.take();
                System.out.println("Usuario " + i + " terminou de ler o livro. Agora o livro esta disponivel.");
                Thread.sleep(500);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
