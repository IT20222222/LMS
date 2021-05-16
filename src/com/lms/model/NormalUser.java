package com.normal;

public class NormalUser {
	private int idru;
	private int maxo;
	private int maxw;
	private byte[] wash;
	private byte[] washdry;
	private byte[] onedayservice;
	private byte[] pandd;
	private String uname;
	private String pword;
	
	/**
	 * @param idru
	 * @param maxo
	 * @param maxw
	 * @param wash
	 * @param washdry
	 * @param onedayservice
	 * @param pandd
	 * @param uname
	 * @param pword
	 */
	
	public NormalUser(int idru, int maxo, int maxw, byte[] wash, byte[] washdry, byte[] onedayservice, byte[] pandd,
			String uname, String pword) {
		super();
		this.idru = idru;
		this.maxo = maxo;
		this.maxw = maxw;
		this.wash = wash;
		this.washdry = washdry;
		this.onedayservice = onedayservice;
		this.pandd = pandd;
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
