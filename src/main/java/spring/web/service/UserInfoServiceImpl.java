package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserInfoDAO;
import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDao;
	
	
	/**
	 * ȸ������
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		
		return userInfoDao.registerMember(memberDto);
	}
	
	/**
	 * ����ã��(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		
		return userInfoDao.searchId(memeberDto);
	}
	
	/**
	 * ����ã��(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		
		return userInfoDao.searchPwdSendCode(email);
	}
	
	/**
	 * ����ã��(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		
		return userInfoDao.searchPwd(code);
	}
	
	/**
	 * �α����ϱ�
	 * */
	@Override
	public MemberDTO login(String email, String pwd) {
		
		return userInfoDao.login(email, pwd);
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * */
	@Override
	public boolean checkId(String email) {
		
		return userInfoDao.checkId(email);
	}
	
	/**
	 * ���������� �̵��� -> ȸ�� ���ϸ��� �� ������������ �ŷ����� ��������
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		
		return userInfoDao.myPageLoading(email);
	}
	
	/**
	 * ȸ�� ���� �������� �̵��� �� �ʿ��� ������
	 * (�����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, �������(������ �� ��ݾ�,�̹��� �� ��ݾ�))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		
		return userInfoDao.userMainLoading();
	}
	
	/**
	 * MyPage�� ���γ����� �������
	 * �ٷ� �ֹ�/�����ȸ�� �̷�����鼭
	 * ȸ���� 3������ �ֹ���ȸ ������ purchase���̺�����
	 * �����ͼ� view�� �ѷ���
	 * */
	@Override
	public List<ProductDTO> myPageOrderList(String email) {
		
		return userInfoDao.myPageOrderList(email);
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * �ش� ��� ����
	 * */
	@Override
	public int deleteOrderProduct(String email) {
		
		return userInfoDao.deleteOrderProduct(email);
	}
	
	/**
	 * �ش� ȸ���� �ش��ϴ� qna ���� ��������
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		
		return userInfoDao.myPageQna(email);
	}
	
	/**
	 * �ش� �����ۿ� �޸� ��� ��������
	 * */
	@Override
	public String showAnswer(QnaDTO qnaDto) {
		
		return userInfoDao.showAnswer(qnaDto);
	}
	
	/**
	 * ������ - ��������� ������ ��
	 * */
	@Override
	public List<DonationDTO> myPageDonation(String email) {
		
		return userInfoDao.myPageDonation(email);
	}
	
	/**
	 * ������ - ������������
	 * */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return userInfoDao.myPageInfoModify(email);
	}
	
	/**
	 * ������ - ���ϸ��� ������ ��
	 * */
	public Map<String,Object> myPageMileage(String email) {
		
		return userInfoDao.myPageMileage(email);
	}
	
	/**
	 * ������ - ��ٱ��� �ε�
	 * */
	 @Override
	public Map<String, Object> myCart(String email) {
		
		return userInfoDao.myCart(email);
	}
	 
	 /**
	  * ������ - ��ٱ��� -> �ֹ��ϱ� ��ư�� ������ ��
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return userInfoDao.myCartOrder(email);
	}
	 /**
	  * ������  - ��ٱ��� -> ��ٱ��� ���� ��ǰ ����
	  * */
	 @Override
	public int myCartDelete(int no) {
		
		return userInfoDao.myCartDelete(no);
	}
	 
	 
	
}