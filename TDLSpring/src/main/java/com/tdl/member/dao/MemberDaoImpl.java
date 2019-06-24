package com.tdl.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tdl.member.domain.*;

//SqlSessionDaoSupport ��ӹ޴� ���� -> SqlSession��ü�� �ڵ����� ��ȯ getSqlSession()
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	//ID�ߺ�üũ
	public int checkId(String id) {
		// TODO Auto-generated method stub
		int check = 0;
		System.out.println("checkId�޼������"+id);		
		String Idcheck=getSqlSession().selectOne("checkId",id);
		System.out.println("checkId�޼���=>"+Idcheck);
		if(Idcheck!=null) {
			check=1;
		}
		System.out.println("checkId�޼���check=>"+check);
		return check;
	}
	//ȸ������
	public void register(MemberCommand mem) {
		// TODO Auto-generated method stub
		getSqlSession().insert("register",mem);
		getSqlSession().insert("justLog",mem);
	}
	//�α���üũ
	public int loginCheck(MemberCommand mem) {
		// TODO Auto-generated method stub
		int check=0;
		MemberCommand loginCheck=getSqlSession().selectOne("loginCheck",mem);
		System.out.println("loginCheck=>"+loginCheck);
		if(loginCheck!=null) {
			check=1;
		}		
		return check;
	}
	//ȸ������ ��������
	public MemberCommand getMember(String TU_id) {
		// TODO Auto-generated method stub
		MemberCommand mem = getSqlSession().selectOne("mypage",TU_id);
		
		return mem;
	}
	//ȸ������
	public void updateMember(MemberCommand mem) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateMember",mem);
		getSqlSession().update("updateLog",mem);
		System.out.println("updateMember�߽����!");
	}
	
	//ȸ��Ż�� �� �н����� ��������
	public String getPasswd(String TU_id) {
		// TODO Auto-generated method stub
		String TU_passwd=getSqlSession().selectOne("getPasswd",TU_id);
		
		return TU_passwd;
	}
	
	//ȸ��Ż��
	public void deleteMember(String TU_id) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteMember",TU_id);
	}
	
}
