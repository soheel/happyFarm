package spring.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

public class UserEtcDaoImpl implements UserEtcDao {

	
	@Override
	public List<CommunityDTO> communityLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommunityDTO communityDetail(String communityNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerQnA(QnaDTO qnaDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QnaDTO> qnaLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InfomationDTO> infoLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfomationDTO infoDetail(String qnano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DonationDTO> donationLoading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducerDTO producerDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityDTO> communityIngList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityCommentDTO> commmentList(String communityNo) {
		// TODO Auto-generated method stub
		return null;
	}

}