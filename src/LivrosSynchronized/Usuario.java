/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LivrosSynchronized;

/**
 *
 * @author 20212PF.CC0010
 */
public class Usuario extends Thread{
       int id;
       Livros livro;
       
       public Usuario(int id, Livros livro){
           this.id = id;
           this.livro = livro;
       }
       
       public void run(){
           livro.emprestar(id);
       }
       
}
