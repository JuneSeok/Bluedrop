package com.example.bluedrop;

import android.graphics.drawable.Drawable;

public class IconTextItem_profile {
	
	private Drawable mIcon;
	private String[] mData;
	
	private boolean mSelectable = true;
	
	public IconTextItem_profile(Drawable icon, String[] obj){
		mIcon = icon;
		mData = obj;
	}
	public IconTextItem_profile(Drawable icon, String obj01, String obj02, String obj03){
		mIcon = icon;
		
		mData = new String[3];
		mData[0] = obj01;
		mData[1] = obj02;
		mData[2] = obj03;
	}
	
	public boolean isSelectable(){
		return mSelectable;
	}
	public void setSelectable(boolean selectable){
		mSelectable = selectable;
	}

	public String[] getData(){
		return mData;
	}
	
	public String getData(int index){
		if (mData ==null || index >= mData.length){
			return null;
		}
		return mData[index];
	}
	
	public void setData(String[] obj){
		mData= obj;
	}
	public void setIcon(Drawable icon){
		mIcon=icon;
	}
	public Drawable getIcon(){
		return mIcon;
	}
	public int compareTo(IconTextItem_profile other){
		if (mData!=null){
			String[] otherData = other.getData();
			if (mData.length == otherData.length) {
				for (int i = 0; i < mData.length; i++){
					if (!mData[i].equals(otherData[i])){
						return -1;
					}
				}
			}else {
				return -1;
			}
		} else {
			throw new IllegalArgumentException();
		}
		return 0;
	}
}
