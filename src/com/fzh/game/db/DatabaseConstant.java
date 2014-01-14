package com.fzh.game.db;

import android.provider.BaseColumns;

public class DatabaseConstant {	
	public static final String BG_HERO_EXTEND = "_big";
	public static final String SHU_HERO_EXTEND = "_shu";
	public static final String JI_HERO_EXTEND = "_ji";	
	public static final String QZ_HERO_EXTEND = "_qz";
	public static final String ZZ_HERO_EXTEND = "_zz";
	public static final String HZ_HERO_EXTEND = "_hz";
	
	// 1. jiuguan_table.
	public interface JiuGuanTBColumns extends BaseColumns {

		public static final String TB_NAME = "jiuguan_table";

		public static final String NAME = "name";
		public static final String NUMBER = "number";
		public static final String LOCATION = "location";
		public static final String PIC = "pic";

	}

	// 2. hero_table.
	public interface HeroTBColumns extends BaseColumns {

		public static final String TB_NAME = "hero_table";

		public static final String NAME = "name";
		public static final String CHARPTER = "charpter";
		public static final String VERSION = "version";

	}
}