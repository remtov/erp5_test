package com.ict.member.Controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ict.member.service.MemberService;
import com.ict.member.service.SignUpService;
import com.ict.member.vo.MemberVO;
import com.ict.member.vo.SignUp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public SignUpService sus;
	@Inject
	private MemberService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model m, @ModelAttribute SignUp su)throws Exception {
		logger.info("home", locale);
		List<MemberVO> memberList = service.selectMember();
		m.addAttribute("ko_kim_signupList", sus.selectSignUpList(su));
		m.addAttribute("memberList", memberList);
		return "home";

	}

	


}