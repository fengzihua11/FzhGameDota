package com.fzh.game.db;

import java.util.ArrayList;

public class JiuGuanBean {

	public int _id = 0;
	public String name = "";
	public int number = 0;
	public int location = 0;
	public String pic = "";

	public ArrayList<HeroBean> heroList = new ArrayList<HeroBean>();
	
	public boolean addHero(HeroBean heroBean) {
		return heroList.add(heroBean);
	}

	public ArrayList<HeroBean> getHeros() {
		return heroList;
	}

	public String toString() {
		return "_id = " + _id + "-- name = " + name + "-- number = " + number
				+ "-- location = " + location + "-- pic = " + pic;
	}

}