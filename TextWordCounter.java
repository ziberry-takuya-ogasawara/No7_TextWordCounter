package TextWordCounter;

import java.util.*;

/**
 * 配置された.txtファイルを読み込み 単語の出力回数をカウントする。 大文字/小文字は区別しないものとする。例 test ,TEST
 * は同一として判定する。 全角半角は区別をするものとする。
 *
 * @author ogasawara
 * @version 1.0
 *
 */
public class TextWordCounter {
	/**
	 * 実行クラス
	 */
	public static void main(String[] args) {

		// 6個までの単語を格納するリスト
		List<String> wordList = new ArrayList<>();
		// 格納した6個の単語の出力回数をカウントするリスト
		List<Integer> counts = new ArrayList<>();
		// ファイル操作クラスをインスタンス化
		FileMotion motion = new FileMotion();
		// ファイルの読み込み
		motion.inputFile(wordList, counts);
		// ファイルの出力
		motion.readFile(wordList, counts);
	}

}
