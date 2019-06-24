package com.tdlComment.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.tdlComment.dao.*;
import com.tdlComment.domain.*;


@Controller
public class WriterController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;//��� DAO
	 
	
	@RequestMapping(value="/TDL_Comment/TDLCommentWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandC") CommentCommand commandC,
									BindingResult result,
			                     @RequestParam(value="TP_num")int TP_num,
			                     @RequestParam(value="TP_id")String TP_id,
			                     @RequestParam(value="TU_id")String TU_id,HttpServletRequest request) {
	
		if(log.isDebugEnabled()) {
			System.out.println("����� ����ۼ� ����");
			System.out.println("TP_num =>"+TP_num);
			System.out.println("TP_id =>"+TP_id);
			System.out.println("TU_id =>"+TU_id);
			log.debug("CommentCommand=>"+commandC);//�Է¹��� ���� ���
			//�αװ�ü��.debug(��´���ڸ� �Է�)
		}
			
			int TPC_num=TP_num;
			String id=TU_id;
			commandC.setTPC_id(id);
			commandC.setTPC_num(TP_num);
			//�ִ밪+1
			System.out.println("TPC_num =>"+TPC_num);
			int newNumC=TDLCommentDAO.getNewNumC(TPC_num)+1;
			System.out.println("newNumC=>"+newNumC);//1->2
			//�Խù���ȣ->���->����
			//String addr =�����Խù���ȣ+"c"+�ִ밪 ��ȣ+"c"+��۱��й�ȣ;
			String addr=TP_num+"c"+newNumC+"c"+0;
			commandC.setTPC_addr(addr);
			commandC.setTPC_ref(newNumC);//2
			
			//�۾��� ȣ��
			System.out.println("��� �ۼ� TPC_id =>"+commandC.getTPC_id());
			System.out.println("��� �ۼ� TPC_num =>"+commandC.getTPC_num());
			System.out.println("��� �ۼ� TPC_content =>"+commandC.getTPC_content());
			System.out.println("�Խù��ѹ� �����ֱ� =>"+TP_num);
			TDLCommentDAO.insertC(commandC);
			System.out.println("��� �ۼ� TPC_date =>"+commandC.getTPC_date());
			
			request.setAttribute("TP_num", TP_num);
			request.setAttribute("TP_id", TP_id);
			request.setAttribute("TU_id", TU_id);
			return "redirect:/TDL_POST/TDLPostContent.do?TP_num="+TP_num+"&TP_id='"+TP_id+"'&TU_id='"+TU_id+"'";
	}
}

