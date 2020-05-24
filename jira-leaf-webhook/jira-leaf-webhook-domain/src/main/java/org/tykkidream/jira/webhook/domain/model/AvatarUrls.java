package org.tykkidream.jira.webhook.domain.model;

/**
 * 头像地址
 */
public class AvatarUrls {
	private String s48x48;
	private String s32x32;
	private String s24x24;
	private String s16x16;

	public String getS48x48() {
		return s48x48;
	}

	public void setS48x48(String s48x48) {
		if (s48x48 != null) {
			this.s48x48 = s48x48;
		}
	}

	public String getS32x32() {
		return s32x32;
	}

	public void setS32x32(String s32x32) {
		if (s32x32 != null) {
			this.s32x32 = s32x32;
		}
	}

	public String getS24x24() {
		return s24x24;
	}

	public void setS24x24(String s24x24) {
		if (s24x24 != null) {
			this.s24x24 = s24x24;
		}
	}

	public String getS16x16() {
		return s16x16;
	}

	public void setS16x16(String s16x16) {
		if (s16x16 != null) {
			this.s16x16 = s16x16;
		}
	}
}
