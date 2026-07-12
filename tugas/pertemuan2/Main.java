package tugas.pertemuan2;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlah;
        String nim, nama;
        double nilaiTugas, nilaiUts, nilaiUas;

        System.out.println("Input Jumlah Mahasiswa :");
        jumlah = input.nextInt();
        input.nextLine();

        Mahasiswa[] daftar = new Mahasiswa[jumlah];

        int i = 0;

        do{
            System.out.println("Data Mahasiswa Ke- " + (i + 1));
               System.out.print("NIM           : ");
            nim = input.nextLine();

            System.out.print("Nama          : ");
             nama = input.nextLine();

            System.out.print("Nilai Tugas   : ");
             nilaiTugas = input.nextDouble();
            
            System.out.print("Nilai UTS     : ");
             nilaiUts = input.nextDouble();

            System.out.print("Nilai UAS     : ");
             nilaiUas = input.nextDouble();

            input.nextLine();

            daftar[i] = new Mahasiswa(nim, nama, nilaiTugas, nilaiUts, nilaiUas);
            i++;
        }
        while(i < jumlah);

        NilaiService nilai = new NilaiService();

        System.out.println("||||||||||||||||||||||||||||||");
        System.out.println("Data Mahasiswa");
        System.out.println("||||||||||||||||||||||||||||||");

        for(int j = 0; j < jumlah; j++){

            double nilaiAkhir = nilai.hitungNilaiAkhir(daftar[j]);
            String grade = nilai.hitungGrade(nilaiAkhir);
            String status = nilai.statusKelulusan(nilaiAkhir);

            System.out.println("--------------------------");
            System.out.println("Nim                : " + daftar[j].getNim());
            System.out.println("Nama               : " + daftar[j].getNama());
            System.out.println("Nilai Akhir        : " + nilaiAkhir);
            System.out.println("Grade              : " + grade);
            System.out.println("Status Kelulusan   : " + status);
            // System.out.println("Nim : " + daftar[j]);

            NilaiService.Keterangan(grade);
        }
        input.close();

    }
}
