package br.com.dayhan.factory;

import java.util.List;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;

import br.com.dayhan.api.Api;

public class GithubBuilder implements Api {

	private RepositoryService service;

	public GithubBuilder() {
		service = new RepositoryService();
	}

	@Override
	public void printSearch(String search) {
		List<SearchRepository> repositories = search(search);
		for (SearchRepository result : repositories) {
			System.out.println("Name: " + result.getName());
			System.out.println("Description: " + result.getDescription());
			System.out.println("Owner: " + result.getOwner());
			System.out.println("-------------------------------------------------------------------");
		}
	}

	public List<SearchRepository> search(String search) {
		try {
			return service.searchRepositories(search).subList(0, 10);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível consultar a API do Github");
		}
	}
}
