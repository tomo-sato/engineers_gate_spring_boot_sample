package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * アカウント登録コントローラー。
 *
 * @author tomo-sato
 */
@Controller
@RequestMapping("/shoulder")
public class ShoulderController {

	@GetMapping(path = {"", "/"})
	public String indes() {
		return "common/shoulder_fragment";
	}
}
