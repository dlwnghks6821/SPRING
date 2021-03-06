package com.mycompany.myapp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jdk.internal.org.jline.utils.Log;

@Controller
public class Controller3 {
	//1)RequestParam 방법
	//2) queryString 을 통해서 매개변수를 전달할때 사용하는 방법
	//아래에 있는 (HttpServletRequest)클래스 를 이용한 방법의 축약 버전이라고 볼수있다. 간결하게 코드를 작성한다.//
	//이 방법이 좋은이유는 String 과 int 둘다 쿼리스트링을 작성할시에 사용할수있어서 ParseInt를 사용하지않아도 된다는 점이 좋다.//
	@RequestMapping(value="/helloworld", method = RequestMethod.GET)
	public String newnew05(@RequestParam("x") int x,@RequestParam("y")int y, Model model) {
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",result);
		return "board/newnew02";
	}
	
	//3)일반적인 (getParameter 가 없는 방법)//
	//==>Contorller 를 작성할때, Parameter 가 자동으로 수집되는 기능임.//
	//==>getParameter()이용하지 않는방법//
	//4)==>그냥 일반적으로 route에다가 쿼리스트링을 이용하여 매개변수를 주지않고, 변수를 미리 설정하여  사용할수도있음//
	//이 방법은 getParameter 가 없는 방법이기때문에 가능함.//
	@RequestMapping(value="/helloworld2",method = RequestMethod.GET)//경로(route 이름)
	public String newnew02(HttpServletRequest req, Model model) {
		//이런식으로 변수를 미리 설정해줄수도있고 
		int x = 40;
		int y = 20;
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result", result);
		//결론적으로 getParameter() 를 사용하지 않았다//
		return "board/newnew02";
			//jsp 파일 이름임 //
	}
	//5)getParameter()이용하는 방법//
	//이방법은 (HttpServletRequest) 클래스를 이용하여 쿼리스트링에 직접 입력 데이터를 전송하는 방법중하나이다.//
	//이방법은 위의 방법과 동일하지만 코드의 길이가 길다.//
	//이방법은 (HttpServletRequest) 클래스를 이용하며, 전송할 내용의 데이터를 쿼리스트링에서 getParameter 해주는 방식이다.//
	
	@RequestMapping(value="/helloworld3",method = RequestMethod.GET)
	public String newnew03(HttpServletRequest httpServletRequest,Model model) {
		//특징 ==> getParameter 에서 쿼리스트링에 들어가는 parameter 값은 String 이다 때문에 //
		//ParseInt과정을 거쳐줘야한다 (만약정수라면)//
		int x = Integer.parseInt(httpServletRequest.getParameter("x"));
		int y = Integer.parseInt(httpServletRequest.getParameter("y"));
		int result = x+y;
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", result);
	    return "board/newnew02";
	}
	//list 처리 방식 //
	//@RequestParam 에서어레이 리스트를 이용하여 여러값을 전달할때 처리방식 //
	//queryString 에 http://localhost:8080/myapp/helloworld4?ids=111&ids=222 이런식으로 전달해주면된다.//
	@RequestMapping(value="/helloworld4",method = RequestMethod.GET)
	//public String newnew06(@RequestParam("ids") ArrayList<String>ids) 
	public String newnew05(@RequestParam("ids") ArrayList<String> ids,Model model) {
		
		model.addAttribute("ids",ids);
		System.out.println(ids);
		return "board/newnew02";
		
	}
	//array(배열 처리방식)//
	//@RequestParam 에서 배열을 이용하여 배열값을 전달할때 처리방식//
	@RequestMapping(value="/helloworld5",method = RequestMethod.GET)
	public String newnew05(@RequestParam("ar1")String[]ar1,Model model) {
		ar1 = new String[2];
		
		for(int i = 0 ; i < ar1.length; i++) {
			System.out.println(ar1[i]);
			model.addAttribute("ar1", ar1[i]);

		}
	
	
		return "board/newnew02";
	}
	//Model 데이터 전달자 //
	//사용 예시 //
	//==>controller 메서드를 사용할때 (작성할때) 특별하게 Model 이라는 타입을 파라미터로 지정할수있음
	//Model ==> 파라미터로 전달된 데이터는 존재하지 않지만 화면에서 필요한 데이터를 전달하기 위해서 사용한다.//
	@RequestMapping(value="/helloworld25",method = RequestMethod.GET)
	public String newnew008(HttpServletRequest req, Model model) {
		//controller 에서 아래와 같은 데이터를 생성 했으면..//
		int k = 20 ;
		int j = 10 ;
		int result4 = k+j;
		//Model 이라는 객체를 이용해서 이를 담아주고 view 에 전송하는 역할을 해준다//
		model.addAttribute("k", k);
		model.addAttribute("j", j);
		return "board/newnew02";
	}
	//@ModelAttribute 사용을 왜하는가 ?
	//@ModelAttribute 는 강제로 전달받은 파라미터를 Model 에 담아서 전달하도록 할때 필요한 어노테이션
	//@ModelAttribute 가 걸린 파라미터는 타입에 관계없이 무조건 Model 에 담아서 전달되므로 파라미터로 전달된 데이터를 다시화면에서 사용할 경우에 유용하게 
	//사용하게 된다.
	@RequestMapping(value="/helloworld12",method = RequestMethod.GET)
	public String newnew99(HttpServletRequest req,@ModelAttribute("Page")int Page){
		
		return "board/newnew02";
}
	
	
}
