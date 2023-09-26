package org.iclass.mvc.controller;

import java.util.Map;

import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@SessionAttributes(names = {"user","cart","tno"})
@RequestMapping("/member")
public class JoinController {
	private final BookUserService service;

	@GetMapping("/join")    
	public void join() {
	}
	
	@PostMapping("/join")
	public String joinac(BookUser dto) {
		service.join(dto);
		return "redirect:/";
	}
//	@GetMapping("/join")    
//	public String login() {
//		return "redirect:/";
//	}
}
