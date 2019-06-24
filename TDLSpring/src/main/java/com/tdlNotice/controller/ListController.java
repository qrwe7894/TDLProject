package com.tdlNotice.controller;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//---------�α׿� ����� ���ֵ��� ����(Annotation)--
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//---------�޼���ȣ�� �� ����¡ ó���κ�---------------
import com.tdlNotice.dao.*;
import com.tdlNotice.domain.noticeCommand;
import com.tdlPost.util.*;

@Controller
public class ListController {
	
	//private Logger log=Logger.getLogger(ListController.class); //�α׸� ó���� Ŭ������
	private Logger log = Logger.getLogger(this.getClass());//this.getClass()->����Ŭ������
	
	//�ڵ����� Setter Methodȣ��X->��������ü �־���
	@Autowired
	private TDLNoticeDAO tdlNoticeDAO;//�ڵ����� Setter Method ȣ��X=>��������ü �־���(byType)

	@RequestMapping("/TDL_NOTICE/TDLNoticeList.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){
		if(log.isDebugEnabled()){ //�αװ�ü�� �������������� �ƴ����� üũ
			System.out.println("����� ���� �������� list.do");
			log.debug("currentPage : " + currentPage);//log.debug�޼��� ���
			log.debug("keyField : " + keyField);
			log.debug("keyWord : " + keyWord);
		}
		//�˻��о�,�˻�� ����->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField", keyField);//�˻��о�
		map.put("keyWord", keyWord);//�˻���
		 
		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
		int count=tdlNoticeDAO.getRowCount(map);	    
		//����¡ ó��  1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.���� �������� 5.��û��ɾ�
		PagingUtil page = new PagingUtil(currentPage, count, 10,3, "tdlNoticeList.do");	
		//start->�������� �� ù��° ������ �Խù���ȣ 
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//�������Խù���ȣ
		
		List<noticeCommand> list = null;
		if(count > 0){
			System.out.println("����� DAO ȣ�� count=>"+count);
			list = tdlNoticeDAO.list(map);
		}else{ 
			list = Collections.emptyList();
			System.out.println("ListControllerŬ������ count="+count);
		}
		ModelAndView  mav = new ModelAndView("TDLNoticeList");
		mav.setViewName("TDL_NOTICE/TDLNoticeList");//tdlNoticeList.jsp
		mav.addObject("count", count);//�ѷ��ڵ��
		mav.addObject("list", list);//���ڵ���ü��
		mav.addObject("pagingHtml", page.getPagingHtml());//��ũ���ڿ��� ����
		return mav;
	}
}























