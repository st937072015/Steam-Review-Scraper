package steam_recommendation_proj;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Sign_add_and_clean {

	// 處理特殊符號功能
	public void string_arraylist_add_sign(String text_content, String text_check_target, ArrayList<String> text_arraylist) {
		
		
		

	    // 找尋目標字串中所存在的目標字詞數量
		int text_count =StringUtils.countMatches(text_content, text_check_target);
		
		
		
		// 目標字詞數量判定完後再將確定數量的目標字詞塞入字串arraylist
		for (int i = 0; i < text_count ; i++) {
			
			text_arraylist.add(text_check_target);

		}
		
		
		
		
	}	
	// 過濾亂七八糟字詞只允許[a-z]與[,!?.]功能
	public int check_text_legal(String text_content) {
		
		int check_count=0;
		
	    // 檢查[a-z]
		for(char alphabet = 'a'; alphabet <= 'z';alphabet++) {
		    		    
		    // 找尋目標字串中是否所存在亂七八糟字詞之數量
			int text_count1 =StringUtils.countMatches(text_content, alphabet);
			
			if (text_count1>0) {
				
				check_count++;
				
			}    
		}
		
		
		// 檢查[,!?.]
		int text_count2 =StringUtils.countMatches(text_content, ",");
		int text_count3 =StringUtils.countMatches(text_content, "!");
		int text_count4 =StringUtils.countMatches(text_content, "?");
		int text_count5 =StringUtils.countMatches(text_content, ".");
		
		if (text_count2 > 0) {
			check_count++;
		}else if (text_count3 > 0) {
			check_count++;
		}else if (text_count4 > 0) {
			check_count++;
		}else if (text_count5 > 0) {
			check_count++;
		}
		
		
		
		
		
		
		
		return check_count;
		
	}
	
	// 判定斷詞後的字詞內容中是否有夾雜單一英文字母
	public boolean word_clean(String text_content) {
		
		
		
		if (text_content.equals("a")||text_content.equals("b")||text_content.equals("c")||text_content.equals("d")||text_content.equals("e")||text_content.equals("f")||text_content.equals("g")||text_content.equals("h")||text_content.equals("i")||text_content.equals("j")||text_content.equals("k")||text_content.equals("l")||text_content.equals("m")||text_content.equals("n")||text_content.equals("o")||text_content.equals("p")||text_content.equals("q")||text_content.equals("r")||text_content.equals("s")||text_content.equals("t")||text_content.equals("u")||text_content.equals("v")||text_content.equals("w")||text_content.equals("x")||text_content.equals("y")||text_content.equals("z")) {
			return true;
		}else {
			return false;
		}
		

		
	}
	
	
	
	
	public static void main(String[] args) {
		/*Sign_add a = new Sign_add();
	  a.string_arraylist_add_sign("you are a yellow", "y", null);
      */
	}

}
