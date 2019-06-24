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

import com.tdlNotice.dao.TDLNoticeDAO;
import com.tdlNotice.domain.noticeCommand;


@Controller
public class DeleteController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLNoticeDAO TDLNoticeDAO;
	 

	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDL_NOTICE/TDLNoticeDelete.do",method=RequestMethod.GET)
	public String submit(@ModelAttribute("commandN") noticeCommand commandN,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("noticeCommand=>"+commandN);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		int TN_num = commandN.getTN_num();
		//�ۻ���
			System.out.println("������ TN_num =>"+TN_num);
			TDLNoticeDAO.delete(TN_num);
			System.out.println("�������� ���� ����! ");
		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
			return "redirect:/TDL_NOTICE/TDLNoticeList.do";
	}
}

