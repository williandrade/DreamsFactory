package com.dreamsfactory.analyzer;

import java.util.List;

public interface Analyzer<T> {

	public void addAll(List<T> itens);

	public List<T> search(String querystr, int itens);

}
