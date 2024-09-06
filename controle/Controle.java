//Samuel Aluizio de Melo Goncalves
//Matheus Carvalho Gomes Gewehr
//Felipe Soria Galvarro

package controle;

import dominio.Cliente;
import dominio.ListaLivros;
import dominio.Livro;

import java.util.ArrayList;

public class Controle {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    ListaLivros listaLi = new ListaLivros();

    public Controle() {
        listaClientes = new ArrayList<>();
    }

    //Este metodo cadastra o cliente na lista
    public void cadastraCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    //Este metodo serve para listar os clientes cadastrados.
    public String listarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : listaClientes) {
            sb.append("Nome: " + cliente.getNome() + "\n");
            sb.append("CPF: " + cliente.getCpf() + "\n");
            sb.append("E-mail: " + cliente.getEmail() + "\n");
            sb.append("Idade: " + cliente.getIdade() + "\n");
        }
        return sb.toString();
    }

    //Este metodo serve para cadastrar Livros na Lista de Livros
    public void cadastrarLivros(Livro livro) {
        listaLi.addLivro(livro);
    }

    //Este metodo serve para alugar um livro no nome do cliente
    public String alugarLivro(Cliente cliente, String tituloLivro) {
        for (Livro livro : listaLi.livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro) && livro.getQuantidade() > 0) {
                cliente.adicionarLivroAlugado(livro);
                livro.setQuantidade(livro.getQuantidade() - 1);
                return "Livro alugado com sucesso!";
            }
        }
        return "Livro não disponível para aluguel.";
    }

    //Este metodo serve para devolver um livro alugado pelo cliente
    public String devolverLivro(Cliente cliente, String tituloLivro) {
        for (Livro livro : cliente.getLivrosAlugados()) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                cliente.getLivrosAlugados().remove(livro);
                livro.setQuantidade(livro.getQuantidade() + 1);
                return "Livro devolvido com sucesso!";
            }
        }
        return "Livro não encontrado na lista de livros alugados.";
    }

    //Este metodo serve para listar os livros alugados pelo cliente
    public void listarLivrosAlugados(Cliente cliente) {
        if (cliente.getLivrosAlugados().isEmpty()) {
            System.out.println("Nenhum livro alugado.");
        } else {
            System.out.println("Livros alugados por " + cliente.getNome() + ":");
            for (Livro livro : cliente.getLivrosAlugados()) {
                System.out.println(livro.getTitulo());
            }
        }
    }

    //Este metodo mostra todos os livros disponiveis para alguel
    public void listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis para aluguel:");
        boolean algumLivroDisponivel = false;
        for (Livro livro : listaLi.livros) {
            if (livro.getQuantidade() > 0) {
                System.out.println("Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Quantidade: " + livro.getQuantidade());
                algumLivroDisponivel = true;
            }
        }
        if (!algumLivroDisponivel) {
            System.out.println("Nenhum livro disponível para aluguel.");
        }
    }
}
