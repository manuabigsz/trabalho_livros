package LivrosSemaforo;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Livros livro = new Livros();
        Semaphore semaforo = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario(i, livro, semaforo);
            usuario.start();
        }
    }
}
