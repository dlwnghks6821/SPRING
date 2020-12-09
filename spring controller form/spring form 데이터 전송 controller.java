package com.mycompany.myapp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Handles requests for the application home page.
 */
@Controller

//==>�ݺ��Ǵ� ����̸��� �����Ҽ�����//

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//RequestMapping ==> controller ���� 
	//@RequestMapping(value = "/", method = RequestMethod.GET) �ÿ� �Ʒ� ������ ȣ���Ѵ�.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		int sum = 0;
		for(int i = 0 ; i <= 100; i++) {
			sum = sum+i;
		}
		int n = 20;
		int k = 40;
		int recursive  = 0;
		int myMobile=5512213;
		int result = n+k;
		String myName="Lee";

		model.addAttribute("myName",myName);
		model.addAttribute("result",result);
		model.addAttribute("sum",sum);
		model.addAttribute("my_mobile",myMobile);
		model.addAttribute("recursive",recursive);
		return "home";//home.jsp ȣ��//
	}
	@RequestMapping(value="/howareyou", method = RequestMethod.GET)
	public String howareyou(Locale locale, Model model) {
		String greeting = "im fine thanks you and you?";
		model.addAttribute("answer",greeting);
		return "howareyou";
	}
	// /myworld ==> route��.//
	//route �� /myworld �϶� �����Ѵ� ==> �׸��� �����ϸ� String myworld(Locale locale,Model model)�� ȣ�� 
	@RequestMapping(value="/myworld", method = RequestMethod.GET)
	public String myworld(Locale locale, Model model) {
	
		
		String addr = "cheonan";
		model.addAttribute("cheonan",addr);
		
		return "myworld";
	}
	//1)���1 model���̿�
	//@RequestMapping ==> ��û��� (path)//
	//return "board/view";==> �������� �̸�//
	//attribute �� �⺻�Ӽ��� ���ڿ��̴�.//
	//������ int �� ���� �ڵ����� ���ڿ��� ��ȯ�ǰԵȴ�.//
	@RequestMapping(value="/board/content", method = RequestMethod.GET)
		public String content(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		int id = 30;
		mv.addObject("id",id);
		mv.setViewName("board/content");
		model.addAttribute("id",id);
		return "board/content";
		//return mv;
		
	}
	//2)Ŭ���� ���//
	//���2) new ��ü (Ŭ����)�� �̿��� ���޹��
	
	@RequestMapping(value="/board/reply", method = RequestMethod.GET)
	public ModelAndView reply() {
		int id = 30;
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",id);
		mv.setViewName("board/reply");
		return mv;	
	}	
	//���ǻ��� : ��Ʈ�ѷ� �ߺ� �ϸ�ȵȴ�//
	//��δ� �ϳ��ε� �޼ҵ尡 �ߺ��Ǵ� �� (�ߺ����) �� �ȵȴ�.//
	//��δ� �����ؾ��Ѵ�//
	//form �����ϱ�//
	//..../board/puls?first=999&second=888
	@RequestMapping(value="/board/plus",method = RequestMethod.GET)//����̸� �� /board/confirmId�̸� ȣ���ض�
	public String method1(HttpServletRequest req, Model model) {
		C c1 = new C();
		D d1 = new D();
		int recursive = c1.Running(100);
		int recursive2 = d1.Running2(5);
		int strId =Integer.parseInt((req.getParameter("first")));
		int strPw = Integer.parseInt((req.getParameter("second")));
		int result = strId+strPw;
		System.out.println(strId);
		System.out.println(strPw);
		model.addAttribute("str_id",strId);
		model.addAttribute("str_pw",strPw);
		model.addAttribute("result",result);
		model.addAttribute("recursive",recursive);
		model.addAttribute("recursive2",recursive2);
		
		return "board/plusresult";
			//jsp ���� �̸��� //
	}
}
class C{
	protected int Running(int x) {
		if(x==1) {
			return x;
		}else {
			return x+Running(x-1);
		}
	}
}
class D{
	protected int Running2(int x) {
		if(x==0) {
			return 0;
		}else if(x==1) {
			return 1;
		}else {
			return Running2(x-1)+Running2(x-2);
		}
	}
}