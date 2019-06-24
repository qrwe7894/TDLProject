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
public class WriterController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLPostDAO TDLPostDAO;
	 
	/*
	 * �ϳ��� ��û��ɾ�=>�ϳ��� ��Ʈ�ѷ��� ���X
	 * �ϳ��� ��Ʈ�ѷ�->�������� ��û��ɾ ����ؼ� ����� ����.
	 * ���� ��û��ɾ GET or POST���� ���������� �����ϴ� �Ӽ�
	 * method=RequestMethod.GET | method=RequestMethod.POST
	 */
	 //1.�۾��� ������ �̵�(Get���)
	@RequestMapping(value="/TDL_POST/TDLPostWrite.do",method=RequestMethod.GET)
	public String form() {  //�޼������ ���Ƿ� �ۼ�
		System.out.println("�ٽ� ó������ ���� �Է¹ޱ����ؼ� form()ȣ���!");
		return "TDL_POST/TDLPostWrite";// return "�̵��� ��������'//definition name�� ����
	}
	
	//2.�����޼��� ���=>�ٽ� �ʱ�ȭ�� �����ϰ� ����->@ModelAttribute("Ŀ�ǵ尴ü ��Ī��")
	@ModelAttribute("command")
	public TdlCommand forBacking() { //��ȯ�� (DTO��) ������ �޼����
		System.out.println("forBacking()ȣ���!");
		return new TdlCommand();//BoardCommand bc=new BoardCommand();
	}
	//3.�Է��ؼ� ��ȿ���˻�->�����߻�
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDL_POST/TDLPostWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		//��ȿ���˻�			
			//�ִ밪+1
			int newNum=TDLPostDAO.getNewNumP()+1;
			System.out.println("newNum=>"+newNum);//1->2
			//�Խù���ȣ->���->����
			command.setTP_num(newNum);//2
			//�۾��� ȣ��
			TDLPostDAO.insert(command);
			System.out.println("�����Խ��� �۾��� TP_id =>"+command.getTP_id());
			System.out.println("�����Խ��� �۾��� TP_num =>"+command.getTP_num());
			System.out.println("�����Խ��� �۾��� TP_date =>"+command.getTP_date());
			System.out.println("�����Խ��� �۾��� TP_readcont =>"+command.getTP_readcount());
			System.out.println("�����Խ��� �۾��� TP_title =>"+command.getTP_title());
			System.out.println("�����Խ��� �۾��� TP_content =>"+command.getTP_content());

		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
		return "redirect:/TDL_POST/TDLPostList.do";
	}
}

