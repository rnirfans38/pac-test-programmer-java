package soal2;

public class No2 {

	public static void main(String[] args) {
		// TODO Input data : saya sedang belajar berenang
		// TODO Output data: ayas gnades rajaleb gnanereb

		String input = "saya sedang belajar berenang";
		String[] kalimat = input.split(" ");

		for (int i = 0; i < kalimat.length; i++) {
			String[] karakter = kalimat[i].split("");
			for (int j = karakter.length - 1; j >= 0; j--) {
				System.out.print(karakter[j]);
			}
			System.out.println(" ");
		}

	}

}
