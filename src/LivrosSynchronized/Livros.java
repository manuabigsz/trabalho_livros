package LivrosSynchronized;

import java.util.concurrent.Semaphore;

public class Livros extends Thread{
 private String nomeLivro = "O Iluminado";
    private boolean livroDisponivel = true;

    public void emprestar(int id) {
        try {
            synchronized (this) {
                while (!livroDisponivel) {
                    wait();
                }
                livroDisponivel = false;
                System.out.println("O usuário com ID " + id + " está lendo o livro '" + nomeLivro + "'");
                Thread.sleep(3000); // Simula a leitura por 3 segundos
                System.out.println("O usuário com ID " + id + " parou de ler o livro '" + nomeLivro + "'");
                livroDisponivel = true;
               
                System.out.println("O livro '" + nomeLivro + "' está disponível para o próximo usuário.\n");
           
                 notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
