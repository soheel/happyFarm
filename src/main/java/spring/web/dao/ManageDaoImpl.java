package spring.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Repository
public class ManageDaoImpl implements ManageDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<ProductDTO> selectAllProduct() {
		List<ProductDTO> list = sqlsession.selectList("manageMapper.selectAll");
		return list;
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return sqlsession.insert("manageMapper.productRegisterManage",productDTO);
		
	}

	@Override
	public int productModifyManage(ProductDTO productDTO) {
		return sqlsession.update("manageMapper.productModifyManage",productDTO);
	}

	@Override
	public int productDeleteManage(int no) {
		return sqlsession.delete("manageMapper.productDeleteManage",no);
	}

	@Override
	public List<PackageDTO> packageManage() {
		return sqlsession.selectList("manageMapper.packageManage");
	}

	@Override
	public List<ProductDTO> packageShowManage(String name) {
		return sqlsession.selectList("manageMapper.packageShowManage",name);
		
	}

	@Override
	public int packageRegisterManage(Map<String, Object> packageRegister) {
		
		int result1=sqlsession.insert("manageMapper.packageRegisterManage",packageRegister);
		int result2=sqlsession.insert("manageMapper.packageRegisterPackage",packageRegister);
		int result3=sqlsession.insert("manageMapper.packageRegisterPackageProduct",packageRegister);
		
		return result3;
	}
	
	
	@Override
	public ProductDTO packageSearchProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO packageInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int packageDeleteManage(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProducerDTO> selectAllProducer() {
		return sqlsession.selectList("manageMapper.selectAllProducer");
	}

	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		System.out.println("けけけけけけけけけけけけけけけけけけけけけけけ");
		return sqlsession.insert("manageMapper.producerRegisterManage",producerDTO);
	}

	@Override
	public ProducerDTO producerInfoMangage(int no) {
		ProducerDTO producer = sqlsession.selectOne("UserProductMapper.getProducerByProducerNo", no);
		return producer;
	}

	@Override
	public int producerModifyManage(ProducerDTO producerDTO) {
		return sqlsession.update("manageMapper.producerModifyManage",producerDTO);
	}

	@Override
	public int producerDeleteManage(int no) {
		return sqlsession.delete("manageMapper.producerDeleteManage",no);
	}
	
	@Override
	public List<MemberDTO> selectAllMember() {
		return sqlsession.selectList("manageMapper.selectAllMember");
	}

	@Override
	public int memberDeleteManage(String email) {
		return sqlsession.delete("manageMapper.memberDeleteManage",email);
	}

	@Override
	public List<CommunityDTO> communityManage() {
		return sqlsession.selectList("manageMapper.communityManage");
	}

	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return sqlsession.insert("manageMapper.communityRegisterManage");
	}

	@Override
	public CommunityDTO communityInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int communityModifyManage(CommunityDTO communityDTO) {
		return sqlsession.update("manageMapper.communityModifyManage",communityDTO);
	}

	@Override
	public int communityDeleteManage(String no) {
		return sqlsession.delete("manageMapper.communityDeleteManage",no);
	}

	@Override
	public List<QnaDTO> qnaManage() {
		return sqlsession.selectList("manageMapper.qnaManage");
	}

	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return sqlsession.insert("manageMapper.qnaRegisterManage",communitycommentDTO);
	}

	/*@Override
	public QnaDTO qnaInfoMangage(String no) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public int qnaModifyManage(QnaDTO qnaDTO) {
		return sqlsession.update("manageMapper.qnaModifyManage",qnaDTO);
	}

	@Override
	public int qnaDeleteManage(String no) {
		return sqlsession.update("manageMapper.qnaDeleteManage",no);
	}

	@Override
	public List<DonationOrgDTO> donationOrgManage() {
		return sqlsession.selectList("manageMapper.donationOrgManage");
	}

	@Override
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO) {
		return sqlsession.insert("manageMapper.donationOrgRegisterManage",donationOrgDTO);
	}

	@Override
	public DonationDTO donationOrgInfoMangage(String donationOrgno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO) {
		return sqlsession.update("manageMapper.donationOrgModifyManage",donationOrgDTO);
	}

	@Override
	public int donationOrgDeleteManage(int no) {
		return sqlsession.delete("manageMapper.donationOrgDeleteManage",no);
	}

	@Override
	public float getProducerEval(int producerNo) {
		return sqlsession.selectOne("manageMapper.getProducerEval", producerNo);
	}

	@Override
	public ProductDTO productInfoMangage(int no) {
		return sqlsession.selectOne("UserProductMapper.getProductByProductNo", no);
	}
}
