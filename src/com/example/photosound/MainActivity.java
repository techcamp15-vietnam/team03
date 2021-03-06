/**
 * @author 3C Pham Tran Huynh
 * 
 */
package com.example.photosound;


import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.vn.R;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AppUtils.createImageFolderIfNotExist();
		AppUtils.createCountFileIfNotExist();

		TabHost tabHost = getTabHost();
		//Khởi tạo tab hình ảnh
		TabSpec photospec = tabHost.newTabSpec("HinhAnh");
		//Thiết lập tên tab hiển thị và icon
		photospec.setIndicator("", getResources().getDrawable(R.drawable.icon_photos_tab));
		//Thiết lập nôi dung cho tab này là activity HinhAnhActivity.class
		Intent photosIntent = new Intent(MainActivity.this, HomeActivity.class);
		photospec.setContent(photosIntent);

		//Khởi tạo tab nghe nhạc
		TabSpec songspec = tabHost.newTabSpec("NgheNhac");
		songspec.setIndicator("", getResources().getDrawable(R.drawable.icon_songs_tab));
		Intent songsIntent = new Intent(this, MarkedActivity.class);
		songspec.setContent(songsIntent);

		//Khởi tạo tab xem phim
//		TabSpec videospec = tabHost.newTabSpec("XemPhim");
//		videospec.setIndicator("", getResources().getDrawable(R.drawable.icon_videos_tab));
//		Intent videosIntent = new Intent(this, ProfileActivity.class);
//		videospec.setContent(videosIntent);

		//Thêm các TabSpec trên vào TabHost
		tabHost.addTab(photospec); //Thêm tab hình ảnh
		tabHost.addTab(songspec); //Thêm tab nghe nhạc
		tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.DKGRAY);

		tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.DKGRAY);
		
//.addTab(videospec); //Thêm tab xem phim
	}
}
