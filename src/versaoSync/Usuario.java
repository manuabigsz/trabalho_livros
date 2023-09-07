package versaoSync;

/**
 * 
 * Esta classe representa um usuário que 
 * empresta e lê um livro com controle de acesso synchronized.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
public class Usuario extends Thread {

    private Livro livro;
    private Integer id;

    /**
     * Construtor do usuário com um id e um livro
     * 
     * @param id identificador do usuário
     * @param livro livro que o usuário irá emprestar e ler
     */
    public Usuario(int id, Livro livro) {
        this.id = id;
        this.livro = livro;
    }

    /**
     * Executa a thread do usuário emprestando o livro, 
     * simulando o tempo de leitura e devolvendo o livro, respectivamente.
     */
    public void run() {
        livro.emprestarLivro(id);
        try {
            Thread.sleep(2000); // Simula o tempo de leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        livro.devolverLivro();
    }
}
