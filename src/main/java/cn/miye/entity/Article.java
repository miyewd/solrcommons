package cn.miye.entity;

import org.apache.solr.client.solrj.beans.Field;

public class Article {
	@Field
	private String mdcProArticleId;
	@Field
	private String title;
	@Field
	private String lang;

	public String getMdcProArticleId() {
		return mdcProArticleId;
	}

	public void setMdcProArticleId(String mdcProArticleId) {
		this.mdcProArticleId = mdcProArticleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
