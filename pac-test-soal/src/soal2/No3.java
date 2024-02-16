package soal2;

import java.util.Arrays;

public class No3 {

	public static void main(String[] args) {
		// TODO Input data: KATAK, MAKAN, MALAM
		// TODO Output data:
		// TODO KATAK merupakan palindrom
		// TODO MAKAN bukan palindrom
		// TODO MALAM merupakan palindrom

		// PALINDROME
		// Cek kata? Palindrome atau bukan (berati perlu kondisi ketika palindrome atau
		// bukan)
		// Kondisi = (Kata awal == Kata akhir) cari nilai tengah nya juga
	

		String input = "KATAK".replace(" ", "").trim();
		String[] kata = input.split("");
		int syarat = 0;

		for (int i = 0; i < kata.length; i++) {
			if (kata[i].equalsIgnoreCase(kata[(kata.length - 1) - i])) {
				syarat++;
				System.out.println(kata[i] + " = " + kata[(kata.length - 1) - i]);
			}
		}

		if (syarat == kata.length) {
			System.out.println(input + " merupakan palindrome");
		} else {
			System.out.println(input + " bukan palindrome");
		}

	}

}
