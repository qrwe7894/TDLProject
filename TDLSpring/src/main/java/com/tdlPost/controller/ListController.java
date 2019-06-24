package com.tdlPost.controller;

import java.util.*;

//---------�α׿� ����� ���ֵ��� ����(Annotation)--
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//---------�޼���ȣ�� �� ����¡ ó���κ�---------------
import com.tdlPost.dao.TDLPostDAO;//DB����
import com.tdlPost.domain.TdlCommand;//DTO
import com.tdlPost.util.PagingUtil;//����¡ó�� ����

@Controller
public class ListController {
	
	//private Logger log=Logger.getLogger(ListController.class); //�α׸� ó���� Ŭ������
	private Logger log = Logger.getLogger(this.getClass());//this.getClass()->����Ŭ������
	
	//�ڵ����� Setter Methodȣ��X->��������ü �־���
	@Autowired
	private TDLPostDAO TDLPostDAO;//�ڵ����� Setter Method ȣ��X=>��������ü �־���(byType)
	
	@RequestMapping("/TDL_POST/TDLPostList.do")
	public ModelAndView process
	   (@RequestParam(value="pageNum",defaultValue="1")int currentPage,
	    @RequestParam(value="keyField",defaultValue="")String keyField,
	    @RequestParam(value="keyWord",defaultValue="")String keyWord){
		if(log.isDebugEnabled()){ //�αװ�ü�� �������������� �ƴ����� üũ
			System.out.println("����� ���� list.do");
			log.debug("currentPage : " + currentPage);//log.debug�޼��� ���
			log.debug("keyField : " + keyField);
			log.debug("keyWord : " + keyWord);
		}
		//�˻��о�,�˻�� ����->parameteType="map"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyField", keyField);//�˻��о�
		map.put("keyWord", keyWord);//�˻���
		
		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
		int count=TDLPostDAO.getRowCount(map);	    
		//����¡ ó��  1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.���� �������� 5.��û��ɾ�
		PagingUtil page = new PagingUtil(currentPage, count, 10,3, "TDLPostList.do");	
		//start->�������� �� ù��° ������ �Խù���ȣ
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());//�������Խù���ȣ
		
		List<TdlCommand> list = null;
		if(count > 0){
			System.out.println("����� DAO ȣ��");
			list = TDLPostDAO.list(map);
		}else{
			list = Collections.emptyList();
			System.out.println("ListControllerŬ������ count="+count);
		}
		ModelAndView  mav = new ModelAndView("TDLPostList");
		mav.setViewName("TDL_POST/TDLPostList");//TDLPostList.jsp
		mav.addObject("count", count);//�ѷ��ڵ��
		mav.addObject("list", list);//���ڵ���ü��
		mav.addObject("pagingHtml", page.getPagingHtml());//��ũ���ڿ��� ����
		System.out.println("�����Խ��� ��");
		return mav;
	}
}























