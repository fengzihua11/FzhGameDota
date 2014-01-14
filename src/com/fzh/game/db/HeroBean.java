package com.fzh.game.db;

import android.os.Parcel;
import android.os.Parcelable;

public class HeroBean implements Parcelable{
	public int _id = 0;
	// Ӣ�۵����ļ���
	public String name = "";
	// Ӣ�۵�Ӣ����
	public String eName = "";
	// Ӣ�۵ļ��
	public String shortName = "";
	// Ӣ����������������ݻ�����
	public int charpter = 0;
	// Ӣ���������ľƹݵ�_id
	public int jiu_id = 0;
	// Ӣ��ͼƬ
	public String pic = "";
	// Ӣ�۽���
	public String description = "";
	// ��ݼ�
	public String kaijie = "";	
	// ���ܼӵ�˵��
	public String jineng = "";
	// ����װ������
	public String qz = "";
	// ����װ������
	public String zz = "";
	// ����װ������
	public String hz = "";
	// ��Ӣ���������
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