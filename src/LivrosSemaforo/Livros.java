package LivrosSemaforo;

import java.util.concurrent.Semaphore;

public class Livros extends Thread {

    String nomeLivro = "O Iluminado";
    int id;
    Semaphore semaforo;
    boolean livro_disponível = true;

    public Livros(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    public synchronized void run() {

        try {
            this.semaforo.acquire();

            while (!livro_disponível) {
                wait();
            }
            livro_disponível = false;
            System.out.println("O usuario com id " + this.id + " esta lendo o livro '" + nomeLivro + "'");

            Thread.sleep(3000);
            System.out.println("O usuario com id " + this.id + " parou de ler o livro '" + nomeLivro + "'");

            livro_disponível = true;

            System.out.println("O livro '" + nomeLivro + "' esta disponivel para o proximo usuario.\n");

            notify();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.semaforo.release();
        }
    }

}
