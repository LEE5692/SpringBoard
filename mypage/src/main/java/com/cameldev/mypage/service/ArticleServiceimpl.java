package com.cameldev.mypage.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.cameldev.mypage.domain.ArticleVO;
import com.cameldev.mypage.persistence.ArticleDAO;
import com.camledev.mypage.commons.paging.Criteria;

@Service
public class ArticleServiceimpl implements ArticleService {
	
	private final ArticleDAO articleDAO;
	
	@Inject
	public ArticleServiceimpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	@Override
	public void create(ArticleVO articleVO) throws Exception {
	    articleDAO.create(articleVO);

		
	}

	@Override
	public ArticleVO read(Integer article_no) throws Exception {
		return articleDAO.read(article_no);
		
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
	
		articleDAO.update(articleVO);
	}
	
	@Override
	public void delete(Integer article_no) throws Exception {
		// TODO Auto-generated method stub
		   articleDAO.delete(article_no);
		   
	}
	@Override
	public List<ArticleVO> listAll() throws Exception {
	      return articleDAO.listAll();
	      
	}
	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
			return articleDAO.listCriteria(criteria);
	}
	


}
