package br.com.dayhan.application;

import java.util.List;
import java.util.Scanner;

import org.eclipse.egit.github.core.SearchRepository;

import br.com.dayhan.factory.GithubBuilder;
import br.com.dayhan.factory.TwitterBuilder;

class Menu {
	
	private static GithubBuilder githubBuilder;
	private static TwitterBuilder twitterBuilder;
	
	Menu() {
		githubBuilder = new GithubBuilder();
		twitterBuilder = new TwitterBuilder();
	}
	
	void showMenu() {
		boolean valid;
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("============================== Github-Twitter API ==============================\n");
				System.out.println("Informe a opção desejada:");
				System.out.println("1. Listar os projetos do Github com o termo \"Internet of Things\"");
				System.out.println("2. Buscar no twitter os projetos encontrados no Github \"Internet of Things\"");
				System.out.println("3. Sair");
				String option = scanner.nextLine();
				
				valid = selectOption(option);
			} while (!valid);
		}
	}
	
	private boolean selectOption(String option) {
		switch (option.trim()) {
		case "1":
			githubBuilder.printSearch("Internet of things");
			return false;
		case "2":
			List<SearchRepository> search = githubBuilder.search("internet of things");
			for (SearchRepository result : search) {
				System.out.println("\n=================================== Listando tweets sobre o projeto " + result.getName() + " ===================================\n");
				twitterBuilder.printSearch(result.getName());
			}
			return false;
		case "3":
			System.exit(0);
		default:
			System.out.println("Opção inválida\n\n\n");
			return false;
		}
	}
}
