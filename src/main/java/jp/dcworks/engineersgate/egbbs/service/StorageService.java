package jp.dcworks.engineersgate.egbbs.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import lombok.extern.log4j.Log4j2;

/**
 * ファイルアップロード関連サービスクラス。
 *
 * @author tomo-sato
 */
@Log4j2
@Service
public class StorageService {

	public String store(MultipartFile multipartFile) {

		// ファイル名取得
		String fileName = multipartFile.getOriginalFilename();

		if (StringUtils.isEmpty(fileName)) {
			return null;
		}

		// 格納先のフルパス ※事前に格納先フォルダ「UploadTest」をCドライブ直下に作成しておく
		Path filePath = Paths.get("src/main/resources/static/assets/profileimg/" + fileName);

		OutputStream stream = null;
		try {
			// アップロードファイルをバイト値に変換
			byte[] bytes  = multipartFile.getBytes();

			// バイト値を書き込む為のファイルを作成して指定したパスに格納
			stream = Files.newOutputStream(filePath);

			// ファイルに書き込み
			stream.write(bytes);
		} catch (IOException e) {
			log.error("ファイルアップロード中にエラーが発生しました。", e);
			return null;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					log.error("ファイルアップロードのクローズ処理でエラーが発生しました。", e);
				}
			}
		}

		return "/assets/profileimg/" + fileName;
	}
}
