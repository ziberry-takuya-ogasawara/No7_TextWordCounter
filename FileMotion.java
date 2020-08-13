package TextWordCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * ファイル操作を行うクラス
 *
 * @author ogasawara
 * @version 1.0
 */
public class FileMotion {

	/**
	 * 指定.txtファイルを読み込み、読み込んだファイルから上限六つまでを配列wordに格納する。
	 * 格納した単語の登場回数(重複回数)を配列countに格納するメソッド。
	 *
	 * @param word  読み込んだ.txtファイルの単語を上限六つまで格納するString配列。
	 * @param count 配列wordに格納した単語が読み込んだ.txtファイルに登場した回数を格納するint配列。
	 */
	public void inputFile(List<String> wordList, List<Integer> counts) {

		Scanner sc = null;
		int registrationLimit = 6;

		try {
			// ファイル読み込み処理
			File file = new File(
					"C:\\usr\\kis_java_pkg_ver4.8\\kis_java_pkg_ver4.8\\workspace\\Kadai\\src\\TextWordCounter\\word.txt");

			// ファイルを確認し、空なら処理を終了
			if (!fileSizeCheck(file)) {
				return;
			}

			sc = new Scanner(new FileInputStream(file));

			while (sc.hasNextLine()) {
				String readFile = sc.nextLine();
				boolean duplicationJudgment = true;
				for (int i = 0; i < wordList.size(); i++) {
					// wordの中に重複があれば重複箇所のカウントを+1
					if (wordList.get(i).equalsIgnoreCase(readFile)) {
						counts.set(i, counts.get(i) + 1);
						duplicationJudgment = false;
					}
				} // 6種類登録した場合は終了
				if (wordList.size() < registrationLimit) {
					// 一度も重複が無い場合新規当登録
					if (duplicationJudgment) {
						wordList.add(readFile);
						counts.add(1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("ファイルが存在しません。");
		} finally {
			sc.close();
		}
	}

	/**
	 * 配列wordとcountを出力するメソッド。
	 *
	 * @param word  読み込んだ.txtファイルの単語を上限六つまで格納するString配列。
	 * @param count 配列wordに格納した単語が読み込んだ.txtファイルに登場した回数を格納するint配列。
	 */
	public void readFile(List<String> word, List<Integer> count) {
		for (int i = 0; i < word.size(); i++) {
			System.out.println(word.get(i) + ":" + count.get(i) + "回出現です。");
		}
	}

	/**
	 * 引数に設定されたFileデータの空判定を行うメソッド。
	 *
	 * @param file 読み込んだファイルデータ
	 * @return boolean ファイルが空ならfalse。それ以外はtrueを返す。
	 */
	public boolean fileSizeCheck(File file) {
		if (!file.exists()) {
			System.out.println("ファイルの中身が空です。");
			return false;
		} else {
			return true;
		}
	}

}
