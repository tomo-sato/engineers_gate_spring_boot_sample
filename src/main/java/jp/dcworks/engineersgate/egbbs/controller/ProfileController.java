package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.dcworks.engineersgate.egbbs.core.annotation.LoginCheck;
import lombok.extern.log4j.Log4j2;

/**
 * プロフィールコントローラー。
 *
 * @author tomo-sato
 */
@LoginCheck
@Log4j2
@Controller
@RequestMapping("/profile")
public class ProfileController extends AppController {

	@GetMapping(path = {"", "/"})
	public String index(Model model) {
		log.info("プロフィール画面のアクションが呼ばれました。");

		model.addAttribute("users", getUsers());

		return "profile/index";
	}
}
