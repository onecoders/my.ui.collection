package cn.w.song.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import cn.w.song.widget.navigation.PressNavigationBar;

/**
 * 这是PressNavigationBar的一个应用demo
 * 仿"美丽说"顶部的具有按下效果的导航栏
 * 注意确定w.song.android.widget-1.0.2.jar已经导入项目
 * w.song.android.widget-1.0.2.jar包下载地址http://download.csdn.net/detail/swadair/4253236
 * 了解详情看博文http://blog.csdn.net/swadair/article/details/7494395
 * @author w.song
 * @version 1.0.1
 * @date 2012-4-24
 */
public class MeiLiShuoPressNavigationBarDemoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.meilishuopressnavigationbardemo_ui);
		PressNavigationBar pressNavigationBar = (PressNavigationBar) findViewById(R.id.navigationbartest_ui_PressNavigationBar);
		/* 动态部署数据 */
		String[] text = { "最热", "最新", "猜你喜欢" };
		int[] textSize = { 14, 14, 14 };//单位sp
		int[] textColor = { Color.WHITE, Color.WHITE, Color.WHITE };
		int[] image = { R.drawable.message_left_button_normal,
				R.drawable.message_middle_button_normal,
				R.drawable.message_right_button_normal };//未被选择样式（图片）
		int[] imageSelected = { R.drawable.message_left_button_pressed,
				R.drawable.message_middle_button_pressed,
				R.drawable.message_right_button_pressed };//被选择样式（图片）
		List<Map<String, Object>> pressBarList = new LinkedList<Map<String, Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("text", text[i]);
			map.put("textSize", textSize[i]);
			map.put("textColor", textColor[i]);
			map.put("image", image[i]);
			map.put("imageSelected", imageSelected[i]);
			pressBarList.add(map);
		}
		
		/* "按下效果导航栏"添加子组件  */
		pressNavigationBar.addChild(pressBarList);
		
		/* "按下效果导航栏"添加监视 */
		pressNavigationBar.setPressNavigationBarListener(new PressNavigationBar.PressNavigationBarListener() {
		  /**
            *@params position 被选位置
            *@params view 为导航栏
            *@params event 移动事件
            */
			@Override
			public void onNavigationBarClick(int position, View view,
					MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:// 按下去时
					
					break;
				case MotionEvent.ACTION_MOVE://移动中
					
					break;
				case MotionEvent.ACTION_UP:// 抬手时	
					
					break;
				}
			}
		});
	}
}
