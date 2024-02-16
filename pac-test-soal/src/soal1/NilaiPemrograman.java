package soal1;

import java.util.Arrays;
import java.util.Scanner;

public class NilaiPemrograman {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int jumlahLulus = 0;
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[][] dataNilai = new String[jumlahMahasiswa][4];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1) + ":");
            System.out.print("Masukkan NIM: ");
            String nim = scanner.next();
            System.out.print("Masukkan Nama: ");
            String nama = scanner.next();
            System.out.print("Masukkan Nilai Kehadiran: ");
            double kehadiran = scanner.nextDouble();
            System.out.print("Masukkan Nilai Midtest: ");
            double midtest = scanner.nextDouble();
            System.out.print("Masukkan Nilai UAS: ");
            double uas = scanner.nextDouble();
            
            //	Nilai Akhir = (0.2 * nilai kehadiran) + (0.4 * nilai midtest ) + (0.4 * nilai UAS)
            double nilaiAkhir = (0.2 * kehadiran) + (0.4 * midtest) + (0.4 * uas);
            
            dataNilai[i][0] = nim;
            dataNilai[i][1] = nama;
            dataNilai[i][2] = Double.toString(nilaiAkhir);
            
            if (nilaiAkhir >= 85) {
            	dataNilai[i][3] = "A";
            	jumlahLulus++;
            } else if (nilaiAkhir >= 76) {
            	dataNilai[i][3] = "B";
            	jumlahLulus++;
            } else if (nilaiAkhir >= 61) {
            	dataNilai[i][3] = "C";
            	jumlahLulus++;
            } else if (nilaiAkhir >= 46) {
            	dataNilai[i][3] = "D";
            } else {
            	dataNilai[i][3] = "E";
            }
          
        }
        
        for (int i = 0; i < dataNilai.length; i++) {
            for (int j = 0; j < dataNilai[i].length; j++) {
                System.out.print(dataNilai[i][j] + " ");
            }
            System.out.println();
      
        }
        
        System.out.println("\nNo. NIM       Nama       Nilai Akhir  Grade");
        System.out.println("======================================================");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("%-3d %-10s %-10s %-12s %-2s\n", (i + 1), dataNilai[i][0], dataNilai[i][1], dataNilai[i][2], dataNilai[i][3]);
        }
        System.out.println("======================================================");

        
        int jumlahTidakLulus = jumlahMahasiswa - jumlahLulus;

        System.out.println("\nJumlah Mahasiswa : " + jumlahMahasiswa + " (berdasarkan hasil kalkulasi)");
        System.out.println("Jumlah Mahasiswa yg Lulus : " + jumlahLulus + " (berdasarkan hasil kalkulasi)");
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + jumlahTidakLulus + " (berdasarkan hasil kalkulasi)");
        System.out.println("======================================================");
       
        
	}
	

}
