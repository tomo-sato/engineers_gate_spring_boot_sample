package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

/**
 * アカウント登録コントローラー。
 *
 * @author tomo-sato
 */
@Log4j2
@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping(path = {"", "/"})
	public String index() {
		log.info("アカウント作成画面のアクションが呼ばれました。");
		return "home/index";
	}
}
