package br.com.dayhan.application;

import java.util.List;
import java.util.Scanner;

import org.eclipse.egit.github.core.SearchRepository;

import br.com.dayhan.factory.GithubBuilder;
import br.com.dayhan.factory.TwitterBuilder;

public class Menu {
	
	private static GithubBuilder githubBuilder;
	private static TwitterBuilder twitterBuilder;
	
	public Menu() {
		githubBuilder = new GithubBuilder();
		twitterBuilder = new TwitterBuilder();
	}
	
	public void showMenu() {
		boolean valid;
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("============================== Github-Twitter API ==============================\n");
				System.out.println("Informe a opção desejada:");
				System.out.println("1. Listar os projetos do Github com o termo \"Internet of Things\"");
				System.out.println("2. Buscar no twitter os projetos encontrados no Github \"Internet of Things\"");
				String option = scanner.nextLine();
				
				valid = selectOption(option);
			} while (!valid);
		}
	}
	
	private boolean selectOption(String option) {
		switch (option.trim()) {
		case "1":
			githubBuilder.printSearch("Internet of things");
			return true;
		case "2":
			List<SearchRepository> search = githubBuilder.search("internet of things");
			for (SearchRepository result : search) {
				System.out.println("\n=================================== Listando tweets sobre o projeto " + result.getName() + " ===================================\n");
				twitterBuilder.printSearch(result.getName());
			}
			return true;
		default:
			System.out.println("Opção inválida\n\n\n");
			return false;
		}
	}
}
