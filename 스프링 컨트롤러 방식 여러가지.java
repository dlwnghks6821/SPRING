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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//RequestMapping ==> controller 에서 
	//@RequestMapping(value = "/", method = RequestMethod.GET) 시에 아래 내용을 호출한다.
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
		return "home";//home.jsp 호출//
	}
	@RequestMapping(value="/howareyou", method = RequestMethod.GET)
	public String howareyou(Locale locale, Model model) {
		String greeting = "im fine thanks you and you?";
		model.addAttribute("answer",greeting);
		return "howareyou";
	}
	// /myworld ==> route임.//
	//route 가 /myworld 일때 동작한다 ==> 그리고 동작하면 String myworld(Locale locale,Model model)를 호출 
	@RequestMapping(value="/myworld", method = RequestMethod.GET)
	public String myworld(Locale locale, Model model) {
	
		
		String addr = "cheonan";
		model.addAttribute("cheonan",addr);
		
		return "myworld";
	}
	//1)방법1 model만이용
	//@RequestMapping ==> 요청경로 (path)//
	//return "board/view";==> 뷰페이지 이름//
	//attribute 의 기본속성은 문자열이다.//
	//때문에 int 를 사용시 자동으로 문자열로 변환되게된다.//
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
	//2)클래스 사용//
	//방법2) new 객체 (클래스)를 이용한 전달방법
	
	@RequestMapping(value="/board/reply", method = RequestMethod.GET)
	public ModelAndView reply() {
		int id = 30;
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",id);
		mv.setViewName("board/reply");
		return mv;	
	}	
	//주의사항 : 컨트롤러 중복 하면안된다//
	//경로는 하나인데 메소드가 중복되는 것 (중복경로) 는 안된다.//
	//경로는 유일해야한다//
	//form 전송하기//
	//getParameter방식이용
	//..../board/puls?first=999&second=888
	@RequestMapping(value="/board/plus",method = RequestMethod.GET)//경로이름(url에들어가는 스트링) 이 /board/confirmId이면 호출해라
	public String method1(HttpServletRequest req, Model model) {
		int strId =Integer.parseInt((req.getParameter("first")));
		int strPw = Integer.parseInt((req.getParameter("second")));
		int result = strId+strPw;
		System.out.println(strId);
		System.out.println(strPw);
		model.addAttribute("str_id",strId);
		model.addAttribute("str_pw",strPw);
		model.addAttribute("result",result);
	
		
		return "board/plusresult";
			//jsp 파일 이름임 //
	}
	
	//RequestParam 으로 이용하는방법
	//RequestParam을 이용하면 약식으로 사용될수있다.//
	@RequestMapping(value="/board/plus4",method = RequestMethod.GET)
	public String method2(@RequestParam("first") int first,@RequestParam("second")int second, Model model) {
		
		int result = first+second;
		model.addAttribute("first",first);
		model.addAttribute("second",second);
		model.addAttribute("result",result);
		
		return "board/plusresult";
			//jsp 파일 이름임 //
	}
	
}
