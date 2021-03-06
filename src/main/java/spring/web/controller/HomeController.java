package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.service.UserEtcService;
import spring.web.service.UserInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserInfoService userService;
	
	@RequestMapping("/")
	public ModelAndView home(HttpSession session) {
		System.out.println("home");
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = userService.userMainLoading();
		mv.setViewName("main/index");
		List<ProductDTO> list = (List<ProductDTO>)map.get("bestProduct");
		List<ProducerDTO> list2 = (List<ProducerDTO>)map.get("bestProducer");
		int price = (Integer)map.get("previousMonthDonationPrice");
		List<InfomationDTO> infoList = (List<InfomationDTO>)map.get("infoList");
		mv.addObject("bestProduct", list);
		mv.addObject("bestProducer", list2);
		mv.addObject("infoList",infoList);
		session.setAttribute("donationPrice", price);
		return mv;
	}
}
