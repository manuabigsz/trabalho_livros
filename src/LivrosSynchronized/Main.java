package LivrosSynchronized;

import java.util.concurrent.Semaphore;


public class Main {
      public static void main(String[] args) {
       
        for (int i = 0; i < 10; i++) {
            Livros livro = new Livros(i + 1);
            
            livro.start();
        }
    }
}
