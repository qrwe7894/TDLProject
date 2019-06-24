package com.tdlNotice.dao;

import java.util.List;
import java.util.Map;

import com.tdlNotice.domain.*;
import com.tdlPost.domain.TdlCommand;


public interface TDLNoticeDAO {

	//1.��Ϻ���
	public List<noticeCommand> list(Map<String,Object>map);
			
	//2.�ѷ��ڵ��
	public int getRowCount(Map<String,Object>map);

	//3.�ִ밪 ��ȣ ���ϱ�
	public int getNewNumN();
		
	//4.�Խ����� �۾���
	public void insert(noticeCommand TDLNotice);
	
	//5.�Խù���ȣ�� �ش��ϴ� ��ȸ�� ����
	public void updateHitN(Integer TN_num);
	
	//6.�ۻ󼼺���
	public noticeCommand selectTDLNotice(Integer TN_num);//~(int seq);

	//7.�ۻ���
	public void delete(Integer TN_num);
	
	//8.�ۼ���
	public void update(noticeCommand TDLNotice);
}
