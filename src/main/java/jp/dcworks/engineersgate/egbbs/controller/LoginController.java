package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

/**
 * アカウント登録コントローラー。
 *
 * @author tomo-sato
 */
@Log4j2
@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("")
	public String index() {
		log.info("アカウント作成画面のアクションが呼ばれました。");
		return "login/index";
	}

	@PostMapping("login")
	public String login() {
		log.info("アカウント作成画面のアクションが呼ばれました。");
		return "redirect:/home";
	}
}
