package LivrosSemaforo;

public class Usuario {
    
}
import java.util.concurrent.Semaphore;

class Usuario extends Thread {
     int id;
    Livros livro;
    Semaphore semaforo;

    public Usuario(int id, Livros livro, Semaphore semaforo) {
        this.id = id;
        this.livro = livro;
        this.semaforo = semaforo;
    }

    public void run() {
        livro.emprestar(id, semaforo);
    }
}
