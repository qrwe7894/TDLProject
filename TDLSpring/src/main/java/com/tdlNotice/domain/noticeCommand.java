package com.tdlNotice.domain;

public class noticeCommand {

	private int TN_num;  // �����Խ��� �� ��ȣ
	private String TN_title; //�����Խ��� ����
	private String TN_id; //���� ���̵�
	private String TN_date;// �ۼ���
	private String TN_content; //�� ����
	private int TN_readcount;// ��ȸ��
	
	public int getTN_num() {
		return TN_num;
	}
	public void setTN_num(int TN_num) {
		this.TN_num = TN_num;
	}
	public String getTN_title() {
		return TN_title;
	}
	public void setTN_title(String TN_title) {
		TN_title=convert(TN_title);
		this.TN_title = TN_title;
	}
	public String getTN_id() {
		return TN_id;
	}
	public void setTN_id(String TN_id) {
		this.TN_id = TN_id;
	}
	public String getTN_date() {
		return TN_date;
	}
	public void setTN_date(String TN_date) {
		this.TN_date = TN_date;
	}
	public String getTN_content() {
		return TN_content;
	}
	public void setTN_content(String TN_content) {
		TN_content=convert(TN_content);
		this.TN_content = TN_content;
	}
	public int getTN_readcount() {
		return TN_readcount;
	}
	public void setTN_readcount(int TN_readcount) {
		this.TN_readcount = TN_readcount;
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
