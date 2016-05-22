package com.example.reclyeview.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reclyeview.MyOnItemClickListener;
import com.example.reclyeview.R;

public class RVAdapter extends Adapter<RVAdapter.ViewHolder> {

	public List<String> data;
	private Context context;
	private LayoutInflater inflater;
	private static MyOnItemClickListener clickListener;
	
	public void setOnItemClickListener(MyOnItemClickListener clickListener){
		this.clickListener=clickListener;
	}

	public RVAdapter(List<String> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
		public TextView tv;

		public ViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.tv_item);
			RVAdapter.clickListener=clickListener;
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if(clickListener!=null){
				clickListener.OnItemClickListener(v, getLayoutPosition());
			}
		}

	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.tv.setText(data.get(position));
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = inflater.inflate(R.layout.rv_item,arg0,false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}

	


}
