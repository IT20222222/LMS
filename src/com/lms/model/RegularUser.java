package com.regular;

public class RegularUser {
	private int idru;
	private int maxo;
	private int maxw;
	private byte[] wash;
	private byte[] washdry;
	private byte[] washdrypress;
	private byte[] mending;
	private byte[] onedayservice;
	private byte[] pandd;
	private String uname;
	private String pword;
	
	public RegularUser(int idru, int maxo, int maxw, byte[] w, byte[] wd, byte[] wdp, byte[] mend,
			byte[] ods, byte[] pad, String uname, String pword) {
		this.idru = idru;
		this.maxo = maxo;
		this.maxw = maxw;
		this.wash = w;
		this.washdry = wd;
		this.washdrypress = wdp;
		this.mending = mend;
		this.onedayservice = ods;
		this.pandd = pad;
		this.uname = uname;
		this.pword = pword;
	}

	public int getIdru() {
		return idru;
	}

	public int getMaxo() {
		return maxo;
	}

	public int getMaxw() {
		return maxw;
	}

	public byte[] getWash() {
		return wash;
	}

	public byte[] getWashdry() {
		return washdry;
	}

	public byte[] getWashdrypress() {
		return washdrypress;
	}

	public byte[] getMending() {
		return mending;
	}

	public byte[] getOnedayservice() {
		return onedayservice;
	}

	public byte[] getPandd() {
		return pandd;
	}

	public String getUname() {
		return uname;
	}

	public String getPword() {
		return pword;
	}

	public void setIdru(int idru) {
		this.idru = idru;
	}

	public void setMaxo(int maxo) {
		this.maxo = maxo;
	}

	public void setMaxw(int maxw) {
		this.maxw = maxw;
	}

	public void setWash(byte[] wash) {
		this.wash = wash;
	}

	public void setWashdry(byte[] washdry) {
		this.washdry = washdry;
	}

	public void setWashdrypress(byte[] washdrypress) {
		this.washdrypress = washdrypress;
	}

	public void setMending(byte[] mending) {
		this.mending = mending;
	}

	public void setOnedayservice(byte[] onedayservice) {
		this.onedayservice = onedayservice;
	}

	public void setPandd(byte[] pandd) {
		this.pandd = pandd;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}
		
}
