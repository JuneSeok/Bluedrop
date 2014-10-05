package com.example.bluedrop;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class IconTextListAdapter_profile extends BaseAdapter {

	private Context mContext;
	private List<IconTextItem_profile> mItems = new ArrayList<IconTextItem_profile>();
	
	public IconTextListAdapter_profile(Context context){
		mContext = context;
	}
	public void addItem(IconTextItem_profile it){
		mItems.add(it);
	}
	
	public void setListItems(List<IconTextItem_profile> lit){
		mItems = lit;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mItems.get(position);
	}
	public boolean areAllItemsSelectable(){
		return false;
	}
	public boolean isSelecatabe(int position){
		try{
			return mItems.get(position).isSelectable();
		} catch (IndexOutOfBoundsException ex){
			return false;
		}
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		IconTextView_profile itemView;
		if (convertView ==null){
			itemView = new IconTextView_profile(mContext, mItems.get(position));
		} else {
			itemView = (IconTextView_profile) convertView;
			
			itemView.setIcon(mItems.get(position).getIcon());
			itemView.setText(0, mItems.get(position).getData(0));

			itemView.setText(0, mItems.get(position).getData(1));
			itemView.setText(0, mItems.get(position).getData(2));
		}
		return itemView;
	}

}
