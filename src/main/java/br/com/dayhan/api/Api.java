package br.com.dayhan.api;

import java.util.List;

public interface Api<T> {
	List<T> search(String search);
}
