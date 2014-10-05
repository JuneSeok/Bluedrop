package com.example.bluedrop;

public class Data {
	private int mUserName;
	private int mDescription;
	private int mImage;
	
	public Data()
	{
		super(); //부모(Object)호출
	}


	public Data(int username, int description, int image)
	{
		super();
		this.mUserName = username;
		this.mDescription = description;
		this.mImage = image;
	}

	public int getTitle()
	{
		return mUserName;
	}

	public void setTitle(int title)
	{
		this.mUserName = title;
	}

	public int getDescription()
	{
		return mDescription;
	}


	public void setDescription(int description)
	{
		this.mDescription = description;
	}
	
	public int getImage()
	{
		return mImage;
	}

	public void setImage(int image)
	{
		this.mImage = image;
	}
}
