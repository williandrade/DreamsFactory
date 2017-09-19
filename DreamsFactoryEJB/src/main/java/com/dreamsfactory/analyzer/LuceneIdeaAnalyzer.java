package com.dreamsfactory.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import com.dreamsfactory.dto.IdeaDTO;
import com.dreamsfactory.dto.IdeaSearchDTO;

@ApplicationScoped
public class LuceneIdeaAnalyzer implements Analyzer<IdeaSearchDTO> {

	private StandardAnalyzer analyzer = null;
	private Directory index = null;
	private IndexWriterConfig config = null;

	public LuceneIdeaAnalyzer() {
		this.analyzer = new StandardAnalyzer();
		this.index = new RAMDirectory();
		this.config = new IndexWriterConfig(this.analyzer);
	}

	@Override
	public void addAll(List<IdeaSearchDTO> itens) {
		try {
			IndexWriter w = new IndexWriter(index, config);
			for (IdeaSearchDTO idea : itens) {
				addDoc(w, idea.getShortDescription(), idea.getId().toString());
			}
			w.close();
		} catch (Exception e) {
		}
	}

	public List<IdeaSearchDTO> search(String querystr, int itens, float deadLine) {
		List<IdeaSearchDTO> result = new ArrayList<>();
		try {
			Query q = new QueryParser("title", analyzer).parse(querystr);

			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs docs = searcher.search(q, itens);
			ScoreDoc[] hits = docs.scoreDocs;

			for (int i = 0; i < hits.length; ++i) {
				int docId = hits[i].doc;
				float score = hits[i].score;
				if (score > deadLine) {
					Document d = searcher.doc(docId);
					IdeaSearchDTO dto = new IdeaSearchDTO();
					dto.setId(Integer.parseInt(d.get("isbn")));
					dto.setShortDescription(d.get("title"));
					dto.setScore(score);
					result.add(dto);
				}
			}
		} catch (Exception e) {

		}
		return result;
	}

	@Override
	public List<IdeaSearchDTO> search(String querystr, int itens) {
		List<IdeaSearchDTO> result = new ArrayList<>();
		try {
			Query q = new QueryParser("title", analyzer).parse(querystr);

			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs docs = searcher.search(q, itens);
			ScoreDoc[] hits = docs.scoreDocs;

			for (int i = 0; i < hits.length; ++i) {
				int docId = hits[i].doc;
				float score = hits[i].score;
				Document d = searcher.doc(docId);
				IdeaSearchDTO dto = new IdeaSearchDTO();
				dto.setId(Integer.parseInt(d.get("isbn")));
				dto.setShortDescription(d.get("title"));
				dto.setScore(score);
				result.add(dto);
			}
		} catch (Exception e) {

		}
		return result;
	}

	private void addDoc(IndexWriter w, String title, String isbn) throws IOException {
		Document doc = new Document();
		doc.add(new TextField("title", title, Field.Store.YES));
		doc.add(new StringField("isbn", isbn, Field.Store.YES));
		w.addDocument(doc);
	}

}
