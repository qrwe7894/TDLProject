package com.tdlPost.domain;

public class TdlCommand {

	private int TP_num;  // �����Խ��� �� ��ȣ
	private String TP_title; //�����Խ��� ����
	private String TP_id; //���� ���̵�
	private String TP_date;// �ۼ���
	private String TP_content; //�� ����
	private int TP_readcount;// ��ȸ��
	
	public int getTP_num() {
		return TP_num;
	}
	public void setTP_num(int TP_num) {
		this.TP_num = TP_num;
	}
	public String getTP_title() {
		return TP_title;
	}
	public void setTP_title(String TP_title) {
		TP_title=convert(TP_title);
		this.TP_title = TP_title;
	}
	public String getTP_id() {
		return TP_id;
	}
	public void setTP_id(String TP_id) {
		this.TP_id = TP_id;
	}
	public String getTP_date() {
		return TP_date;
	}
	public void setTP_date(String TP_date) {
		this.TP_date = TP_date;
	}
	public String getTP_content() {
		return TP_content;
	}
	public void setTP_content(String TP_content) {
		TP_content=convert(TP_content);
		this.TP_content = TP_content;
	}
	public int getTP_readcount() {
		return TP_readcount;
	}
	public void setTP_readcount(int TP_readcount) {
		this.TP_readcount = TP_readcount;
	}
	
	
	private String convert(String name) {
		 if(name!=null){
	    	   //���ڿ��޼���->replaceAll(1.���������ڿ�,2.�����Ĺ��ڿ�) 
	    	   name=name.replaceAll("<", "&lt;");
	    	   name=name.replaceAll(">", " &gt;");
	    	   name=name.replaceAll("\\(","&#40");
	    	   name=name.replaceAll("\\)","&#41");
	    	   name=name.replaceAll("\"","&quot");
	    	   name=name.replaceAll("\'","&apos");
	       }else{//name==null
	    	   return null;//�Է��� ���� �ʾҵ��� �� �̻� ����X
	       }  
		 return name;
	}

	
	
}

