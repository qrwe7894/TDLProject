package com.tdlPost.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tdlPost.domain.*;

@Repository
public class TDLPostDAOImpl extends SqlSessionDaoSupport implements TDLPostDAO {

	//
	public List<TdlCommand> list(Map<String, Object> map) {
		List<TdlCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("TDL_POST -> ListDaoImpl �׽�Ʈ���Դϴ�.~");
		return list;
	}

	//�Խù� ��
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println("getRowCount()ȣ���!");
		return getSqlSession().selectOne("selectCount",map);
	}

	//�� ��������ȣ -> max(TP_num)
	public int getNewNumP() {
		int newnum=(Integer)getSqlSession().selectOne("getNewNumP");
		System.out.println("getNewNumP()�� newnum=>"+newnum);
		return newnum;
	}
	
	//�� �ۼ�
	public void insert(TdlCommand TDLPost) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertTDLPost",TDLPost);
	}
	
	//��ȸ�� ����
	public void updateHit(Integer TP_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",TP_num);
	}
	
	//�� �󼼺���
	public TdlCommand selectTDLPost(Integer TP_num) {
		// TODO Auto-generated method stub
		return (TdlCommand)getSqlSession().selectOne("selectTDLPost",TP_num);
	}
	
	//�ۻ���
	public void delete(Integer TP_num) {
		getSqlSession().delete("delete",TP_num);
	}
	
	//�ۼ���
	public void update(TdlCommand TDLPost) {
		// TODO Auto-generated method stub
		getSqlSession().update("updatePost",TDLPost);
	}
	
	
}
