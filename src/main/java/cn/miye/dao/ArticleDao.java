package cn.miye.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.miye.entity.Article;

@Repository
public interface ArticleDao {
	public List<Article> queryArticle();
}
