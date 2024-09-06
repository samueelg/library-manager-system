//Samuel Aluizio de Melo Goncalves
//Matheus Carvalho Gomes Gewehr
//Felipe Soria Galvarro

package visao;

import dominio.Cliente;
import controle.Controle;
import dominio.Livro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {
        Controle controle = new Controle();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Cadastrar cliente");
                System.out.println("2. Cadastrar livro");
                System.out.println("3. Listar livros disponíveis");
                System.out.println("4. Alugar um livro");
                System.out.println("5. Devolver um livro");
                System.out.println("6. Listar livros alugados");
                System.out.println("7. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (opcao) {
                    case 1:
                        // Cadastro de cliente
                        System.out.println("Informe o nome do cliente:");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o CPF do cliente:");
                        String cpf = scanner.nextLine();
                        System.out.println("Informe o email do cliente:");
                        String email = scanner.nextLine();
                        System.out.println("Informe a idade do cliente:");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        Cliente cliente = new Cliente(nome, cpf, email, idade);
                        controle.cadastraCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;

                    case 2:
                        // Cadastro de livro
                        System.out.println("Informe o título do livro:");
                        String titulo = scanner.nextLine();
                        System.out.println("Informe a categoria do livro:");
                        String categoria = scanner.nextLine();
                        System.out.println("Informe o autor do livro:");
                        String autor = scanner.nextLine();
                        System.out.println("Informe o ISBN do livro:");
                        int isbn = scanner.nextInt();
                        System.out.println("Informe a quantidade de exemplares:");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        Livro livro = new Livro(titulo, categoria, autor, isbn, quantidade);
                        controle.cadastrarLivros(livro);
                        System.out.println("Livro cadastrado com sucesso!");
                        break;

                    case 3:
                        controle.listarLivrosDisponiveis();
                        break;

                    case 4:
                        // Alugar livro
                        System.out.println("Informe o nome do cliente:");
                        String nomeClienteAlugar = scanner.nextLine();
                        Cliente clienteAlugar = buscarClientePorNome(controle, nomeClienteAlugar);
                        if (clienteAlugar != null) {
                            System.out.println("Informe o título do livro para alugar:");
                            String tituloLivroAlugar = scanner.nextLine();
                            String resultadoAluguel = controle.alugarLivro(clienteAlugar, tituloLivroAlugar);
                            System.out.println(resultadoAluguel);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;

                    case 5:
                        // Devolver livro
                        System.out.println("Informe o nome do cliente:");
                        String nomeClienteDevolver = scanner.nextLine();
                        Cliente clienteDevolver = buscarClientePorNome(controle, nomeClienteDevolver);
                        if (clienteDevolver != null) {
                            System.out.println("Informe o título do livro para devolver:");
                            String tituloLivroDevolver = scanner.nextLine();
                            String resultadoDevolucao = controle.devolverLivro(clienteDevolver, tituloLivroDevolver);
                            System.out.println(resultadoDevolucao);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;

                    case 6:
                        // Listar livros alugados
                        System.out.println("Informe o nome do cliente:");
                        String nomeClienteListar = scanner.nextLine();
                        Cliente clienteListar = buscarClientePorNome(controle, nomeClienteListar);
                        if (clienteListar != null) {
                            controle.listarLivrosAlugados(clienteListar);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;

                    case 7:
                        running = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); // Consumir a entrada inválida e permitir que o programa continue

            } catch (NullPointerException e) {
                System.out.println("Erro: Não foi possível encontrar o cliente ou livro especificado.");

            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static Cliente buscarClientePorNome(Controle controle, String nomeCliente) {
        for (Cliente cliente : controle.listaClientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }
}
