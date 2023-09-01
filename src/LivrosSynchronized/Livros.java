package LivrosSynchronized;

import java.util.concurrent.Semaphore;

public class Livros extends Thread{
    String nomeLivro = "O Iluminado";

    boolean livro_disponível = true;

    public synchronized void emprestar(int idUsuario) {

        try {
          
            while (!livro_disponível) {
                wait();
            }
            livro_disponível = false;
            System.out.println("O usuario com id " + idUsuario + " esta lendo o livro '" + nomeLivro + "'");

            Thread.sleep(3000);
            System.out.println("O usuario com id " + idUsuario + " parou de ler o livro '" + nomeLivro + "'");

            livro_disponível = true;

            System.out.println("O livro '" + nomeLivro + "' esta disponivel para o proximo usuario.\n");
notifyAll();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
