package execucao;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import modelo.Pessoa;

public class PessoaExecc {

	
	    private static List<Pessoa> pessoas = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        exibirMenu();
	    }

	    private static void exibirMenu() {
	        int opcao;

	        do {
	            System.out.println("MENU");
	            System.out.println("1- Cadastrar Pessoas");
	            System.out.println("2- Listar Pessoas");
	            System.out.println("3- Excluir uma Pessoa pelo índice");
	            System.out.println("0- Sair");
	            System.out.print("Digite a opção desejada: ");

	            opcao = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (opcao) {
	                case 1:
	                    cadastrarPessoa();
	                    break;
	                case 2:
	                    listarPessoas();
	                    break;
	                case 3:
	                    excluirPessoa();
	                    break;
	                case 0:
	                    System.out.println("Saindo do programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.\n");
	            }
	        } while (opcao != 0);
	    }

	    private static void cadastrarPessoa() {
	        System.out.print("Digite o nome da pessoa: ");
	        String nome = scanner.nextLine();
	        System.out.print("Digite o sobrenome da pessoa: ");
	        String sobrenome = scanner.nextLine();

	        Pessoa pessoa = new Pessoa(nome, sobrenome);
	        pessoas.add(pessoa);

	        System.out.println("Pessoa cadastrada com sucesso!\n");
	    }

	    private static void listarPessoas() {
	        if (pessoas.isEmpty()) {
	            System.out.println("Nenhuma pessoa cadastrada.\n");
	        } else {
	            System.out.println("Lista de pessoas cadastradas:");
	            for (Pessoa pessoa : pessoas) {
	                System.out.println("Nome: " + pessoa.getNome() + " | Sobrenome: " + pessoa.getSobrenome());
	            }
	            System.out.println();
	        }
	    }

	    private static void excluirPessoa() {
	        if (pessoas.isEmpty()) {
	            System.out.println("Nenhuma pessoa cadastrada para excluir.\n");
	        } else {
	            listarPessoas();
	            System.out.print("Digite o índice da pessoa a ser excluída: ");
	            int indice = scanner.nextInt();
	            scanner.nextLine(); 
	            if (indice >= 1 && indice <= pessoas.size()) {
	                Pessoa pessoaExcluida = pessoas.remove(indice - 1);
	                System.out.println("A pessoa " + pessoaExcluida.getNome() + " " + pessoaExcluida.getSobrenome()
	                        + " foi excluída.\n");
	            } else {
	                System.out.println("Índice inválido.\n");
	            }
	        }
	    }
}
 
