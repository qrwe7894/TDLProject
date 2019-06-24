package com.tdlPost.dao;

import java.util.List;
import java.util.Map;

import com.tdlPost.domain.*;

public interface TDLPostDAO {

	//1.��Ϻ���
		public List<TdlCommand> list(Map<String,Object>map);
		
		//2.�ѷ��ڵ��
		public int getRowCount(Map<String,Object>map);
		
		//3.�ִ밪 ��ȣ ���ϱ�
		public int getNewNumP();
	
		//4.�Խ����� �۾���
		public void insert(TdlCommand TDLPost);
		
		//5.�Խù���ȣ�� �ش��ϴ� ��ȸ�� ����
		public void updateHit(Integer TP_num);
		
		//6.�ۻ󼼺���
		public TdlCommand selectTDLPost(Integer TP_num);//~(int seq);
		
		//7.�ۻ���
		public void delete(Integer TP_num);
		
		//8.�ۼ���
		public void update(TdlCommand TDLPost);
		
	
}
