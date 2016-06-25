package steam_recommendation_proj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Control_hub4 {

	public static void main(String[] args) {

		try {

			// 進行評論玩家id之json檔案讀取
			FileReader steamreader = new FileReader("C:\\Users\\John-Wall\\Desktop\\Steam_user_list\\Steam_user_list.json");

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(steamreader);

			// 讀取所有評論玩家id物件之arraylist
			JSONArray app = (JSONArray) jsonObject.get("all_user_list");

			// 將JSONArray物件創建成Iterator迭代器
			Iterator it = app.iterator();
			

			int count = 0;

			// 取出Iterator中的集合使用者資料
			while (it.hasNext()) {

				count++;
				JSONObject collection = (JSONObject) it.next();

				// Debug訊息
				System.out.println("第" + count + "評論玩家的id為 **" + collection.get("id").toString() + "** " + "玩家Profile為 **"
						+ collection.get("user_profile").toString() + "** ");
				
                // 檢查玩家的遊戲評論淨化後輸出的檔案是否已經存在
				File check_file = new File("C:\\Users\\John-Wall\\Desktop\\Steam_user_review_clean\\"+collection.get("id").toString()+".json");
				
				
				if (!check_file.exists()) {
					
					

					
					Steam_game_review_clean clean = new Steam_game_review_clean();
					
					clean.do_game_review_clean("C:\\Users\\John-Wall\\Desktop\\Steam_user_review\\" + collection.get("id").toString() + ".json", "C:\\Users\\John-Wall\\Desktop\\Steam_user_review_clean\\"+collection.get("id").toString()+".json", "steam_user_respective_review", "review_content", "steam_user_respective_review_clean", "恭喜評論玩家id："+collection.get("id").toString()+ "，玩家Profile為 **" + collection.get("user_profile").toString()+"已經分析斷詞完囉!");
					
				}else{
					
					// Debug訊息
					System.out.println("第" + count + "評論玩家的id為 **" + collection.get("id").toString() + "** " + "玩家Profile為 **"
							+ collection.get("user_profile").toString() + "** "+"，此遊戲的評論已經淨化過囉！");
					System.out.println("-----------------------------------------");
					
				}
				
				
				
				
				

			}


		} catch (

		FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (ParseException e) {
			System.out.println(e.toString());
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		
		
	}

}
