package soal2;

import java.util.Arrays;

public class No1 {
	public static void main(String[] args) {
		// TODO Input data : Saya SeDAng beLaJar BaHasa PemrOrgRaman JAVA
		// TODO Output data: sAYA sEdaNG BElAjAR bAhASA pEMRoRGrAMAN java
		
		String input = "Saya SeDAng beLaJar BaHasa PemrOrgRaman JAVA";
		String kapital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String[] kalimat = input.split(" ");
		System.out.println(Arrays.toString(kalimat));
		
		for(int i = 0; i < kalimat.length; i++) { //Saya
			String [] karakter = kalimat[i].split("");
			for(int j = 0; j < karakter.length; j++) { //S,a,y,a
				if(kapital.contains(karakter[j])) {
					System.out.print(karakter[j].toLowerCase());
				}
				else {
					System.out.print(karakter[j].toUpperCase());
				}
			}
			System.out.print(" ");
		}
		
		
		
		
		
		
		

	}

}
