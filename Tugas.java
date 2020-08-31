package com.antrian;

import java.util.LinkedList;
import java.util.Scanner;

public class Tugas {
	private static Program program = new Program();
	private static Scanner sc = new Scanner(System.in);

	private static void daftar(int tipe) {
		String nama = "";
		int umur = 0;
		String keluhan = "";
		System.out.print("Masukkan nama pasien: ");
		nama = sc.nextLine();

		if (nama.trim().length() == 0) {
			System.out.println("Nama harus diisi");
			return;
		}

		System.out.print("Masukkan umur: ");
		try {
			umur = sc.nextInt();
			sc.nextLine();
		} catch (Exception ex) {
			System.out.println("Umur harus diisi dan harus angka");
			return;
		}

		System.out.print("Masukkan keluhan: ");
		keluhan = sc.nextLine();

		if (keluhan.trim().length() == 0) {
			System.out.println("Keluhan harus diisi");
			return;
		}

		int nomor = program.daftar(nama, umur, keluhan, tipe);
		System.out.println("Pendaftaran berhasil, nomor antrian anda: " + nomor);

	}

	private static void menu() {
		System.out.println("Sistem Antrian Balai Kesehatan Santri Masyarakat");
		System.out.println("=================================================");
		System.out.println("1. Daftar Pasien Poli");
		System.out.println("2. Daftar Pasien Dokter Spesialis");
		System.out.println("3. Lihat Antrian Poli");
		System.out.println("4. Lihat Antrian Dokter Spesialis");
		System.out.println("5. Panggil Antrian Poli");
		System.out.println("6. Panggil Antrian Dokter Spesialis");
		System.out.println("7. Keluar");
	}

	private static void list(int tipe) {
		System.out.println("List Antrian : " + (tipe == 0 ? "Poli" : "Dokter Spesialis"));
		LinkedList<Antrian> antrians = null;
		if (tipe == 0)
			antrians = program.getAntrian_poli();
		else
			antrians = program.getAntrian_spesialis();

		int no = 1;
		for (Antrian a : antrians) {
			System.out.println(no++ + ". No Antrian " + a.getNoAntrian() + " atas nama " + a.getPasien().getNama());
		}

	}

	private static void panggil(int tipe) {
		Antrian a = program.panggil(tipe);
		if (a == null) {
			System.out.println("Tidak ada antrian");
		} else
			System.out.println("No Antrian " + a.getNoAntrian() + " silakan memasukkin ruangan pemeriksaan "
					+ (tipe == 0 ? "Poli" : "Dokter Spesialis"));
	}

	public static void main(String[] args) {
		while (true) {
			menu();
			System.out.print("Masukkan pilihan anda [1..7]: ");
			int pilihan = sc.nextInt();
			sc.nextLine();
			if (pilihan == 7)
				break;

			if (pilihan == 1) {
				daftar(0);
			} else if (pilihan == 2) {
				daftar(1);
			} else if (pilihan == 3) {
				list(0);
			} else if (pilihan == 4) {
				list(1);
			} else if (pilihan == 5) {
				panggil(0);
			} else if (pilihan == 6) {
				panggil(1);
			} else
				System.out.println("Pilihan tidak valid");

			System.out.println("");
			System.out.println("");
		}

	}
}
