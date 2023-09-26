package org.iclass.mvc.controller;

import org.iclass.mvc.dto.BookUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping("/test")
	public void test(@SessionAttribute("user") BookUser user) {
		log.info("user test : {}",user);
	}
}
