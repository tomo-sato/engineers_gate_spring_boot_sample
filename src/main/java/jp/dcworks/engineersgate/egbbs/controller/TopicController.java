package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcworks.engineersgate.egbbs.core.AppNotFoundException;
import jp.dcworks.engineersgate.egbbs.core.annotation.LoginCheck;
import jp.dcworks.engineersgate.egbbs.dto.RequestTopic;
import jp.dcworks.engineersgate.egbbs.dto.RequestTopicComment;
import jp.dcworks.engineersgate.egbbs.entity.Topics;
import jp.dcworks.engineersgate.egbbs.service.CommentsService;
import jp.dcworks.engineersgate.egbbs.service.TopicsService;
import jp.dcworks.engineersgate.egbbs.util.StringUtil;
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
public class TopicController extends AppController {

	/** トピック関連サービスクラス. */
	@Autowired
	private TopicsService topicsService;

	/** コメント関連サービスクラス. */
	@Autowired
	private CommentsService commentsService;

	/**
	 * [GET]トピック作成入力フォームのアクション。
	 *
	 * @param model 入力フォームのオブジェクト
	 */
	@GetMapping("/input")
	public String input(Model model) {

		log.info("トピック作成入力画面のアクションが呼ばれました。");

		if (!model.containsAttribute("requestTopic")) {
			model.addAttribute("requestTopic", new RequestTopic());
		}
		return "topic/input";
	}

	/**
	 * [POST]トピック作成アクション。
	 *
	 * @param requestTopic 入力フォームの内容
	 * @param result バリデーション結果
	 * @param redirectAttributes リダイレクト時に使用するオブジェクト
	 */
	@PostMapping("/regist")
	public String regist(@Validated @ModelAttribute RequestTopic requestTopic,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		log.info("トピック作成処理のアクションが呼ばれました。：requestTopic={}", requestTopic);

		// バリデーション。
		if (result.hasErrors()) {
			log.warn("バリデーションエラーが発生しました。：requestTopic={}, result={}", requestTopic, result);

			redirectAttributes.addFlashAttribute("validationErrors", result);
			redirectAttributes.addFlashAttribute("requestTopic", requestTopic);

			// 入力画面へリダイレクト。
			return "redirect:/topic/input";
		}

		// ログインユーザー情報取得
		Long usersId = getUsersId();

		// データ登録処理
		Topics topics = topicsService.save(requestTopic, usersId);

		return "redirect:/topic/detail/" + StringUtil.toString(topics.getId(), StringUtil.BLANK);
	}

	/**
	 * [POST]トピック詳細アクション。
	 *
	 * @param id トピックID
	 * @param model 入力フォームのオブジェクト
	 * @return
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {

		log.info("トピック詳細画面のアクションが呼ばれました。");

		if (!model.containsAttribute("requestTopic")) {
			model.addAttribute("requestTopicComment", new RequestTopicComment());
		}

		// トピック情報を取得する。
		Topics topics = topicsService.findTopics(id);

		if (topics == null) {
			// TODO tomo-sato エラーメッセージ
			throw new AppNotFoundException();
		}

		model.addAttribute("topics", topics);

		return "topic/detail";
	}

	/**
	 * [POST]コメント投稿アクション。
	 *
	 * @param topicsId トピックID
	 * @param requestTopicComment 入力フォームの内容
	 * @param result バリデーション結果
	 * @param redirectAttributes リダイレクト時に使用するオブジェクト
	 * @return
	 */
	@PostMapping("/comment/regist/{topicsId}")
	public String commentRegist(@PathVariable Long topicsId,
			@Validated @ModelAttribute RequestTopicComment requestTopicComment,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		log.info("コメント投稿処理のアクションが呼ばれました。：topicsId={}, requestTopicComment={}", topicsId, requestTopicComment);

		// バリデーション。
		if (result.hasErrors()) {
			log.warn("バリデーションエラーが発生しました。：topicsId={}, requestTopicComment={}, result={}", topicsId, requestTopicComment, result);

			redirectAttributes.addFlashAttribute("validationErrors", result);
			redirectAttributes.addFlashAttribute("requestTopicComment", requestTopicComment);

			// 入力画面へリダイレクト。
			return "redirect:/topic/input";
		}

		// ログインユーザー情報取得
		Long usersId = getUsersId();

		// コメント登録処理
		commentsService.save(requestTopicComment, usersId, topicsId);

		return "redirect:/topic/detail/" + StringUtil.toString(topicsId, StringUtil.BLANK);
	}
}
