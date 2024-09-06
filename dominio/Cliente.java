//Samuel Aluizio de Melo Goncalves
//Matheus Carvalho Gomes Gewehr
//Felipe Soria Galvarro

package dominio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    public Cliente(String nome, String cpf, String email, int idade) {
        super(nome, cpf, email, idade);
    }

    public Cliente(String nome, String cpf, String email, int idade, ArrayList<Livro> livrosAlugados) {
        super(nome, cpf, email, idade);
        this.livrosAlugados = livrosAlugados;
    }

    private ArrayList<Livro> livrosAlugados = new ArrayList<>();

    public ArrayList<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(ArrayList<Livro> livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    public void adicionarLivroAlugado(Livro livro){
        livrosAlugados.add(livro);
    }
}
