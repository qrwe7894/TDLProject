package com.tdlNotice.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tdlNotice.dao.*;
import com.tdlNotice.domain.*;


@Controller
public class UpdateController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLNoticeDAO TDLNoticeDAO;
	 
	
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
		@RequestMapping(value="/TDL_NOTICE/TDLNoticeUpdate.do",method=RequestMethod.POST)
		public String submit(@ModelAttribute("commandN") noticeCommand commandN) {
			if(log.isDebugEnabled()) {
				log.debug("noticeCommand=>"+commandN);//�Է¹��� ���� ���
				//�αװ�ü��.debug(��´���ڸ� �Է�)
			}
			//��ȿ���˻�			

				//�۾��� ȣ��
				TDLNoticeDAO.update(commandN);
				System.out.println("�������� �ۼ��� TN_title =>"+commandN.getTN_title());
				System.out.println("�������� �ۼ��� TN_content =>"+commandN.getTN_content());

			//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
				return "redirect:/TDL_NOTICE/TDLNoticeList.do";
		}
	
	 //1.�ۼ��� ������ �̵�(Get���)
		@RequestMapping(value="/TDL_NOTICE/TDLNoticeUpdate.do",method=RequestMethod.GET)
		public ModelAndView form(@ModelAttribute("commandN")  noticeCommand commandN) {  //�޼������ ���Ƿ� �ۼ�
			System.out.println("������Ʈ ������ �̵� UpdateController  ȣ���!");
			int TN_num = commandN.getTN_num();
			if(log.isDebugEnabled()) {//�αװ�ü�� �۵����̶��(����׻���)
				log.debug("TN_num =>"+TN_num); //System.out.println("seq=>"+seq);
			}
			//������� �ٽ��ϱ�
			TDLNoticeDAO.selectTDLNotice(TN_num);
			noticeCommand tdlNotice=TDLNoticeDAO.selectTDLNotice(TN_num);
			System.out.println("�� ���� => "+tdlNotice.getTN_title());
			System.out.println("�� ���� =>"+tdlNotice.getTN_content());
			
			//									1. �̵��� ������           2. Ű��     3. Ű��
			return new ModelAndView("TDL_NOTICE/TDLNoticeUpdate","articleN",tdlNotice);// ${board}
		}
	
}

