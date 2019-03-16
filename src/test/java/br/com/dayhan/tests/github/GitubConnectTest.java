package br.com.dayhan.tests.github;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.Test;

public class GitubConnectTest {

	@Test
	public void test() throws IOException {
		RepositoryService service = new RepositoryService();
		List<SearchRepository> searchRepositories = service.searchRepositories("Internet of things");
		
		assertNotNull("A lista não deveria estar vazia", searchRepositories);
	}

}
