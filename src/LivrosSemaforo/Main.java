package LivrosSemaforo;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
            Livros livro = new Livros(i + 1, semaforo);
            livro.start();
        }
    }
}
