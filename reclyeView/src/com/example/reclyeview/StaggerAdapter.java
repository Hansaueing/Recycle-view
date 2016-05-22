package com.example.reclyeview;

import java.util.ArrayList;
import java.util.List;

import com.example.reclyeview.adapter.RVAdapter;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;


public class StaggerAdapter extends RVAdapter {

	private List<Integer> height;

	public StaggerAdapter(List<String> data, Context context) {
		super(data, context);
		height = new ArrayList<Integer>();
		for (int i = 0; i < data.size(); i++) {
			height.add((int) (100 + Math.random() * 200));
		}
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		LayoutParams params = holder.tv.getLayoutParams();
		params.height = height.get(position);
		holder.tv.setLayoutParams(params);
		holder.tv.setText(data.get(position));
	}
}
