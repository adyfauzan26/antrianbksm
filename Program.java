package com.antrian;

import java.util.LinkedList;

public class Program {
	private LinkedList<Antrian> antrian_poli = new LinkedList<Antrian>();

	private LinkedList<Antrian> antrian_spesialis = new LinkedList<Antrian>();

	public int daftar(String nama, int umur, String keluhan, int tipe) {
		Pasien p = new Pasien(nama, umur, keluhan);
		Antrian a = new Antrian(p, this.getNoAntrian(tipe));

		if (tipe == 0)
			this.antrian_poli.add(a);
		else
			this.antrian_spesialis.add(a);

		return a.getNoAntrian();
	}

	private int getNoAntrian(int tipe) {
		int no = 0;

		if (tipe == 0) {
			if (antrian_poli.size() > 0)
				no = antrian_poli.get(antrian_poli.size() - 1).getNoAntrian();

		} else if (tipe == 1) {
			if (antrian_spesialis.size() > 0)
				no = antrian_spesialis.get(antrian_spesialis.size() - 1).getNoAntrian();

		}

		return no + 1;
	}

	public Antrian panggil(int tipe) {
		Antrian a = null;
		if (tipe == 0) {
			if (antrian_poli.size() == 0)
				return a;
			a = antrian_poli.removeFirst();
		} else {
			if (antrian_spesialis.size() == 0)
				return a;
			a = antrian_spesialis.removeFirst();
		}
		return a;
	}

	public LinkedList<Antrian> getAntrian_poli() {
		return antrian_poli;
	}

	public LinkedList<Antrian> getAntrian_spesialis() {
		return antrian_spesialis;
	}

}
