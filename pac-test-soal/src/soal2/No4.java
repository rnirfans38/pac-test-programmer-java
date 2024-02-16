package soal2;

import java.util.HashMap;
import java.util.Map;

public class No4 {

	public static void main(String[] args) {
		// TODO
		// Jumlah kata dari teks di atas
		// Jumlah kemunculan tiap kata dari teks di atas
		// Jumlah kata yang muncul hanya satu kali
		// Jumlah kata yang paling banyak muncul dan katanya
		// Jumlah kata yang paling sedikit muncul dan katanya

		String input = "Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Bahasa ini banyak mengadopsi sintaksis yang terdapat pada C dan C++ namun dengan sintaksis model objek yang lebih sederhana serta dukungan rutin-rutin aras bawah yang minimal. Aplikasi-aplikasi berbasis java umumnya dikompilasi ke dalam bytecode dan dapat dijalankan pada berbagai Mesin Virtual Java";

		String inputReplace = input.replaceAll("[^a-zA-Z\\s]", "");

		String[] karakter = inputReplace.split(" ");

		//TODO Jumlah kata dari teks di atas
		int jumlahKata = 0;
		for(int i = 0; i < karakter.length; i++) {
			if (!karakter[i].isEmpty()) {
                jumlahKata++;
            }
		}
		System.out.println(jumlahKata);

		// TODO Jumlah kemunculan tiap kata dari teks di atas
		// Membuat map untuk menyimpan jumlah kemunculan tiap kata
		Map<String, Integer> jumlahKemunculan = new HashMap<>();

		// Menghitung jumlah kemunculan tiap kata
		for (String kata : karakter) {
			if (!kata.trim().isEmpty()) {
				if (!jumlahKemunculan.containsKey(kata)) {
					jumlahKemunculan.put(kata, 1);
				} else {
					jumlahKemunculan.put(kata, jumlahKemunculan.get(kata) + 1);
				}

			}

		}

		// Menampilkan hasil
		for (Map.Entry<String, Integer> entry : jumlahKemunculan.entrySet()) {
			System.out.println("Kata: " + entry.getKey() + ", Jumlah Kemunculan: " + entry.getValue());
		}

		// TODO Menghitung jumlah kata yang muncul hanya satu kali
		int jumlahKataSatuKali = 0;
		for (Map.Entry<String, Integer> entry : jumlahKemunculan.entrySet()) {
			if (entry.getValue() == 1) {
				jumlahKataSatuKali++;
			}
		}

		// Menampilkan jumlah kata yang muncul hanya satu kali
		System.out.println("Jumlah kata yang muncul hanya satu kali: " + jumlahKataSatuKali);

		// TODO Mencari kata yang paling banyak muncul
		String kataTerbanyak = "";
		int jumlahTerbanyak = 0;
		for (Map.Entry<String, Integer> entry : jumlahKemunculan.entrySet()) {
			if (entry.getValue() > jumlahTerbanyak) {
				kataTerbanyak = entry.getKey();
				jumlahTerbanyak = entry.getValue();
			}
		}

		// Menampilkan kata yang paling banyak muncul beserta jumlah kemunculannya
		System.out.println("Kata yang paling banyak muncul adalah '" + kataTerbanyak
				+ "' dengan jumlah kemunculan sebanyak " + jumlahTerbanyak + " kali.");

		// TODO Jumlah kata yang paling sedikit muncul dan katanya
		String kataTersedikit = "";
		int jumlahTersedikit = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entry : jumlahKemunculan.entrySet()) {
			if (entry.getValue() < jumlahTersedikit) {
				kataTersedikit = entry.getKey();
				jumlahTersedikit = entry.getValue();
			}
		}

		// Menampilkan kata yang paling sedikit muncul beserta jumlah kemunculannya
		System.out.println("Kata yang paling sedikit muncul adalah '" + kataTersedikit
				+ "' dengan jumlah kemunculan sebanyak " + jumlahTersedikit + " kali.");

	}

}
