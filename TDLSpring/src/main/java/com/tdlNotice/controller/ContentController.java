package com.tdlNotice.controller;

import org.apache.log4j.Logger;//�αװ�ü�� �ҷ��������� Ŭ����
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdlNotice.dao.*;
import com.tdlNotice.domain.*;

@Controller
public class ContentController {

		//�αװ�ü�� ���� ->�Ű���������,��û�� �޾Ƽ� ����� ó�� -> �ֿܼ� ���(������)
		private Logger log=Logger.getLogger(this.getClass());//�˻��� Ŭ�������� ���
		
		@Autowired
		private TDLNoticeDAO TDLNoticeDAO;//byType�� �̿��ؼ� BoardDao ��ü�� �ڵ����� ��������ü
		
		// /board/detail.do?seq=4 ->boardView.jsp
		@RequestMapping("/TDL_NOTICE/TDLNoticeContent.do")
		public ModelAndView process(@RequestParam("TN_num") int TN_num) {
		System.out.println("�������� ContentController ����");
		//int seq=Integer.parseInt(request.getParameter("seq"));
		if(log.isDebugEnabled()) {//�αװ�ü�� �۵����̶��(����׻���)
			log.debug("TN_num =>"+TN_num); //System.out.println("seq=>"+seq);
		}
		
		//1.��ȸ�� ����
		TDLNoticeDAO.updateHitN(TN_num);
		
		noticeCommand TDLNotice=TDLNoticeDAO.selectTDLNotice(TN_num);//int -> Integer
		//�۳��� \r\n aaaa \r\n -> �޼���� ���� <pre></pre>
		
		/*
		ModelAndView mav=new ModelAndView("boardView"); // ~ setViewName("boardView");
		mav.addObject("board",board); // request.setAttribute("board",board);
		return mav;
		*/  //1.�̵��� �������� 2.������ Ű�� 3.�����Ұ�
		ModelAndView mav=new ModelAndView("TDLNoticeContent"); 
		mav.setViewName("TDL_NOTICE/TDLNoticeContent");
		mav.addObject("articleN",TDLNotice); 
		return mav;
	}		 
}


