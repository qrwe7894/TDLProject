package com.tdlPost.controller;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;//�αװ�ü�� �ҷ��������� Ŭ����
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//�����Խ��� DB ����
import com.tdlPost.dao.TDLPostDAO;
import com.tdlPost.domain.TdlCommand;

//���DB����
import com.tdlComment.dao.*;
import com.tdlComment.domain.*;

//���ƿ�DB����
import com.tdlLike.dao.*;
import com.tdlLike.domain.*;

@Controller
public class ContentController {

		//�αװ�ü�� ���� ->�Ű���������,��û�� �޾Ƽ� ����� ó�� -> �ֿܼ� ���(������)
		private Logger log=Logger.getLogger(this.getClass());//�˻��� Ŭ�������� ���
		
		@Autowired
		private TDLPostDAO TDLPostDAO;//byType�� �̿��ؼ� BoardDao ��ü�� �ڵ����� ��������ü
		
		@Autowired
		private TDLCommentDAO TDLCommentDAO;//��� DAO
		
		@Autowired
		private TDLLikeDAO TDLLikeDAO;//���ƿ� DAO
		
		// �����Խ��� �Խù�
		@RequestMapping("/TDL_POST/TDLPostContent.do")
		public ModelAndView process(@ModelAttribute("commandL") likeCommand commandL,BindingResult result,
													@RequestParam(value="TP_num",defaultValue="1") int TP_num,
													@RequestParam(value="TU_id",defaultValue="false") String TU_id, HttpServletRequest request) {
		System.out.println("�����Խ��� ContentController ����");
		System.out.println("TP_NUM=>"+TP_num);
		if(TP_num==1) {
			System.out.println("TP_NUM=>"+TP_num);
			TP_num=(Integer)request.getAttribute("TP_num");
			
		}
		if(TU_id=="false") {
			TU_id=(String)request.getAttribute("TU_id");
		}
		//int seq=Integer.parseInt(request.getParameter("seq"));
		if(log.isDebugEnabled()) {//�αװ�ü�� �۵����̶��(����׻���)
			log.debug("TP_num =>"+TP_num); //System.out.println("seq=>"+seq);
		}
		//1.��ȸ�� ����
		TDLPostDAO.updateHit(TP_num);
		TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);//int -> Integer
		//�۳��� \r\n aaaa \r\n -> �޼���� ���� <pre></pre>
		
		
		//������ʹ� ���
		int TPC_num=TP_num;
		 
		int countC=TDLCommentDAO.getRowCountC(TPC_num);
				 
		List<CommentCommand> listC = null;
		if(countC > 0){
			System.out.println("����� DAO ȣ�� countC =>"+countC);
			listC = TDLCommentDAO.listC(TPC_num);
		}else{
			listC = Collections.emptyList();
			System.out.println("��� ListControllerŬ������ count="+countC);
		}
		
		//���ƿ� üũ
		System.out.println("���ƿ�üũ ���̵� =>"+TU_id);
		System.out.println("���ƿ�üũ �Խù���ȣ =>"+TU_id);
		commandL.setTL_id(TU_id);
		commandL.setTL_PNUM(TP_num);
		List<likeCommand> likeCheck=TDLLikeDAO.likeCheck(commandL);
		
		
		/*
		ModelAndView mav=new ModelAndView("boardView"); // ~ setViewName("boardView");
		mav.addObject("board",board); // request.setAttribute("board",board);
		return mav;
		*/  //1.�̵��� �������� 2.������ Ű�� 3.�����Ұ�
		ModelAndView mav=new ModelAndView("TDLPostContent"); 
		mav.setViewName("TDL_POST/TDLPostContent");
		mav.addObject("article",TDLPost); 
		mav.addObject("listC",listC);
		mav.addObject("sumCountC",countC);
		mav.addObject("likeCheck",likeCheck);
		return mav;
	}		 
}


