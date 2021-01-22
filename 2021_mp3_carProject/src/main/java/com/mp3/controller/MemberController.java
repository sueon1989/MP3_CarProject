package com.mp3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	// 스프링의 빈으로 인식
@Log4j		
@RequestMapping("/member/*")	// /member로 시작하는 모든 처리를 MemberController가 처리하도록 지정
@AllArgsConstructor			// MemberController는 MemberService에 의존적: 생성자를 만들고 자동으로 주입하도록 함
public class MemberController {

	private MemberService service;	
	
	BCryptPasswordEncoder pwencoder;
	
	// 준택 테스트
	@GetMapping("/findIdInput")
	public String findIdInput() {
		return "/common/auth/findIdInput";
		
	}
	@GetMapping("/findPassInput")
	public String findPassInput() {
		return "/common/auth/findPassInput";
	}
	
//	http://localhost:8080/Member/list
//		* Console에서 로그를 확인하기 위해 
//		## log4j.xml에서 warn -> info로 변경
//			37줄: <priority value="info" />	<!-- 기존: warn -->
	// 목록(리스트)
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("리스트");
//		model.addAttribute("list", service.getList());
////		model.addAttribute(service.getList());	// 이름 생략해도 리턴타입 list로 보내짐
//	}	
	
	// 목록(리스트)
	// http://localhost:8080/member/list
	@GetMapping("/list")
	public String list(/* Criteria cri, */Model model) {
		
		log.info("리스트");
		model.addAttribute("list", service.getList());
//		model.addAttribute("list", service.getList(cri));
//		model.addAttribute(service.getList());	// 이름 생략해도 리턴타입 list로 보내짐
		return "/manager/member/memberList";
	}	
	
	
	// @GetMapping("/list")
	// public void list(Criteria cri, Model model) {
	//
	// log.info("list: " + cri);
	// model.addAttribute("list", service.getList(cri));
	//
	// }

//	@GetMapping("/list")
//	public void list(Criteria cri, Model model) {
//
//		log.info("list: " + cri);
//		model.addAttribute("list", service.getList(cri));
//		// model.addAttribute("pageMaker", new PageDTO(cri, 123));
//
//		int total = service.getTotal(cri);
//
//		log.info("total: " + total);
//
//		model.addAttribute("pageMaker", new PageDTO(cri, total));
//
//	}

	// p238
	// 등록화면: Get방식으로 입력 페이지를 볼 수 있도록
	// http://localhost:8080/member/register
	@GetMapping("/register")
//	@PreAuthorize("isAnonymous()")		// 익명의 사용자 (로그인하지 않은 경우도 해당)
//	@PreAuthorize("isAuthenticated()")	// 인증된 사용자 (로그인한 경우)
//	@PreAuthorize("isFullyAnonymous()")	// 인증된 사용자 (Rememver-me로 인증된 경우, 해당 안됨)
	public String register() {
		log.info("회원가입 입력화면 호출");
		return "/common/member/memberReg";
	}
	

	@GetMapping("/register1")
	public String register1() {
		log.info("회원가입 입력화면 호출1");
		return "/common/member/memberReg2";
	}

