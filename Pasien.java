package com.antrian;

class Pasien {
	private String nama;

	private int umur;

	private String keluhan;

	public Pasien(String nama, int umur, String keluhan) {
		this.nama = nama;
		this.umur = umur;
		this.keluhan = keluhan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}

	public String getKeluhan() {
		return keluhan;
	}

	public void setKeluhan(String keluhan) {
		this.keluhan = keluhan;
	}

}