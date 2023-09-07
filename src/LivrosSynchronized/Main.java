package LivrosSynchronized;

import java.util.concurrent.Semaphore;


public class Main {
      public static void main(String[] args) {
       
          Livros livro = new Livros();

        for (int i = 1; i <= 10; i++) {
            Usuario usuario = new Usuario(i, livro);
            usuario.start();
        }
    }
}
