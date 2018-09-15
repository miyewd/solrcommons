package cn.miye.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.miye.dao.ArticleDao;
import cn.miye.entity.Article;
import cn.miye.service.AddIndexService;

@Service
public class AddIndexServiceImpl implements AddIndexService {
	@Autowired
	private ArticleDao articleDao;

	@Value("#{solr['solrArticle.url']}") 
	private String articleCore;

	public int addArticleIndex() throws Exception {
		// 获取solr链接对象
		Builder builder = new HttpSolrClient.Builder(articleCore).withConnectionTimeout(10000).withSocketTimeout(60000);
		HttpSolrClient articleClient = builder.build();
		List<Article> articleList = articleDao.queryArticle();
		DocumentObjectBinder binder = new DocumentObjectBinder();
		for (Article article : articleList) {
			SolrInputDocument docs = binder.toSolrInputDocument(article);
			articleClient.add(docs);
		}
		UpdateResponse commit = articleClient.commit();
		int status = commit.getStatus();
		System.out.println(status);
		return status;
	}

}
