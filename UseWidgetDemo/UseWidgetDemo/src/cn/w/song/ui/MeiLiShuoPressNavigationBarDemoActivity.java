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
 * ����PressNavigationBar��һ��Ӧ��demo
 * ��"����˵"�����ľ��а���Ч���ĵ�����
 * ע��ȷ��w.song.android.widget-1.0.2.jar�Ѿ�������Ŀ
 * w.song.android.widget-1.0.2.jar�����ص�ַhttp://download.csdn.net/detail/swadair/4253236
 * �˽����鿴����http://blog.csdn.net/swadair/article/details/7494395
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
		/* ��̬�������� */
		String[] text = { "����", "����", "����ϲ��" };
		int[] textSize = { 14, 14, 14 };//��λsp
		int[] textColor = { Color.WHITE, Color.WHITE, Color.WHITE };
		int[] image = { R.drawable.message_left_button_normal,
				R.drawable.message_middle_button_normal,
				R.drawable.message_right_button_normal };//δ��ѡ����ʽ��ͼƬ��
		int[] imageSelected = { R.drawable.message_left_button_pressed,
				R.drawable.message_middle_button_pressed,
				R.drawable.message_right_button_pressed };//��ѡ����ʽ��ͼƬ��
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
		
		/* "����Ч��������"��������  */
		pressNavigationBar.addChild(pressBarList);
		
		/* "����Ч��������"��Ӽ��� */
		pressNavigationBar.setPressNavigationBarListener(new PressNavigationBar.PressNavigationBarListener() {
		  /**
            *@params position ��ѡλ��
            *@params view Ϊ������
            *@params event �ƶ��¼�
            */
			@Override
			public void onNavigationBarClick(int position, View view,
					MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:// ����ȥʱ
					
					break;
				case MotionEvent.ACTION_MOVE://�ƶ���
					
					break;
				case MotionEvent.ACTION_UP:// ̧��ʱ	
					
					break;
				}
			}
		});
	}
}
