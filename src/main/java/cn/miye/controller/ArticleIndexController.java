package cn.miye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.miye.service.impl.AddIndexServiceImpl;

@Controller
@RequestMapping("/index")
public class ArticleIndexController {
	@Autowired
	private AddIndexServiceImpl addIndexServiceImpl;
	
	@RequestMapping("/add")
	@ResponseBody
	public int AddArticleIndex() throws Exception {
		int index = addIndexServiceImpl.addArticleIndex();
		return index;
	}
}
