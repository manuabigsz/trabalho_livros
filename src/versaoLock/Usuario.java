package versaoLock;

/**
 * Classe que representa um usuário, que empresta e lê um livro com controle de acesso.
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
public class Usuario extends Thread {

    private Livro livro;
    private int ordem;

    /**
     * 
     * Cria uma nova instância de usuário associeada a um livro e com uma ordem específica.
     * @param livro que o usuário irá emprestar e ler.
     * @param ordem ordem do usuário.
     */
    public Usuario(Livro livro, int ordem) {
        this.livro = livro;
        this.ordem = ordem;
    }

    /**
     * Execyta a thread do usuário, emprestando o livro, simulando o
     * tempo de leitura e devolvendo o livro, respectivamente.
     */
    @Override
    public void run() {
        try {
            livro.emprestarLivro(ordem);
            Thread.sleep(2000); // Simula o tempo de leitura
            livro.devolverLivro();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
