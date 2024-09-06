//Samuel Aluizio de Melo Goncalves
//Matheus Carvalho Gomes Gewehr
//Felipe Soria Galvarro

package dominio;

public class Livro {
    private String titulo, categoria, autor;
    private int ISBN, quantidade;

    public Livro(String titulo, String categoria, String autor, int ISBN, int quantidade) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.ISBN = ISBN;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
