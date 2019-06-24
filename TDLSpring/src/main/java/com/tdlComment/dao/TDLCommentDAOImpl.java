package com.tdlComment.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tdlComment.domain.*;
import com.tdlLike.domain.likeCommand;

@Repository
public class TDLCommentDAOImpl extends SqlSessionDaoSupport implements TDLCommentDAO {

	//��´�� ����Ʈ�� ���
	public List<CommentCommand> listC(Integer TPC_num) {
		List<CommentCommand> listC=getSqlSession().selectList("selectListC",TPC_num);
		System.out.println("��� TDL_Comment-> ListDaoImpl �׽�Ʈ���Դϴ�.~ TPC_num =>"+TPC_num);
		return listC;
	}
	
	//�� ��´�� ����
	public int getRowCountC(Integer TPC_num) {
		try {
			System.out.println("��� getRowCountC()ȣ���!");
			return getSqlSession().selectOne("selectCountC",TPC_num);
		}catch(Exception e) {
			return TPC_num=0;
		}
	}
	
	//��� �ִ밪 ��ȣ
	public int getNewNumC(Integer TPC_num) {
		int newnumC;
		try {
			System.out.println("����ۼ��� �Խù���ȣ => "+TPC_num);
			newnumC=getSqlSession().selectOne("getNewNumC",TPC_num);
			System.out.println("��� �ִ밪 => "+TPC_num);
		} catch (Exception e) {
			newnumC=0;
			System.out.println("��� ù ���� ");
		}
		
		System.out.println(newnumC);
		System.out.println("��� getNewNumC()�� newnumC=>"+newnumC);
		return newnumC;
	}
	
	//��۾���
	public void insertC(CommentCommand TDLComment) {
		getSqlSession().insert("insertTDLComment",TDLComment);
	}
	
	//��ۻ���
	public void deleteC(String TPC_num) {
		getSqlSession().delete("deleteC",TPC_num);
		
	}
	
	//���ƿ� ����
	public void likeUp(String TPC_addr) {
		getSqlSession().update("likeUp",TPC_addr);
		
	}
	
	//���ƿ� ���
	public void likeDown(String TPC_addr) {
		getSqlSession().update("likeDown",TPC_addr);
	}

}