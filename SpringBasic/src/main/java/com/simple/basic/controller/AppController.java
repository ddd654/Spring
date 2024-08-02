package com.simple.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.Apple;

@Controller
@RequestMapping("/quiz") // quiz 폴더 안에
public class AppController {

	// 1. 우선 화면을 띄운다
	@RequestMapping("/quiz01") // quiz01 파일 요청
	public String basic() {
		return "/quiz/quiz01"; // quiz01 화면 띄우기
	}

	// 2. 폼화면
//	@RequestMapping(value = "/join", method= RequestMethod.POST)
//	public String join(
//			@ModelAttribute("id") String a,
//			@ModelAttribute("pw") String b,
//			@ModelAttribute("name") String c,
//			@ModelAttribute("email") String d) {
//		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		
//		return "/quiz/quiz01_ok";
//	}

	//
	@RequestMapping("/join")
	public String join(@ModelAttribute("vooo") Apple vo, Model model) {
		return "/quiz/quiz01_ok";
	}

	/////////////

	@RequestMapping("/quiz02")
	public String quiz_mothod() {
		return "/quiz/quiz02"; // 화면
	}

	@RequestMapping(value = "/apple", method = RequestMethod.POST)
	public String app2(@ModelAttribute("year") String year, @ModelAttribute("month") String month,
			@ModelAttribute("day") String day, @ModelAttribute("msg") String msg) {

		return "/quiz/quiz02_ok";

	}

	@RequestMapping()
	public String birth(@RequestParam("year") String year, @RequestParam("month") String month,
			@RequestParam("day") String day, @RequestParam("msg") String msg, RedirectAttributes ra) {

		String str = year + "-" + month + "-" + day + "-" + msg;
		ra.addFlashAttribute("msg", str);

		return "redirect:/quiz/quiz02_ok";
	}

	///////////

//	// quiz02 화면요청
//	@RequestMapping("/quiz02")
//	public String coco() {
//		return "quiz/quiz02";
//	}
//
//	// result 화면요청
//	@RequestMapping("/result")
//	public String result() {
//		return "quiz/result";
//	}
//
//	// 폼요청
//	@RequestMapping("/birthForm")
//	public String birthForm(@RequestParam("year") String year, @RequestParam("month") String month,
//			@RequestParam("day") String day, @RequestParam("msg") String msg, RedirectAttributes ra) {
//
//		String str = year + "-" + month + "-" + day + "-" + msg;
//		ra.addFlashAttribute("msg", str); // 리다이렉트 시에 1번 사용할 수 있음.
//
//		return "redirect:/quiz/result"; // 다시 컨트롤러를 태움
//	}

}
