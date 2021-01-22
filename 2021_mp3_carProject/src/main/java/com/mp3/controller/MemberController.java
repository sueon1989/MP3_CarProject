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

@Controller	// �������� ������ �ν�
@Log4j		
@RequestMapping("/member/*")	// /member�� �����ϴ� ��� ó���� MemberController�� ó���ϵ��� ����
@AllArgsConstructor			// MemberController�� MemberService�� ������: �����ڸ� ����� �ڵ����� �����ϵ��� ��
public class MemberController {

	private MemberService service;	
	
	BCryptPasswordEncoder pwencoder;
	
	// ���� �׽�Ʈ
	@GetMapping("/findIdInput")
	public String findIdInput() {
		return "/common/auth/findIdInput";
		
	}
	@GetMapping("/findPassInput")
	public String findPassInput() {
		return "/common/auth/findPassInput";
	}
	
//	http://localhost:8080/Member/list
//		* Console���� �α׸� Ȯ���ϱ� ���� 
//		## log4j.xml���� warn -> info�� ����
//			37��: <priority value="info" />	<!-- ����: warn -->
	// ���(����Ʈ)
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("����Ʈ");
//		model.addAttribute("list", service.getList());
////		model.addAttribute(service.getList());	// �̸� �����ص� ����Ÿ�� list�� ������
//	}	
	
	// ���(����Ʈ)
	// http://localhost:8080/member/list
	@GetMapping("/list")
	public String list(/* Criteria cri, */Model model) {
		
		log.info("����Ʈ");
		model.addAttribute("list", service.getList());
//		model.addAttribute("list", service.getList(cri));
//		model.addAttribute(service.getList());	// �̸� �����ص� ����Ÿ�� list�� ������
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
	// ���ȭ��: Get������� �Է� �������� �� �� �ֵ���
	// http://localhost:8080/member/register
	@GetMapping("/register")
//	@PreAuthorize("isAnonymous()")		// �͸��� ����� (�α������� ���� ��쵵 �ش�)
//	@PreAuthorize("isAuthenticated()")	// ������ ����� (�α����� ���)
//	@PreAuthorize("isFullyAnonymous()")	// ������ ����� (Rememver-me�� ������ ���, �ش� �ȵ�)
	public String register() {
		log.info("ȸ������ �Է�ȭ�� ȣ��");
		return "/common/member/memberReg";
	}
	

	@GetMapping("/register1")
	public String register1() {
		log.info("ȸ������ �Է�ȭ�� ȣ��1");
		return "/common/member/memberReg2";
	}

	// ���2 (������)
	@PostMapping("/register")
//	@GetMapping("/registerFi")
//	@PreAuthorize("isAnonymous()")		// �͸��� ����� (�α������� ���� ��쵵 �ش�)
	public String registerPost(MemberVO member, AuthVO auth, RedirectAttributes rttr) {
		log.info("registerPost ȸ������ ó�� ����");
		log.info("ȸ�� ���: " + member);
		log.info("���� ���: " + member);

		// ���̵� �ߺ�üũ
		boolean checkId = service.checkId(member);

		// ��� �۾�
		if (checkId == true) {	
			// �ߺ�ID�� �����ϸ� -> �ٽ� ȸ������ �������� ���ư���
			return "/member/memberReg";
		} else {	
			// �ߺ�ID�� �������� ������ -> ȸ������ ����
			log.info("��й�ȣ ó����......"+member.getMember_pass());
			member.setMember_pass( pwencoder.encode(member.getMember_pass()) );
			log.info("��й�ȣ ��ȣȭ......"+member.getMember_pass());	
			service.register(member, auth);

			// ���Ӱ� ��ϵ� ȸ�������� ���� ����
			rttr.addFlashAttribute("member", member);
			rttr.addFlashAttribute("status", "register_success");	// RedirectAttributes�� �߰�

			log.info("ȸ������ ó�� ����");

			// ��Ÿ�̷�Ʈ ������� ȸ������ �Ϸ�ȭ�� ȣ�� 
			return "redirect:/member/memberRegFinished";
		}
	}
	
	// ���̵� �ߺ� üũ
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

	// ���1 (�������) - model ���
//	@PostMapping("/register")
//	public String register(MemberVO Member, Model model) {
//
//		// ��� �۾�
//		log.info("���: " + Member);
//		service.register(Member);
//
//		// ���Ӱ� ��ϵ� �Խù��� ��ȣ�� ���� ����
//		model.addAttribute("result", Member.getmember_no());
//		// ���߿� �ѹ��� ���� �� �ֵ��� ��������!!!
//
//		// ��Ÿ�̷�Ʈ ������� ���ȭ�� Member/list ȣ�� 
//		return "redirect:/Member/list";
//	}

	// ��ȸ (�� ��) �Ǵ� ����
	// get���� member_no �޾Ƽ� �����ϱ�
	// http://localhost:8082/member/get?member_id=admin95
	@GetMapping({ "/get", "/modify" })	// @GetMapping, @PostMapping: URL�� �迭�� ó�� ����
	@PreAuthorize("isAuthenticated()")
	public String get(/* @RequestParam("member_id") */ String member_id, Model model) {
	
		log.info("��ȸ: /get  �Ǵ�  ����: /modify"+member_id);
		
		// ȭ�� ������ �ش� ��ȣ�� �Խù��� ����
		model.addAttribute("Member", service.get(member_id));
//		model.addAttribute(service.get(member_no));	// �̸� �����ϸ� ����Ÿ�� MemberVO�� ������
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
	// ����
	@PostMapping("/modify")
	public String modify(MemberVO Member, RedirectAttributes rttr) {
		
		log.info("����:" + Member);
		
		if (service.modify(Member)) {						// �� ������ ������ ��쿡��
			rttr.addFlashAttribute("result", Member.getMember_no());	// RedirectAttributes�� �߰�
			rttr.addFlashAttribute("status", "modify_success");	// RedirectAttributes�� �߰�
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

	// ����
	@PostMapping("/remove")
	public String remove(@RequestParam("member_id") String member_id, RedirectAttributes rttr)
	{
		
		log.info("remove..." + member_id);
		if (service.remove(member_id)) {						// ȸ�� ������ ������ ��쿡��
			rttr.addFlashAttribute("result", member_id);		// RedirectAttributes�� �߰�
			rttr.addFlashAttribute("status", "remove_success");	// RedirectAttributes�� �߰�
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
