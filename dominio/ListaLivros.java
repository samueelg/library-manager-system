//Samuel Aluizio de Melo Goncalves
//Matheus Carvalho Gomes Gewehr
//Felipe Soria Galvarro

package dominio;

import java.util.ArrayList;

public class ListaLivros {
    public ArrayList<Livro> livros = new ArrayList<>();

    public ListaLivros(){
        livros = new ArrayList<>();
    }

    public void addLivro(Livro livro){
        this.livros.add(livro);
    }

    public void getAllLivros(){
        for (int i = 0; i < this.livros.size(); i++) {
            System.out.println("Titulo do Livro: " + this.livros.get(i).getTitulo() + ", Categoria: " + this.livros.get(i).getCategoria() + ", Autor: " + this.livros.get(i).getAutor() + ", ISBN: " + this.livros.get(i).getISBN() + ", Quantidade: " + this.livros.get(i).getQuantidade());
        }
    }

}