	// 등록2 (교재방법)
	@PostMapping("/register")
//	@GetMapping("/registerFi")
//	@PreAuthorize("isAnonymous()")		// 익명의 사용자 (로그인하지 않은 경우도 해당)
	public String registerPost(MemberVO member, AuthVO auth, RedirectAttributes rttr) {
		log.info("registerPost 회원가입 처리 시작");
		log.info("회원 등록: " + member);
		log.info("권한 등록: " + member);

		// 아이디 중복체크
		boolean checkId = service.checkId(member);

		// 등록 작업
		if (checkId == true) {	
			// 중복ID가 존재하면 -> 다시 회원가입 페이지로 돌아가기
			return "/member/memberReg";
		} else {	
			// 중복ID가 존재하지 않으면 -> 회원가입 수행
			log.info("비밀번호 처리전......"+member.getMember_pass());
			member.setMember_pass( pwencoder.encode(member.getMember_pass()) );
			log.info("비밀번호 암호화......"+member.getMember_pass());	
			service.register(member, auth);

			// 새롭게 등록된 회원정보를 같이 전달
			rttr.addFlashAttribute("member", member);
			rttr.addFlashAttribute("status", "register_success");	// RedirectAttributes에 추가

			log.info("회원가입 처리 종료");

			// 리타이렉트 방식으로 회원가입 완료화면 호출 
			return "redirect:/member/memberRegFinished";
		}
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@PostMapping("/checkId")
	public boolean checkId(MemberVO member) throws Exception {
		boolean checkId = service.checkId(member);
		return checkId;
	}
	
	@GetMapping("/memberRegFinished")
	public String register2() {
		return "/common/member/memberRegFinished";
	}

	// 등록1 (기존방법) - model 사용
//	@PostMapping("/register")
//	public String register(MemberVO Member, Model model) {
//
//		// 등록 작업
//		log.info("등록: " + Member);
//		service.register(Member);
//
//		// 새롭게 등록된 게시물의 번호를 같이 전달
//		model.addAttribute("result", Member.getmember_no());
//		// 나중에 한번만 보낼 수 있도록 변경하자!!!
//
//		// 리타이렉트 방식으로 목록화면 Member/list 호출 
//		return "redirect:/Member/list";
//	}

	// 조회 (한 행) 또는 수정
	// get으로 member_no 받아서 전달하기
	// http://localhost:8082/member/get?member_id=admin95
	@GetMapping({ "/get", "/modify" })	// @GetMapping, @PostMapping: URL을 배열로 처리 가능
	@PreAuthorize("isAuthenticated()")
	public String get(/* @RequestParam("member_id") */ String member_id, Model model) {
	
		log.info("조회: /get  또는  수정: /modify"+member_id);
		
		// 화면 쪽으로 해당 번호의 게시물을 전달
		model.addAttribute("Member", service.get(member_id));
//		model.addAttribute(service.get(member_no));	// 이름 생략하면 리턴타입 MemberVO로 보내짐
		return "/manager/member/memberDetailVeiw";
	}

//	@GetMapping({ "/get", "/modify" })
//	public void get(@RequestParam("member_no") Long member_no, Model model) {
//	
//		log.info("/get or modify ");
//		model.addAttribute("Member", service.get(member_no));
//	}

//	@GetMapping({ "/get", "/modify" })
//	public void get(@RequestParam("member_no") Long member_no, @ModelAttribute("cri") Criteria cri, Model model) {
//
//		log.info("/get or modify");
//		model.addAttribute("Member", service.get(member_no));
//	}
//
	// 수정
	@PostMapping("/modify")
	public String modify(MemberVO Member, RedirectAttributes rttr) {
		
		log.info("수정:" + Member);
		
		if (service.modify(Member)) {						// 글 수정에 성공한 경우에만
			rttr.addFlashAttribute("result", Member.getMember_no());	// RedirectAttributes에 추가
			rttr.addFlashAttribute("status", "modify_success");	// RedirectAttributes에 추가
		}
		return "redirect:/manager/member/memberList";
	}
//
//	@PostMapping("/modify")
//	public String modify(MemberVO Member, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
//		log.info("modify:" + Member);
//
//		if (service.modify(Member)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//
//		return "redirect:/Member/list";
//	}

	// 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("member_id") String member_id, RedirectAttributes rttr)
	{
		
		log.info("remove..." + member_id);
		if (service.remove(member_id)) {						// 회원 삭제에 성공한 경우에만
			rttr.addFlashAttribute("result", member_id);		// RedirectAttributes에 추가
			rttr.addFlashAttribute("status", "remove_success");	// RedirectAttributes에 추가
		}
		return "redirect:/manager/member/memberList";
	}
	
	
//	@PostMapping("/remove")
//	public String remove(@RequestParam("member_no") Long member_no, Criteria cri, RedirectAttributes rttr) {
//
//		log.info("remove..." + member_no);
//		if (service.remove(member_no)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//
//		return "redirect:/Member/list";
//	}
	
	
	
	
}
