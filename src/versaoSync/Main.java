package versaoSync;

/**
 * Classe main que inicia a simulação do exercício proposto.
 * Ela cria uma instância da classe Livro e inicia várias threads de Usuário.
 * 
 * @author Manuela Bertella Ossanes
 * @author Débora Rebelatto de Vila
 */
public class Main { 

    /**
     * método que inicia a simulação
     * @param args argumentos de linha de comando, que não são utilizados
     */
    public static void main(String[] args) {
        Livro livro = new Livro();
        
        //cria 10 threads de usuários para simular os leitores
        for (int i = 1; i < 11; i++) {
            Thread usuario = new Usuario(i, livro);
            usuario.start();
        }
    }
}
