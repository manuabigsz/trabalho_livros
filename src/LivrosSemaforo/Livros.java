package LivrosSemaforo;

import java.util.concurrent.Semaphore;

public class Livros {

   String nomeLivro = "O Iluminado";
    boolean livro_disponivel = true;

    public void emprestar(int id, Semaphore semaforo) {
        try {
            semaforo.acquire(); // Adquire o semáforo (permite apenas um usuário por vez)

            while (!livro_disponivel) {
                Thread.sleep(100); // Aguarda um curto período para tentar novamente
            }

            livro_disponivel = false;
            System.out.println("O usuário com id " + id + " está lendo o livro '" + nomeLivro + "'");

            Thread.sleep(3000);
            System.out.println("O usuário com id " + id + " parou de ler o livro '" + nomeLivro + "'");

            livro_disponivel = true;
            semaforo.release(); // Libera o semáforo

            System.out.println("O livro '" + nomeLivro + "' está disponível para o próximo usuário.\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
