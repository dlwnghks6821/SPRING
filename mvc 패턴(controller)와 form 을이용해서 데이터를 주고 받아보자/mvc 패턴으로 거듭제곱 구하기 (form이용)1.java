package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller04 {
	@RequestMapping("/datain")
	public String index() {
		return "datain";
	}
	@RequestMapping(method=RequestMethod.GET, value="/dataout")
	public String getID(@RequestParam("first") int first,@RequestParam("second") int second,Model model) {
		//form���� ������(index)���� ������ �����͸� model �� ��Ƽ� view �� ����
		int result = (int) Math.pow(first, second);
		model.addAttribute("result",result);
		return "dataout";
	}
}
