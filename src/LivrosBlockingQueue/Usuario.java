package LivrosBlockingQueue;

/**
 * @Giovanna Cavalcante Carvalho
 * @Débora Rebelatto de Vila
 */

import java.util.concurrent.ArrayBlockingQueue;
        
public class Usuario extends Thread {
    
    private ArrayBlockingQueue<Integer> livro;

    //Criação do construtor 
    public Usuario(ArrayBlockingQueue<Integer> livro) {
        this.livro = livro;
    }
    
    public void run(){
        try{
            //Usuario entrou na fila para ler o livro 
            for (int i = 1; i < 11; i++) {
                System.out.println("Usuario " + i + " leu o livro.");
                livro.put(i);
                Thread.sleep(500);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
