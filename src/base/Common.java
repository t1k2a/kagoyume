package base;

import java.util.HashMap;

public class Common {
	// 取得したアプリケーションID
		public String getAppID() {
			 final String appID = "dj0zaiZpPVROZDVDbVA2QWx1WSZzPWNvbnN1bWVyc2VjcmV0Jng9M2I-";
			return appID;
		}

		/**
		 * @brief カテゴリーID一覧
		 *
		 * 商品カテゴリの一覧です。
		 * キーにカテゴリID、値にカテゴリ名が入っています。
		 * @var array
		 */
		public HashMap categories() {
			HashMap<String, String> categories = new HashMap<String, String>();
			categories.put("1","全てのカテゴリから");
			categories.put("13457","ファッション");
			categories.put("2498","食品");
			categories.put("2500","ダイエット、健康");
			categories.put("2501","コスメ、香水");
			categories.put("2502","パソコン、周辺機器");
			categories.put("2504","AV機器、カメラ");
			categories.put("2505","家電");
			categories.put("2506","家具、インテリア");
			categories.put("2507","花、ガーデニング");
			categories.put("2508","キッチン、生活雑貨、日用品");
			categories.put("2503","DIY、工具、文具");
			categories.put("2509","ペット用品、生き物");
			categories.put("2510","楽器、趣味、学習");
			categories.put("2511","ゲーム、おもちゃ");
			categories.put("2497","ベビー、キッズ、マタニティ");
			categories.put("2512","スポーツ");
			categories.put("2513","レジャー、アウトドア");
			categories.put("2514","自転車、車、バイク用品");
			categories.put("2516","CD、音楽ソフト");
			categories.put("2517","DVD、映像ソフト");
			categories.put("10002","本、雑誌、コミック");

			return categories;
		}

		/**
		 * @brief ソート方法一覧
		 *
		 * 検索結果のソート方法の一覧です。
		 * キーに検索用パラメータ、値にソート方法が入っています。
		 * @access private
		 * @var array
		 *
		 */
		public HashMap sortOrder() {
			HashMap<String, String> sortOrder = new HashMap<String, String>();
			sortOrder.put("-score", "おすすめ順");
			sortOrder.put("+price", "商品価格が安い順");
			sortOrder.put("-price", "おすすめ順");
			sortOrder.put("+name", "ストア名昇順");
			sortOrder.put("-name", "ストア名降順");
			sortOrder.put("-sold", "売れ筋順");

			return sortOrder;
		}

//		public function h(String str) {
//			return htmlspecialchars(str, ENT_QUOTES);
//		}
}
