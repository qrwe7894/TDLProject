package com.tdlNotice.controller;


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
public class WriterController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLNoticeDAO TDLNoticeDAO;
	 
	/*
	 * �ϳ��� ��û��ɾ�=>�ϳ��� ��Ʈ�ѷ��� ���X
	 * �ϳ��� ��Ʈ�ѷ�->�������� ��û��ɾ ����ؼ� ����� ����.
	 * ���� ��û��ɾ GET or POST���� ���������� �����ϴ� �Ӽ�
	 * method=RequestMethod.GET | method=RequestMethod.POST
	 */
	 //1.�۾��� ������ �̵�(Get���)
	@RequestMapping(value="/TDL_NOTICE/TDLNoticeWrite.do",method=RequestMethod.GET)
	public String form() {  //�޼������ ���Ƿ� �ۼ�
		System.out.println("�������� �۾��� -> �ٽ� ó������ ���� �Է¹ޱ����ؼ� form()ȣ���!");
		return "TDL_NOTICE/TDLNoticeWrite";// return "�̵��� ��������'//definition name�� ����
	}
	
	//2.�����޼��� ���=>�ٽ� �ʱ�ȭ�� �����ϰ� ����->@ModelAttribute("Ŀ�ǵ尴ü ��Ī��")
	@ModelAttribute("commandN")
	public noticeCommand forBacking() { //��ȯ�� (DTO��) ������ �޼����
		System.out.println("�������� -> forBacking()ȣ���!");
		return new noticeCommand();
	}
	//3.�Է��ؼ� ��ȿ���˻�->�����߻�
	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDL_NOTICE/TDLNoticeWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandN") noticeCommand commandN,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("noticeCommand=>"+commandN);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		//��ȿ���˻�			
			//�ִ밪+1
			int newNumN=TDLNoticeDAO.getNewNumN()+1;
			System.out.println("newNumN=>"+newNumN);//1->2
			//�Խù���ȣ->���->����
			commandN.setTN_num(newNumN);//2
			//�۾��� ȣ��
			TDLNoticeDAO.insert(commandN);
			System.out.println("�������� �۾��� TN_id =>"+commandN.getTN_id());
			System.out.println("�������� �۾��� TN_num =>"+commandN.getTN_num());
			System.out.println("�������� �۾��� TN_date =>"+commandN .getTN_date());
			System.out.println("�������� �۾��� TN_readcont =>"+commandN.getTN_readcount());
			System.out.println("�������� �۾��� TN_title =>"+commandN.getTN_title());
			System.out.println("�������� �۾��� TN_content =>"+commandN.getTN_content());

		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
		return "redirect:/TDL_NOTICE/TDLNoticeList.do";
	}
}

