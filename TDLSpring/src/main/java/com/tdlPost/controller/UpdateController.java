package com.tdlPost.controller;

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

import com.tdlPost.dao.TDLPostDAO;
import com.tdlPost.domain.TdlCommand;


@Controller
public class UpdateController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLPostDAO TDLPostDAO;
	 
	
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
		@RequestMapping(value="/TDL_POST/TDLPostUpdate.do",method=RequestMethod.POST)
		public String submit(@ModelAttribute("command") TdlCommand command) {
			if(log.isDebugEnabled()) {
				log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
				//�αװ�ü��.debug(��´���ڸ� �Է�)
			}
			//��ȿ���˻�			

				//�۾��� ȣ��
				TDLPostDAO.update(command);
				System.out.println("�����Խ��� �ۼ��� TP_title =>"+command.getTP_title());
				System.out.println("�����Խ��� �ۼ��� TP_content =>"+command.getTP_content());

			//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
			return "redirect:/TDL_POST/TDLPostList.do";
		}
	
	 //1.�ۼ��� ������ �̵�(Get���)
		@RequestMapping(value="/TDL_POST/TDLPostUpdate.do",method=RequestMethod.GET)
		public ModelAndView form(@ModelAttribute("command")  TdlCommand command) {  //�޼������ ���Ƿ� �ۼ�
			System.out.println("������Ʈ ������ �̵� UpdateController  ȣ���!");
			int TP_num = command.getTP_num();
			if(log.isDebugEnabled()) {//�αװ�ü�� �۵����̶��(����׻���)
				log.debug("TP_num =>"+TP_num); //System.out.println("seq=>"+seq);
			}
			TDLPostDAO.selectTDLPost(TP_num);
			TdlCommand TDLPost=TDLPostDAO.selectTDLPost(TP_num);
			System.out.println("�� ���� => "+TDLPost.getTP_title());
			System.out.println("�� ���� =>"+TDLPost.getTP_content());
			
			//									1. �̵��� ������           2. Ű��     3. Ű��
			return new ModelAndView("TDL_POST/TDLPostUpdate","article",TDLPost);// ${board}
		}
	
}

