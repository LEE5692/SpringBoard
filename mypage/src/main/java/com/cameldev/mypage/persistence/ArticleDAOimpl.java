package com.cameldev.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cameldev.mypage.domain.ArticleVO;
import com.camledev.mypage.commons.paging.Criteria;

@Repository
public class ArticleDAOimpl implements ArticleDAO {
	
	private static final String NAMESPACE = "com.cameldev.mypage.mappers.article.articleMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public ArticleDAOimpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void create(ArticleVO articleVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", articleVO);
		
	}

	@Override
	public ArticleVO read(Integer article_no) throws Exception {
			return sqlSession.selectOne(NAMESPACE + ".read", article_no); 
		
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", articleVO);
		
	}

	@Override
	public void delete(Integer article_no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", article_no);
		
	}
	@Override
	public List<ArticleVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}


	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
	}
	@Override
	public List<ArticleVO> listPaging(int page) throws Exception {
		 if (page <= 0) {
		        page = 1;
		    }

		    page = (page - 1) * 10;

		    return sqlSession.selectList(NAMESPACE + ".listPaging", page);
	
	
	}
	
}
