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

import com.tdlPost.dao.TDLPostDAO;
import com.tdlPost.domain.TdlCommand;


@Controller
public class DeleteController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLPostDAO TDLPostDAO;
	 

	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDL_POST/TDLPostDelete.do",method=RequestMethod.GET)
	public String submit(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		int TP_num = command.getTP_num();
		//�ۻ���
			System.out.println("������ TP_num =>"+TP_num);
			TDLPostDAO.delete(TP_num);
			System.out.println("���� ����! ");
		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
			return "redirect:/TDL_POST/TDLPostList.do";
	}
}

