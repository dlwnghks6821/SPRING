package com.mycompany.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Ŀ�ǵ� ��ü�� �̿��� ���
@Controller
public class Controller2 {
	//Ŀ�ǵ� ��ü �̿��� �ϸ� �ּ�ó�� �Ѱ� ���� �� ª�� �ڵ带 �����ִ�//
	@RequestMapping(value="/member/join",method = RequestMethod.GET)
	public String joinData(//@RequestParam("name")String name,
						   //@RequestParam("id")String id,
						   //@RequestParam("pw")String pw,
						   //@RequestParam("email")String email,Model model) {
							Member member,Model model) {
		//Member member,Model model �̰��� Ŀ�ǵ� ��ü ����Ѵ�//
		//�����͸� �����ؾ��ϴ� ���� ������ ����Ѵ�.//
		//Member member = new Member();
		//member.setName(name);
		//member.setPw(pw);
		//member.setId(id);
		//member.setEmail(email);
		model.addAttribute("memberinfo",member);
		return "board/join";
		
		
}
}
	

