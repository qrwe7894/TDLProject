package com.tdlComment.dao;

import java.util.List;
import java.util.Map;

import com.tdlComment.domain.*;
import com.tdlPost.domain.TdlCommand;

public interface TDLCommentDAO {

	//1.��Ϻ���
	public List<CommentCommand> listC(Integer TPC_num);
		
	//2.�ѷ��ڵ��
	public int getRowCountC(Integer TPC_num);
		
	//3.�ִ밪 ��ȣ ���ϱ�
	public int getNewNumC(Integer TPC_num);
		
	//4.��� �۾���
	public void insertC(CommentCommand TDLComment);
		
	//5.�ۻ���
	public void deleteC(String TPC_num);
	
	//6.���ƿ� ����
	public void likeUp(String TPC_addr);
	
	//7.���ƿ� ���
	public void likeDown(String TPC_addr);
}
 