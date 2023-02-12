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
@RequestMapping("/account")
public class AccountController {

	@GetMapping(path = {"", "/"})
	public String index() {
		log.info("アカウント作成画面のアクションが呼ばれました。");
		return "account/index";
	}

	@PostMapping("/regist")
	public String regist() {
		log.info("アカウント作成処理のアクションが呼ばれました。");
		return "redirect:/account/complete";
	}

	@GetMapping("/complete")
	public String complete() {

		log.info("アカウント作成完了画面のアクションが呼ばれました。");
		return "account/complete";
	}
}
