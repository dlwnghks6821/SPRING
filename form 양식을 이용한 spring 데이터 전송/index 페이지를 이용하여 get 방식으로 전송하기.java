//@RequestMapping("/index")==>input �� �� �Է� ==> �Է� ���� ������ @RequestMapping(method=RequestMethod.GET, value="/student") �� 
	//index �� <form action="student"method="GET"> �̹Ƿ� , form ���� ��ΰ� student �̱⶧����
	//index���� ������ �����͸� student �� �����ϸ鼭 �����̵ȴ�.
	//������ �� 
 
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	//get ��� ==> .../student?student_id=xxx
	@RequestMapping(method=RequestMethod.GET, value="/student")
	public String getID(@RequestParam("student_id") String sid,Model model) {
		model.addAttribute("student_id",sid);
		return "student";
	}