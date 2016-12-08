package spring.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.ManageService;

@Controller
@RequestMapping("/manageController")
public class ManageController {

	@Autowired
	ManageService manageService;
	/**
	 * 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기)
	 * 리스트로
	 * */
	@RequestMapping("productManage")
	public ModelAndView productManage() {
		/**
		 * 1. 개별 상품 관리를 누르면
		 * 2. proudctDTO에 있는 정보를 다 받아와서 (productlist)
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 * 
		 */
		List<ProductDTO> productlist = manageService.selectAllProduct();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", productlist);
		
		mv.setViewName("productManage");  
		return mv;
	}
	
	/**
	 * 개별상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("productRegisterManage")
	public String productRegisterManage(HttpServletRequest request, ProductDTO productDTO ) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 productDTO 정보를 모두 받아, 
		 * 3. product테이블에 추가한다(register)
		 */
		int result = manageService.productRegisterManage(productDTO);
		if(result==0){
			request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:productManage";
	}
	
	/** div에 정보를 불러와서 ...
	 * 개별상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	 
	@RequestMapping("productInfoMangage")
	public ProductDTO productInfoMangage(String no){
		ProductDTO product = manageService.productInfoMangage(no);
		
		return product;
	}*/
	
	
	/**
	 * 개별상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	@RequestMapping("productModifyManage")
	public String productModifyManage(HttpServletRequest request, ProductDTO productDTO) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		int result = manageService.productModifyManage(productDTO);
		if(result==0){
			request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * 개별상품관리 삭제
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("productDeleteManage")
	public String productDeleteManage(HttpServletRequest request, int no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.productDeleteManage(no);
		if(result==0){
			request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:productManage";
	}
	
	/**
	 * 세트상품관리 클릭했을 때
	 * package DTO 리스트
	 * */
	@RequestMapping("packageManage")
	public ModelAndView packageManage() {
		/**
		 * 1. 세트 상품 관리를 누르면
		 * 2. packageDTO에 있는 정보를 다 받아와서 (packagelist) 
		 * * 정보 관련 :  package테이블의 package_name, 세트 가격은 product에 있는 price, 포함상품은package_product에 있는 product_no를 다 찾는다.
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 * 
		 */
		List<PackageDTO> packagelist = manageService.packageManage();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packagelist", packagelist);
		
		mv.setViewName("packageManage");  
		return mv;
	}
	
	/**
	 * 세트상품 상세정보 packagename을 인수로 받는다.
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	@RequestMapping("packageShowManage")
	public ModelAndView packageShowManage(String name) {
		/**
		 * 1.세프 상품 정보 list에서 package이름을 누르면 해당하는 패키지 이름을 받아온다.
		 * 2.package에 있는 package_no를 찾고 일치하는 package_product에 있는 product_no를 모두 찾는다.
		 * 3.product에 있는 product_name, price, producer_no(no를 찾아 producer테이블의 name)을 찾고, product_no에 일치하는 certification_no를 찾는다.
		 */
		
		//packagename에 일치하는 package_no를 찾고 package_product에 있는 product_no를 찾는다.
		List<ProductDTO> packageproduct = manageService.packageShowManage(name);
		//다른 건 다 조인해서 받아올수있는건가...ㅎ
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageproduct", packageproduct);
		
