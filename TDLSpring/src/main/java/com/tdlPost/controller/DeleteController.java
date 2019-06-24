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
        //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력
	   //                      시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private TDLPostDAO TDLPostDAO;
	 

	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/TDL_POST/TDLPostDelete.do",method=RequestMethod.GET)
	public String submit(@ModelAttribute("command") TdlCommand command,
			                       BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("TdlCommand=>"+command);//입력받은 값을 출력
			//로그객체명.debug(출력대상자를 입력)
		}
		int TP_num = command.getTP_num();
		//글삭제
			System.out.println("삭제할 TP_num =>"+TP_num);
			TDLPostDAO.delete(TP_num);
			System.out.println("삭제 성공! ");
		//return "redirect:요청명령어"; =>return "이동할 페이지명"
			return "redirect:/TDL_POST/TDLPostList.do";
	}
}

