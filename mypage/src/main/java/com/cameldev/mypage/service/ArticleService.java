package com.cameldev.mypage.service;

import java.util.List;

import com.cameldev.mypage.domain.ArticleVO;
import com.camledev.mypage.commons.paging.Criteria;


public interface ArticleService {
	void create(ArticleVO articleVO) throws Exception;
	
	ArticleVO read(Integer article_no) throws Exception;
	
	void update(ArticleVO articleVO) throws Exception;
	
	void delete(Integer article_no) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;
	
	List<ArticleVO> listCriteria(Criteria criteria) throws Exception;

	

}
