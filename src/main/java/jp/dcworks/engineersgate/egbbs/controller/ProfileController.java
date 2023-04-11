package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcworks.engineersgate.egbbs.core.annotation.LoginCheck;
import jp.dcworks.engineersgate.egbbs.dto.RequestModifyAccount;
import jp.dcworks.engineersgate.egbbs.entity.Users;
import jp.dcworks.engineersgate.egbbs.service.StorageService;
import jp.dcworks.engineersgate.egbbs.service.UsersService;
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

	/** ファイルアップロード関連サービスクラス。 */
	@Autowired
	private StorageService storageService;

	/** ユーザー関連サービスクラス。 */
	@Autowired
	private UsersService usersService;

	/**
	 * [GET]プロフィール画面のアクション。
	 *
	 * @param model 入力フォームのオブジェクト
	 */
	@GetMapping(path = {"", "/"})
	public String index(Model model) {
		log.info("プロフィール画面のアクションが呼ばれました。");

		model.addAttribute("requestModifyAccount", getUsers());

		return "profile/index";
	}

	@PostMapping("/regist")
	public String regist(@Validated @ModelAttribute RequestModifyAccount requestModifyAccount,
			@RequestParam("profileFile") MultipartFile profileFile,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		log.info("プロフィール編集処理のアクションが呼ばれました。");

		// バリデーション。
		if (result.hasErrors()) {
			// javascriptのバリデーションを改ざんしてリクエストした場合に通る処理。
			log.warn("バリデーションエラーが発生しました。：requestModifyAccount={}, result={}", requestModifyAccount, result);

			redirectAttributes.addFlashAttribute("validationErrors", result);
			redirectAttributes.addFlashAttribute("requestModifyAccount", requestModifyAccount);

			// 入力画面へリダイレクト。
			return "redirect:/profile";
		}

		// ファイルアップロード処理。
		String fileUri = storageService.store(profileFile);

		// ユーザー検索を行う。（※「ログインID」で検索を行い、すでに登録済みの場合エラー。）
		Users users = getUsers();
		users.setName(requestModifyAccount.getName());
		users.setIconUri(fileUri);
		usersService.save(users);

		return "redirect:/profile";
	}
}
