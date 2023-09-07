package versaoSync;

/**
 * Classe que representa o Livro.
 * Essa classe pode ser lida por vários usuários, que consomem
 * o livro por um determinado tempo.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
public class Livro {

    private boolean disponivel = true;
    private int usuarioAtual = 1;


    /**
     * Empresta o lviro para um usuário com uma determinada ordem.
     * Espera até que o livro esteja disponível e seja a vez do usuário.
     * 
     * @param ordem ordem do usuário que deseja ler o livro.
     */
    public synchronized void emprestarLivro(int ordem){
        while (!disponivel || ordem != usuarioAtual) {
            try {
                wait(); // Aguarda até que o livro esteja disponível e seja a vez do usuário
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Usuario " + ordem + " esta lendo o livro.");
    }

    /**
     * Devolve o livro após a leitura e permite a leitura para o próximo usuário.
     * Notifica todos os usuários que o livro está disponível.
     */
    public synchronized void devolverLivro() {
        System.out.println("Usuario " + usuarioAtual + " terminou de ler o livro. Agora o livro esta disponivel.");
        usuarioAtual++;
        disponivel = true;
        notifyAll(); // Notifica todos os usuários que o livro está disponível
    }
}
