package com.tdl.member.dao;

import com.tdl.member.domain.MemberCommand;

public interface MemberDao {
	
		//ID�ߺ�üũ
		public int checkId(String id);
		//ȸ������
		public void register(MemberCommand mem);
		
		//�α���üũ
		public int loginCheck(MemberCommand mem);
		
		//ȸ������ ��������
		public MemberCommand getMember(String TU_id);
		
		//ȸ������
		public void updateMember(MemberCommand mem);
		
		//ȸ��Ż���Ҷ� ���� �н����� ��������
		public String getPasswd(String TU_id);
	
		//ȸ��Ż��
		public void deleteMember(String TU_id);
}