		mv.setViewName("packageproduct");  
		return mv;
		
	}
	
	/**
	 * 세트상품관리 등록
	 * 등록폼을 div로 띄워줌
	 * */
	@RequestMapping("packageRegisterManage")
	public String packageRegisterManage(ProductDTO productDTO, String name) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 입력할 정보 : 이름 (product테이블에 있는 package_name)
		 * 가격,사진,설명 : product테이블에 있는 price, profile, desc
		 * 상품검색 : product_name에 일치하는 product를 찾아준다
		 * 밑에 상품이 productDTO들이 insert된다.
		 */
		packageSearchProduct(name);
		int result = manageService.productRegisterManage(productDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 세트상품 등록에서 개별상품 검색(ajax)- productname을 받는다.
	 * 상품번호, 상품이름 아래에 추가
	 * */
	@RequestMapping("packageSearchProduct")
	public List<ProductDTO> packageSearchProduct(String name) {
		/**
		 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
		 */
		List<ProductDTO> list = null;
		
		list = manageService.packageSearchProduct(name);
		
		return list;
	}
	
	//div태그이므로, 할 필요 없을 것이다. 정보 저장되어 있기 떄문에
	/** div에 정보를 불러와서 ...productno를 받는다.
	 * //수정폼에서 product에 해당하는 productname에 해당하는 제품 dto에 대한 정보를 받아 오기 위해 필요한 메소드		
		ProductDTO product = manageService.selectByPackageName(productDTO)
	 * 세트상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	
	@RequestMapping("packageInfoMangage")
	public ProductDTO packageInfoMangage(String no){
		ProductDTO product = null;
		product = manageService.packageInfoMangage(no);
		
		return product;
	} */
	
	/**
	 * 세트상품관리 수정 (productname을 인수로 받음)
	 * 수정폼을 div로 띄워줌
	 * @return 
	 * */
	@RequestMapping("packageModifyManage")
	public String packageModifyManage(ProductDTO productDTO, String name) {
		
		Map<String, Object> modifyinfo = new HashMap<String, Object>();
		/**
		 * 패키지 이름을 누르고 수정을 누르면 등록폼과 같은 div가 띄어진다.
		 * 2. 입력할 정보 : 이름 (product테이블에 있는 package_name)
		 * 가격,사진,설명 : product테이블에 있는 price, profile, desc
		 * 상품검색 : product_name에 일치하는 product를 찾아준다
		 * 밑에 상품이 productDTO들이 modify된다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		
		//수정폼에서 상품 검색하기 위해서 필요한 메소드
		List<ProductDTO> searchlist = packageSearchProduct(name);
		
		modifyinfo.put("productDTO", productDTO);
		modifyinfo.put("searchlist", searchlist);
		
		int result = manageService.packageModifyManage(modifyinfo);
		
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 세트상품관리 삭제(인수 : productname)
	 * 수정폼을 div로 띄워줌 (alert)
	 * */
	@RequestMapping("packageDeleteManage")
	public String packageDeleteManage(String name) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.packageDeleteManage(name);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:packageproduct";
	}
	
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * @return 
	 * */
	@RequestMapping("producerManage")
	public ModelAndView producerManage() {
		/**
		 * 1. 생산자관리를 누르면
		 * 2. proudcerDTO에 있는 정보를 다 받아와서 (producerlist)
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 *  */
		List<ProductDTO> producerlist = manageService.selectAllProducer();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producerlist", producerlist);
		
		mv.setViewName("producerManage");  
		return mv;
	}
	
	/**
	 * 생산자 등록
	 * @return 
	 * */
	@RequestMapping("producerRegisterManage")
	public String producerRegisterManage(ProducerDTO producerDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 producerDTO 정보를 모두 받아, 
		 * 3. producer테이블에 추가한다(register)
		 */
		int result = manageService.producerRegisterManage(producerDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:producerManage";
	}
	
	
	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.producerno
	 */
	public ProducerDTO producerInfoMangage(String no){
		ProducerDTO producer = null;
		producer = manageService.producerInfoMangage(no);
		
		return producer;
	}
	/**
	 * 생산자 수정
	 * */
	@RequestMapping("producerModifyManage")
	public String producerModifyManage(ProducerDTO producerDTO) {
		/**
		 * 특정 생산자의 번호를 받아와 producerno
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 productManage 개별상품관리를 보는 쪽으로 넘어간다.
		 */

		int result = manageService.producerModifyManage(producerDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:producerManage";
	}
	
	/**
	 * 생산자 삭제
	 * (alert)
	 * */
	@RequestMapping("producerDeleteManage")
	public String producerDeleteManage(int no) {
		/**
		 * 특정 상품의 번호를 받아와  (인수 : producerno)
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * alert로 메시지 뜬다.
		 */
		int result =0;
		result = manageService.producerDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:producerManage";
	}
	
	/**
	 * 매출관리
	 * 총매출이 바로 보여짐
	 * 총매출, 총지출, 순이익
	 * */
	@RequestMapping("salesManage")
	public void salesManage() {
		
	}
	
	/**
	 * 매출관리
	 * 월별매출
	 * 차트
	 * */
	@RequestMapping("salesByMonthsManage")
	public void salesByMonthsManage() {
		
	}
	
	/**
	 * 매출관리
	 * 인기순
	 * 도넛차트
	 * */
	@RequestMapping("salesByBestManage")
	public void salesByBestManage() {
		
	}
	
	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * @return 
	 * */
	@RequestMapping("memberManage")
	public ModelAndView memberManage() {
		/**
		 * 1. 회원관리를 누르면
		 * 2. MemberDTO에 있는 정보를 다 받아와서 (memberlist)
		 * 정보 : member_email, memeber_name, member_phone, member_register_date, 
		 * select를 하는데 오름차순으로 해준다.
		 * 3.테이블 형식으로 뿌려준다. 페이징(Datatable로 페이징)?
		 *  */
		List<ProductDTO> memberlist = manageService.selectAllMember();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		
		mv.setViewName("memberManage");  
		return mv;
	}
	
	/**
	 * 회원관리(삭제)
	 * */
	@RequestMapping("memberDeleteManage")
	public String memberDeleteManage(String email) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * alert로 메시지 뜬다.
		 */
		int result =0;
		result = manageService.memberDeleteManage(email);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:memberManage";
	}
	
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * @return 
	 * */
	@RequestMapping("communityManage")
	public ModelAndView communityManage() {
		/**
		 * 1. commuity를 누르면, 
		 * 2. 총 9개를 담아서 뷰로 보내준다. community_profile사진 / commuinty_name, community_register_date를 보여준다.
		 * 3. 전체 행사를 뽑는 dao 두 개의 메소드와 (community_state 상태를 확인 한 후)
		 * 페이지 기능 메소드가 필요. 
		 */
		List<CommunityDTO> communitylist = null;
		ModelAndView mv = new ModelAndView();
		communitylist = manageService.communityManage();
		if(communitylist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("communitylist",communitylist);
		mv.setViewName("communityManage");
		return mv;
	}
	
	/**
	 * 모임관리(등록)
	 * */
	@RequestMapping("communityRegisterManage")
	public String communityRegisterManage(CommunityDTO communityDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communityDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(register)
		 */
		int result = manageService.communityRegisterManage(communityDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:communityManage";
	}
	/**
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.(comunityno)
	
	public CommunityDTO communityInfoMangage(String no){
		CommunityDTO community = null;
		community = manageService.communityInfoMangage(no);
		
		return community;
	} */
	
	/**
	 * 모임관리(수정)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityModifyManage")
	public String communityModifyManage(CommunityDTO communityDTO) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 community를 보는 쪽으로 넘어간다.
		 */
		int result = manageService.communityModifyManage(communityDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:communityManage";
	}
	
	/**
	 * 모임관리(삭제)(comunityno)
	 * @return 
	 * */
	@RequestMapping("communityDeleteManage")
	public String communityDeleteManage(String no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 community관리를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.communityDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:communityManage";
	}
	
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	@RequestMapping("qnaManage")
	public ModelAndView qnaManage() {
		/**
		 * 1. Q&A관리를 누르면, 
		 * 2. 전체 Q&A정보를 뽑는 dao 메소드/ 페이지 기능 메소드가 필요. 
		 */
		List<QnaDTO> qnalist = null;
		ModelAndView mv = new ModelAndView();
		qnalist = manageService.qnaManage();
		if(qnalist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("qnalist",qnalist);
		mv.setViewName("qnaManage");
		return mv;
	}
	
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	@RequestMapping("qnaRegisterManage")
	public String qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communitycommentDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(ajax)
		 */
		int result = manageService.qnaRegisterManage(communitycommentDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:qnaManage";
	}
	
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.(qnano)
	 
	public QnaDTO qnaInfoMangage(String no){
		QnaDTO qna = null;
		qna = manageService.qnaInfoMangage(no);
		
		return qna;
	}*/
	/**
	 * Q&A 답변 수정(communitycommentno)
	 * */
	@RequestMapping("qnaModifyManage")
	public String qnaModifyManage(QnaDTO qnaDTO) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 수정한다.
		 * 그 다음 div태그가 사라지고 다시 qna를 보는 쪽으로 넘어간다.
		 */
		int result = manageService.qnaModifyManage(qnaDTO);
		if(result==0){
			//request.setAttribute("errorMsg", "수정되지 않았습니다.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * Q&A 질문 삭제(communitycommentno)
	 * @return 
	 * */
	@RequestMapping("qnaDeleteManage")
	public String qnaDeleteManage(String no) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 qna를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.qnaDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:qnaManage";
	}
	
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * @return 
	 * */
	@RequestMapping("donationOrgManage")
	public ModelAndView donationOrgManage() {
		/**
		 * 기부 업체 관리를 클리하면, 해당하는 기부업체 DTO의 정보를 받아서 (select) 뷰에 뿌려준다.
		 */
		List<DonationDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = manageService.donationOrgManage();
		if(donationlist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("donationlist",donationlist);
		mv.setViewName("donationOrgManage");
		return mv;
	}
	
	/**
	 * 기부업체 관리(등록)
	 * @return 
	 * */
	@RequestMapping("donationOrgRegisterManage")
	public String donationOrgRegisterManage(DonationDTO donationDTO) {
		/**
		 * 1. 등록을 누르면 jsp에 있는 div가 보여진다.
		 * 2. 내용을 입력하고 등록을 입력하면, form에 있는 정보 communityDTO 정보를 모두 받아, 
		 * 3. community테이블에 추가한다(register)
		 */
		int result = manageService.donationOrgRegisterManage(donationDTO);
		if(result==0){
			//request.setAttribute("errorMsg","삽입하지 못했습니다.");
		}
		return "forward:donationOrgManage";
	}
	
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public DonationDTO donationOrgInfoMangage(String donationOrgno){
		DonationDTO donation = null;
		donation = manageService.donationOrgInfoMangage(donationOrgno);
		
		return donation;
	}
	
	/**
	 * 기부업체 관리(수정)
	 * @return 
	 * */
	@RequestMapping("donationOrgModifyManage")
	public String donationOrgModifyManage(DonationDTO donationDTO) {
		/**
		 * 특정 상품의 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 community관리를 보는 쪽으로 넘어간다.
		 */
		int result = manageService.donationOrgModifyManage(donationDTO);
			if(result==0){
				//request.setAttribute("errorMsg", "수정되지 않았습니다.");	
			}
			return "forward:donationOrgManage";
	}
	
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * @return 
	 * */
	@RequestMapping("donationOrgDeleteManage")
	public String donationOrgDeleteManage(int no) {
		/**
		 * 특정 기부업체 번호를 받아와 
		 * 그 번호에 일치하는 정보를 삭제한다.
		 * 그 다음 div태그가 사라지고 다시 donation관리를 보는 쪽으로 넘어간다.
		 */
		int result =0;
		result = manageService.donationOrgDeleteManage(no);
		if(result==0){
			//request.setAttribute("errorMsg", "삭제되지 않았습니다.");
			
		}
		return "forward:donationOrgManage";
	}
}
