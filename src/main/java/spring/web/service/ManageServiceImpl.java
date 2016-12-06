package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import spring.web.dao.ManageDao;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public class ManageServiceImpl implements ManageService {

	@Autowired
	private ManageDao manageDao;
	/** 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기) 리스트로
	 * */
	@Override
	public List<ProductDTO> selectAllProduct() {
		return manageDao.selectAllProduct();
	}

	/**
	 * 개별상품관리 등록(등록폼을 div로 띄워줌)
	 * */
	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return manageDao.productRegisterManage(productDTO);
	}

	/**
	 * 개별상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 해당하는 제품의 정보를 select한다.
	 * */
	@Override
	public ProductDTO productInfoMangage(String productno) {
		return manageDao.productInfoMangage(productno);
	}

	/**
	 * 개별상품관리 수정 정폼을 div로 띄워줌
	 * */
	@Override
	public int productModifyManage(String productno) {
		return manageDao.productModifyManage(productno);
	}

	/**
	 * 개별상품관리 삭제  - 수정폼을 div로 띄워줌 (alert)
	 * */
	@Override
	public int productDeleteManage(String productno) {
		return manageDao.productDeleteManage(productno);
	}
	/**
	 * 세트상품관리 클릭했을 때  package DTO 리스트
	 * */
	@Override
	public List<PackageDTO> packageManage() {
		return manageDao.packageManage();
	}
	
	/**
	 * 세트상품 상세정보
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	@Override
	public List<ProductDTO> packageShowManage(String packagename) {
		return manageDao.packageShowManage(packagename);
	}

	/**
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	@Override
	public List<ProductDTO> packageSearchProduct(String productname) {
		return manageDao.packageSearchProduct(productname);
	}
	/**
	 * 세트상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	 */
	@Override
	public ProductDTO packageInfoMangage(String productno) {
		return manageDao.packageInfoMangage(productno);
	}

	/**
	 * 세트상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		return manageDao.packageModifyManage(modifyinfo);
	}

	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * */
	@Override
	public List<ProductDTO> selectAllProducer() {
		return manageDao.selectAllProducer();
	}

	/**
	 * 생산자 등록
	 * */
	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return manageDao.producerRegisterManage(producerDTO);
	}

	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public ProducerDTO producerInfoMangage(String producerno) {
		return manageDao.producerInfoMangage(producerno);
	}

	/**
	 * 생산자 수정
	 * */
	@Override
	public int producerModifyManage(String producerno) {
		return manageDao.producerModifyManage(producerno);
	}

	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * */
	@Override
	public List<ProductDTO> selectAllMember() {
		return manageDao.selectAllMember();
	}
	/**
	 * 회원관리(삭제)
	 * */
	@Override
	public int memberDeleteManage(String email) {
		return manageDao.memberDeleteManage(email);
	}
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * */
	@Override
	public List<CommunityDTO> communityManage() {
		return manageDao.communityManage();
	}

	/**
	 * 모임관리(등록)
	 * */
	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return manageDao.communityRegisterManage(communityDTO);
	}
	/**
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public CommunityDTO communityInfoMangage(String communityno) {
		return manageDao.communityInfoMangage(communityno);
	}
	/**
	 * 모임관리(수정)
	 * */
	@Override
	public int communityModifyManage(String communityno) {
		return manageDao.communityModifyManage(communityno);
	}
	/**
	 * 모임관리(삭제)
	 * @return 
	 * */
	@Override
	public int communityDeleteManage(String communityno) {
		return manageDao.communityDeleteManage(communityno);
	}
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	@Override
	public List<QnaDTO> qnaManage() {
		return manageDao.qnaManage();
	}
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return manageDao.qnaRegisterManage(communitycommentDTO);
	}
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public QnaDTO qnaInfoMangage(String qnano) {
		return manageDao.qnaInfoMangage(qnano);
	}
	/**
	 * Q&A 답변 수정
	 * */
	@Override
	public int qnaModifyManage(String communitycommentno) {
		return manageDao.qnaModifyManage(communitycommentno);
	}
	/**
	 * Q&A 질문 삭제
	 * */
	@Override
	public int qnaDeleteManage(String communitycommentno) {
		return manageDao.qnaDeleteManage(communitycommentno);
	}
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * */
	@Override
	public List<DonationDTO> donationOrgManage() {
		return manageDao.donationOrgManage();
	}
	/**
	 * 기부업체 관리(등록)
	 **/
	@Override
	public int donationOrgRegisterManage(DonationDTO donationDTO) {
		return manageDao.donationOrgRegisterManage(donationDTO);
	}
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public DonationDTO donationOrgInfoMangage(String donationOrgno) {
		return manageDao.donationOrgInfoMangage(donationOrgno);
	}
	/**
	 * 기부업체 관리(수정)
	 * */
	@Override
	public int donationOrgModifyManage(DonationDTO donationDTO) {
		return manageDao.donationOrgModifyManage(donationDTO);
	}
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * */
	@Override
	public int donationOrgDeleteManage(String donationOrgNo) {
		return manageDao.donationOrgDeleteManage(donationOrgNo);
	}

}
