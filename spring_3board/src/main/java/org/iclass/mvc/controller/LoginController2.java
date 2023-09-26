package org.iclass.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
//@SessionAttributes(names = {"user"})
public class LoginController2 {
	private final BookUserService service;

	@GetMapping("/login")    
	public void login() {
	}
	
	@PostMapping("/login")  //POST 요청일때 @PostMapping
	public String loginProc(@RequestParam Map<String,String> param,
			RedirectAttributes reattr,
			Model model,
			HttpSession session ){
		
		String url="/";		//계정정보가 일치할때 context path(index)로 이동
		BookUser member = service.login(param);
		if(member==null) {	
			reattr.addFlashAttribute("incorrect","y");
			url="login";   //계정 정보가 틀릴때 다시 로그인으로 이동
		}else {
			session.setAttribute("user",member);
		}
		return "redirect:"+url;		
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
