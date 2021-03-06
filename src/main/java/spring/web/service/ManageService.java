package spring.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.web.dto.CertificationDTO;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;

public interface ManageService {

	/**
	 * 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기)
	 * 리스트로
	 * */
	public List<ProductDTO> selectAllProduct();
	
	/**
	 * 개별상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	public int productRegisterManage(ProductDTO productDTO);
	public int productNoFind(String name);
	
	/**
	 * 유기농 인증 종류들 불러오기
	 * @return
	 */
	public List<CertificationDTO> selectCertification();
	/**
	 * 유기농 인증 번호 등록하기
	 */
	public int productCertiRegisterManage(ProductCertificationDTO productCertificationDTO);
	
	/**
	 * 개별상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	 
	public ProductDTO productInfoMangage(String productno);
	*/
	
	/**
	 * 개별상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	public int productModifyManage(ProductDTO productDTO);

	/**
	 * 상품 수정을 위해 해당 상품에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public ProductDTO productInfoMangage(int no);

	/**
	 * 개별상품관리 삭제
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	public int productDeleteManage(int no);
	
	/**
	 * 세트상품관리 클릭했을 때
	 * package DTO 리스트
	 * @return 
	 * */
	public List<PackageDTO> packageManage();
	/**
	 * 세트상품 상세정보
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	public List<String> packageShowManage(int packagePk);
	
	/**
	 * 해당 패키지 상품 상세보기
	 * */
	public Map<String, Object> packageModifyShowManage(int no);
	
	
	/**패키지 추가*/
	public int packageRegisterManage(PackageDTO packageDTO, List<Integer> list);
	
	
	/**
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	public List<ProductDTO> packageSearchProduct(String productname);
		
	/**
	 * 세트상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	public int packageModifyManage(ProductDTO product, String products);
	
	/**
	 * 세트상품관리 삭제
	 * 수정폼을 div로 띄워줌
	 * */
	public int packageDeleteManage(String name);
	
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * */
	public Map<String, Object> selectAllProducer();
	/**
	 * 생산자 등록
	 * */
	public int producerRegisterManage(ProducerDTO producerDTO);

	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public ProducerDTO producerInfoMangage(int producerno);
	
	/**
	 * 생산자 수정
	 * */
	public int producerModifyManage(ProducerDTO producerDTO);
	
	/**
	 * 생산자 삭제
	 * */
	int producerDeleteManage(int no);
	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * */
	public List<MemberDTO> selectAllMember();
	/**
	 * 회원관리(삭제)
	 * */
	public int memberDeleteManage(String email);
	
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * @return 
	 * */
	public List<CommunityDTO> communityManage();
	
	/**
	 * 모임관리(등록)
	 * */
	public int communityRegisterManage(CommunityDTO communityDTO);
	
	/**
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public CommunityDTO communityShowMangage(int communityno);
	
	/**
	 * 모임관리(수정)
	 * @return 
	 * */
	public int communityModifyManage(CommunityDTO communityDTO);
	
	/**
	 * 모임관리(삭제)
	 * @return 
	 * */
	public int communityDeleteManage(String communityno);
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	public List<QnaDTO> qnaManage();
	
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	public int qnaRegisterManage(QnaDTO qnaDTO);
	
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 
	public QnaDTO qnaInfoMangage(String qnano);*/
	/**
	 * Q&A 답변 수정
	 * */
	public int qnaModifyManage(QnaDTO qnaDTO);
	/**
	 * Q&A 질문 삭제
	 * */
	public int qnaDeleteManage(int no);
	
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * @return 
	 * */
	public List<DonationOrgDTO> donationOrgManage();
	/**
	 * 기부업체 관리(등록)
	 * @return 
	 * */
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public DonationOrgDTO donationOrgShowMangage();
	
	
	/**
	 * 기부업체 관리(수정)
	 * @return 
	 * */
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO);
	
	
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * @return 
	 * */
	public int donationOrgDeleteManage(int no);

	/**
	 * 월별 매출 가져오기
	 * */
	List<Integer> getMonthSales();
	
	/**
	 * 판매상품 비중 가져오기
	 * */
	List<HashMap<String, String>> getSalesProduct();

	/**
	 * 주문관리
	 * */
	Map<String, List<PurchaseDTO>> getPurchaseOrder();
	
	/**
	 * 주문관리
	 * 입금확인된 구매내역의 상태를 결제완료로 변경
	 * */
	int depositCompleteModify(int purchaseNo);
	
	/**
	 * 주문관리
	 * 환불/반품/교환 신청된 구매내역의 상태를 완료로 변경
	 * */
	int etcCompleteModify(int purchaseNo);
}
