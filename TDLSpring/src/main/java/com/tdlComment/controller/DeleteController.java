package com.tdlComment.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdlComment.dao.TDLCommentDAO;
import com.tdlComment.domain.CommentCommand;


@Controller
public class DeleteController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;
	 

	//BindingResult->��ȿ���˻綧���� �ʿ�=>����������ü�� ����
	@RequestMapping(value="/TDL_Comment/TDLCommentDelete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandC") CommentCommand commandC,
			                       BindingResult result,
			                       @RequestParam(value="likeAddr")String TP_addr,
			                       @RequestParam(value="TP_id")String TP_id,
			                       @RequestParam(value="TP_num")int TP_num,				                     
				                     @RequestParam(value="TU_id")String TU_id) {
		
		System.out.println("����´�ۻ�����!"+TP_num+"   "+TU_id);
		if(log.isDebugEnabled()) {
			System.out.println("��ۻ��� ����");
			log.debug("CommentCommand=>"+commandC);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
		String TPC_addr = TP_addr;
		//�ۻ��� 
			System.out.println("��� ������ TP_addr =>"+TP_addr);
			TDLCommentDAO.deleteC(TP_addr);
			System.out.println("��� ���� ����! ");
		//return "redirect:��û��ɾ�"; =>return "�̵��� ��������"
			return "redirect:/TDL_POST/TDLPostContent.do?TP_num="+TP_num+"&TP_id='"+TP_id+"'&TU_id='"+TU_id+"'";
	}
}

