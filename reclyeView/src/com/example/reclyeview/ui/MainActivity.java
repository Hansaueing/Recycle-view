package com.example.reclyeview.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Toast;

import com.example.reclyeview.DividerItemDecoration;
import com.example.reclyeview.MyOnItemClickListener;
import com.example.reclyeview.R;
import com.example.reclyeview.StaggerAdapter;
import com.example.reclyeview.adapter.RVAdapter;

public class MainActivity extends Activity implements MyOnItemClickListener {

	private RecyclerView rv;
	private RVAdapter rvAdapter;
	private List<String> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rv = (RecyclerView) findViewById(R.id.rv);
		data = new ArrayList<String>();
		for (char i = 'A'; i < 'Z'; i++) {
			data.add(String.valueOf(i));
			Log.i("han", "i=" + i);
		}
		rvAdapter = new RVAdapter(data, this);
		rv.setAdapter(rvAdapter);
		
		linVerView();
//		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//		rv.setLayoutManager(linearLayoutManager);
//
//		rv.addItemDecoration(new DividerItemDecoration(this,
//				DividerItemDecoration.VERTICAL_LIST));
//		rvAdapter.setOnItemClickListener(this);
	}

	class SpacesItemDecoration extends RecyclerView.ItemDecoration {
		private int space;

		public SpacesItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view,
				RecyclerView parent, State state) {
			outRect.bottom = space;
			outRect.left = space;
			outRect.right = space;
			if (parent.getChildItemId(view) != 0) {
				outRect.top = space;
			}
		}
	}

	@Override
	public void OnItemClickListener(View v, int position) {
		Toast.makeText(this, "点击了" + position, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.lin_ver:
			Toast.makeText(this, "线性垂直布局", Toast.LENGTH_SHORT).show();
			linVerView();
			
			break;
			
		case R.id.lin_hro:
			Toast.makeText(this, "线性水平布局", Toast.LENGTH_SHORT).show();
			linHorView();
			
			break;
			
		case R.id.grid_view:
			Toast.makeText(this, "网格布局", Toast.LENGTH_SHORT).show();
			gridView();
			
			break;

		case R.id.grid_view_random:
			Toast.makeText(this, "随机网格布局", Toast.LENGTH_SHORT).show();
			gridViewRandom();
			
			break;
			
		}

		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * 实现"线性垂直布局"方法
	 */
	private void linVerView(){
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		rv.setLayoutManager(linearLayoutManager);

		rv.addItemDecoration(new DividerItemDecoration(this,
				DividerItemDecoration.VERTICAL_LIST));
		rvAdapter.setOnItemClickListener(this);
	}
	/**
	 * 实现"线性水平布局"方法
	 */
	private void linHorView(){
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
		rv.setLayoutManager(linearLayoutManager);

		rv.addItemDecoration(new DividerItemDecoration(this,
				DividerItemDecoration.VERTICAL_LIST));
		rvAdapter.setOnItemClickListener(this);
	}
	/**
	 * 实现"网格布局"方法
	 */
	private void gridView(){
		GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 3);
		gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
		rv.setLayoutManager(gridLayoutManager);
		rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
		rvAdapter.setOnItemClickListener(this);
	}
	/**
	 * 实现"随机网格布局"方法
	 */
	private void gridViewRandom(){
		StaggerAdapter adapter=new StaggerAdapter(data,this);
		StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		rv.setAdapter(adapter);
		rv.setLayoutManager(staggeredGridLayoutManager);
	}
	private void reset(){
		rvAdapter = new RVAdapter(data, this);
		rv.setAdapter(rvAdapter);
	}
}
