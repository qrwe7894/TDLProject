package com.tdlLike.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//���DB
import com.tdlComment.dao.*;
import com.tdlComment.domain.*;

//���ƿ�DB
import com.tdlLike.dao.*;
import com.tdlLike.domain.*;


@Controller
public class DeleteController {
        //Logger��ü=>����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ���
	   //                      �����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLLikeDAO TDLLikeDAO;//���ƿ� DAO
	
	@Autowired
	private TDLCommentDAO TDLCommentDAO;//���DAO
	 
	
	@RequestMapping(value="/TDLLike/TDLLikeDown.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandL") likeCommand commandL,BindingResult result,
								 @RequestParam(value="TP_num")int TP_num,
			                     @RequestParam(value="TPC_addr")String TPC_addr,
			                     @RequestParam(value="TU_id")String TU_id) {
	
			System.out.println("����� ���ƿ� ��� ����");
			System.out.println("TP_num =>"+TP_num);
			System.out.println("TP_id =>"+TPC_addr);
			System.out.println("TU_id =>"+TU_id);

			String addr=TPC_addr+TU_id;
			commandL.setTL_addrL(addr);// ���ƿ��� �Ϸù�ȣ -> ����Ϸù�ȣ+�������̵�
			commandL.setTL_id(TU_id);//�������̵�
			commandL.setTL_addrC(TPC_addr);//����Ϸù�ȣ
			commandL.setTL_PNUM(TP_num);//�����Խ��� �Խù� ��ȣ 
			try{
				TDLLikeDAO.deleteLike(commandL);
				TDLCommentDAO.likeDown(TPC_addr);
				System.out.println("���ƿ� ��� ����!!!");
			}catch(Exception e) {
				System.out.println("���ƿ� ��� ����!!!");
			}
			
			System.out.println("���ƿ� TL_addr =>"+commandL.getTL_addrL());
			System.out.println("���ƿ� TL_id =>"+commandL.getTL_id());
			System.out.println("���ƿ� TL_like =>"+commandL.getTL_addrC());
			System.out.println("���ƿ� TL_PNUM =>"+commandL.getTL_PNUM());

		return "redirect:/TDL_POST/TDLPostList.do";
	}
}

