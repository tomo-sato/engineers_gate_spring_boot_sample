package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.dcworks.engineersgate.egbbs.core.annotation.LoginCheck;
import lombok.extern.log4j.Log4j2;

/**
 * アカウント登録コントローラー。
 *
 * @author tomo-sato
 */
@LoginCheck
@Log4j2
@Controller
@RequestMapping("/topic")
public class TopicController {

	@GetMapping("/input")
	public String input() {
		log.info("アカウント作成画面のアクションが呼ばれました。");
		return "topic/input";
	}

	@PostMapping("/regist")
	public String regist() {
		log.info("アカウント作成処理のアクションが呼ばれました。");
		return "redirect:/topic/detail";
	}

	@GetMapping("/detail")
	public String detail() {
		log.info("アカウント作成処理のアクションが呼ばれました。");
		return "topic/detail";
	}
}
