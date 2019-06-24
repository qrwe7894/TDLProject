package com.tdlNotice.dao;

	import java.util.List;
	import java.util.Map;

	import org.mybatis.spring.support.SqlSessionDaoSupport;
	import org.springframework.stereotype.Repository;

	import com.tdlNotice.domain.noticeCommand;


	@Repository
	public class TDLNoticeDAOImpl  extends SqlSessionDaoSupport implements TDLNoticeDAO {

	//�������� ����Ʈ ��
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
				System.out.println("getRowCount()ȣ���!");
				return getSqlSession().selectOne("selectCountN",map);
	}
	//�������� �Խù�����Ʈ ����Ʈ�� �޾ƿ���
	public List<noticeCommand> list(Map<String, Object> map) {
				List<noticeCommand> list=getSqlSession().selectList("selectListN",map);
				System.out.println("TDL_NOTICE -> ListDaoImpl �׽�Ʈ���Դϴ�.~");
				return list;
		}
	
	//�������� �ѹ� �ִ밪 ���ϱ� => �ִ밪+1 => ���ο� �Խù���ȣ
	public int getNewNumN() {
		int newnumN=(Integer)getSqlSession().selectOne("getNewNumN");
		System.out.println("getNewNumN()�� newnumN=>"+newnumN);
		return newnumN;
		}
	
	//�۾���
	public void insert(noticeCommand TDLNotice) {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertTDLNotice",TDLNotice);
		}
	
	//��ȸ�� ����
	public void updateHitN(Integer TN_num) {
			// TODO Auto-generated method stub
		getSqlSession().update("updateHitN",TN_num);
		}
	
	//�� �󼼺���
	public noticeCommand selectTDLNotice(Integer TN_num) {
			
		return (noticeCommand)getSqlSession().selectOne("selectTDLNotice",TN_num);
		}
	//�ۻ���
	public void delete(Integer TN_num) {
			// TODO Auto-generated method stub
		getSqlSession().delete("deleteN",TN_num);
		}

	public void update(noticeCommand TDLNotice) {
			// TODO Auto-generated method stub
		getSqlSession().update("updatePostN",TDLNotice);
		}
}
