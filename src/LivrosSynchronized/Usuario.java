package LivrosSynchronized;


public class Usuario extends Thread {
    private int id;
    private Livros livro;

    public Usuario(int id, Livros livro) {
        this.id = id;
        this.livro = livro;
    }

    public void run() {
        livro.emprestar(id);
    }
}
