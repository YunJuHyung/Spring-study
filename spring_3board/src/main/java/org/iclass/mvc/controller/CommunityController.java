package org.iclass.mvc.controller;

import java.time.LocalDate;

import org.iclass.mvc.dto.Community;
import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")	// url이 Community 로 시작하면 DispatcherServlet 으로부터 CommunityController가 위임받아 처리합니다.
@Slf4j
public class CommunityController {

	private final CommunityService service;
	
	private CommunityController(CommunityService service) {
		this.service=service;
	}
	
	//여기서부터는 요청을 처리하는 핸들러 메소드입니다.
	//URL 설계 : 글 목록 조회는 /community/list, 글쓰기 /community/write, /community/read
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "1")	//파라미터 값이 없으면 오류. 기본값 설정
			int page, Model model) { //메소드 인자 int page는 url의 파라미터
		//Model : view 로 전달될 데이터를 주로 저장합니다.
		// addAttribute 메소드 : request.setAttribute 와 동일.(session 도 Model 사용 가능. 로그인에서합니다.)
		model.addAttribute("list", service.pagelist(page).get("list"));
		model.addAttribute("paging", service.pagelist(page).get("paging"));
		model.addAttribute("today", LocalDate.now());
		model.addAttribute("page",service.read(page).get(""));
	}
	
	
	@GetMapping("/read")
	public void read(long idx,
			@ModelAttribute("page")	//파라미터로 받은 값을 model.addAttribute 와 같이 저장합니다.
			int page,Model model) {
		model.addAttribute("vo", service.read(idx));
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/write")
	public String save(Community dto) {	//파라미터가 많을때, 그것들을 필드로 갖는 dto 또는 map
		log.info("dto : {}", dto);
		service.insert(dto);
		
		return "redirect:/community/list";
	}
	// location.href = 'list.jsp' 는 자바스크립트 - 클라이언트 브라우저에서 주소 변경
	// response.sendRedirect("list.jsp") 는 서버에서 클라이언트에게 새로 보낼 요청을 강제로
	//		ㄴ POST 요청을 처리한 후에는 redirect 를 합니다.
	@PostMapping("/updateAction")
	public String updateAc(@ModelAttribute("page") int page, Community dto) {
		service.update(dto);
		return "redirect:/community/list";
	}
	
	@PostMapping("/update")
	public void update(@ModelAttribute("page")int page,Model model long dto) {
		model.addAttributes("vo", service.selectByIdx(dto));
	}
	
	
}
