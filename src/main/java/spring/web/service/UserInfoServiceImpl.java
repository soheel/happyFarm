package spring.web.service;

import java.util.List;
import java.util.Map;

import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public class UserInfoServiceImpl implements UserInfoService {

	/**
	 * 회원가입
	 * */
	@Override
	public int registerMember(MemberDTO memberDto) {
		return 0;
	}
	
	/**
	 * 계정찾기(id)
	 * */
	@Override
	public String searchId(MemberDTO memeberDto) {
		return null;
	}
	
	/**
	 * 계정찾기(pwd-sendcode) 
	 * */
	@Override
	public String searchPwdSendCode(String email) {
		return null;
	}
	
	/**
	 * 계정찾기(pwd)
	 * */
	@Override
	public String searchPwd(String code) {
		return null;
	}
	
	/**
	 * 로그인하기
	 * */
	@Override
	public MemberDTO login(String email, String pwd) {
		return null;
	}
	
	/**
	 * 아이디 중복확인
	 * */
	@Override
	public boolean checkId(String email) {
		return false;
	}
	
	/**
	 * 마이페이지 이동시 -> 회원 마일리지 및 현재진행중인 거래내역 가져오기
	 * */
	@Override
	public Map<String, Integer> myPageLoading(String email) {
		return null;
	}
	
	/**
	 * 회원 메인 페이지로 이동할 때 필요한 정보들
	 * (생산자에 대한 정보 , 인기 상품 3개에 대한 정보, 기부정보(저번달 총 모금액,이번달 총 모금액))
	 * */
	@Override
	public Map<String, Object> userMainLoading() {
		return null;
	}
	
	/**
	 * MyPage의 쇼핑내역을 누를경우
	 * 바로 주문/배송조회가 이루어지면서
	 * 회원의 3개월간 주문조회 내역을 purchase테이블에서
	 * 가져와서 view에 뿌려줌
	 * */
	@Override
	public List<ProductDTO> myPageOrderList(String email) {
		return null;
	}
	
	/**
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 해당 목록 삭제
	 * */
	@Override
	public int deleteOrderProduct(String email) {
		
		return 0;
	}
	
	/**
	 * 해당 회원에 해당하는 qna 정보 가져오기
	 * */
	@Override
	public List<QnaDTO> myPageQna(String email) {
		
		return null;
	}
	
	/**
	 * 해당 질문글에 달린 답글 가져오기
	 * */
	@Override
	public String showAnswer(QnaDTO qnaDto) {
		
		return null;
	}
	
	/**
	 * 내정보 - 기부페이지 눌렀을 때
	 * */
	@Override
	public List<DonationDTO> myPageDonation(String email) {
		
		return null;
	}
	
	/**
	 * 내정보 - 개인정보관리
	 * */
	@Override
	public MemberDTO myPageInfoModify(String email) {
		
		return null;
	}
	
	/**
	 * 내정보 - 장바구니 로딩
	 * */
	 @Override
	public List<ProductDTO> myCart(String email) {
		
		return null;
	}
	 
	 /**
	  * 내정보 - 장바구니 -> 주문하기 버튼을 눌렀을 때
	  * */
	 @Override
	public List<ProductDTO> myCartOrder(String email) {
		
		return null;
	}
	
}
