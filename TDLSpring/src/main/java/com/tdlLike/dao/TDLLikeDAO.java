package com.tdlLike.dao;

import java.util.List;
import java.util.Map;

import com.tdlLike.domain.*;
import com.tdlLike.domain.likeCommand;
import com.tdlPost.domain.TdlCommand;


public interface TDLLikeDAO {

	//���ƿ�
	public void insertLike(likeCommand TDLLike);
	
	//���ƿ����
	public void deleteLike(likeCommand TDLLike);
	
	//���ƿ� üũ����
	public List<likeCommand> likeCheck(likeCommand TDLLike);
}
