package com.fzh.game.db;

import android.os.Parcel;
import android.os.Parcelable;

public class HeroBean implements Parcelable{
	public int _id = 0;
	// 英雄的中文件名
	public String name = "";
	// 英雄的英文名
	public String eName = "";
	// 英雄的简称
	public String shortName = "";
	// 英雄类别，如智力，敏捷或力量
	public int charpter = 0;
	// 英雄所出生的酒馆的_id
	public int jiu_id = 0;
	// 英雄图片
	public String pic = "";
	// 英雄介绍
	public String description = "";
	// 快捷键
	public String kaijie = "";	
	// 技能加点说明
	public String jineng = "";
	// 出门装备介绍
	public String qz = "";
	// 中期装备介绍
	public String zz = "";
	// 后期装备介绍
	public String hz = "";
	// 此英雄相关声音
	public String sy = "";	

	public String toString() {
		return "_id = " + _id + "-- name = " + name + "-- shortName = "
				+ shortName + "-- charPter = " + charpter + "-- pic = " + pic;
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(_id);
		dest.writeString(name);
		dest.writeString(eName);
		dest.writeString(shortName);
		dest.writeInt(charpter);
		dest.writeInt(jiu_id);		
		dest.writeString(pic);
		dest.writeString(description);
		dest.writeString(kaijie);	
		dest.writeString(jineng);
		dest.writeString(qz);
		dest.writeString(zz);
		dest.writeString(hz);
		dest.writeString(sy);
	}

	public static final Parcelable.Creator<HeroBean> CREATOR = new Parcelable.Creator<HeroBean>() {
		public HeroBean createFromParcel(Parcel source) {
			HeroBean item = new HeroBean();
			item._id = source.readInt();
			item.name = source.readString();
			item.eName = source.readString();
			item.shortName = source.readString();
			item.charpter = source.readInt();
			item.jiu_id = source.readInt();
			item.pic = source.readString();
			item.description = source.readString();
			item.kaijie = source.readString();	
			item.jineng = source.readString();
			item.qz = source.readString();
			item.zz = source.readString();
			item.hz = source.readString();
			item.sy = source.readString();			
			return item;
		}

		public HeroBean[] newArray(int size) {
			return null;
		}
	};

	public int describeContents() {
		return 0;
	}
}