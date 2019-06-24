package com.tdlLike.dao;

	import java.util.List;
	import java.util.Map;

	import org.mybatis.spring.support.SqlSessionDaoSupport;
	import org.springframework.stereotype.Repository;

import com.tdlComment.domain.CommentCommand;
import com.tdlLike.domain.*;


	@Repository
	public class TDLLikeDAOImpl  extends SqlSessionDaoSupport implements TDLLikeDAO {

	public void insertLike(likeCommand TDLLike) {
		getSqlSession().insert("insertLike",TDLLike);	
	}
	public void deleteLike(likeCommand TDLLike) {
		getSqlSession().delete("deleteLike",TDLLike);	
		}
	
	//���ƿ� üũ
	public List<likeCommand> likeCheck(likeCommand TDLLike) {
		try {
		List<likeCommand> listL=getSqlSession().selectList("likeCheck",TDLLike);
		System.out.println("���ƿ� üũ��� ���");
		return listL;
		}catch(Exception e) {
			System.out.println("���ƿ� üũ ����");
			e.printStackTrace();
			List<likeCommand> listL=null;
			return listL;
		}
	}
}
