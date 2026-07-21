package tugas2.pertemuan3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    static HashMap<String, String> kategori = new HashMap<>();
    static DecimalFormat kursIndonesia = new DecimalFormat("###,###.00");

    public static void main(String[] args) {
        kategori.put("M", "Mobil");
        kategori.put("K", "Motor");

        menu();
    }

    public static void menu() {
        int pilihan;
        do {
            System.out.println("\n=======================================");
            System.out.println("      SISTEM MANAJEMEN KENDARAAN       ");
            System.out.println("=======================================");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Lihat Semua Data Kendaraan");
            System.out.println("3. Lihat Detail Kendaraan (No. Data)");
            System.out.println("4. Cari Kendaraan (Kode / Merk)");
            System.out.println("5. Tampilkan Ringkasan & Statistik");
            System.out.println("6. Ubah Data Kendaraan");
            System.out.println("7. Hapus Data Kendaraan");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu (1-8): ");

            pilihan = inputAngkaValid();

            switch (pilihan) {
                case 1:
                    tambahData();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 2:
                    lihatData();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 3:
                    lihatDetailBerdasarkanNomor();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 4:
                    cariKendaraanMenu();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 5:
                    tampilkanStatistik();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 6:
                    ubahData();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 7:
                    hapusData();
                    tekanEnterUntukLanjut();
                    bersihkanLayar();
                    break;
                case 8:
                    System.out.println("\n[ Terima kasih! Program selesai. ]");
                    break;
                default:
                    System.out.println("[ Pilihan tidak valid! Pilih angka 1-8. ]");
                    jeda(3000);
                    bersihkanLayar();
                    
            }
        } while (pilihan != 8);
    }

    public static void tambahData() {
        
        System.out.println("\n--- Tambah Data Kendaraan ---");
        System.out.print("Masukkan Kategori [M = Mobil / K = Motor]: ");
        String kt = input.nextLine().toUpperCase();

        if (!kategori.containsKey(kt)) {
            System.out.println("[ Peringatan: Kategori tidak dikenali! Kembali ke menu. ]");
            return;
        }

        System.out.print("Masukkan Kode Kendaraan: ");
        String kode = input.nextLine();

        if (cariKendaraanKode(kode) != null) {
            System.out.println("[ Error: Kode kendaraan sudah terdaftar! ]");
            return;
        }

        System.out.print("Masukkan Merek: ");
        String merk = input.nextLine();
        System.out.print("Masukkan Warna: ");
        String warna = input.nextLine();

        // Validasi input harga
        System.out.print("Masukkan Harga: Rp. ");
        double harga = inputDoubleValid();

        if (kt.equals("M")) {
            Mobil mobil = new Mobil();
            mobil.setKodeKendaraan(kode);
            mobil.setMerk(merk);
            mobil.setWarna(warna);
            mobil.setHarga(harga);

            System.out.print("Masukkan Nama Mobil: ");
            mobil.setNamaMobil(input.nextLine());

            // Validasi Tipe Mobil
            String tipeMobil;
            while (true) {
                System.out.print("Masukkan Tipe Mobil (Matic or Manual): ");
                tipeMobil = input.nextLine();
                if (tipeMobil.equalsIgnoreCase("Matic") || tipeMobil.equalsIgnoreCase("Manual")) {
                    tipeMobil = tipeMobil.substring(0, 1).toUpperCase() + tipeMobil.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Tipe mobil hanya boleh 'Matic' atau 'Manual'! ]");
            }
            mobil.setTypeMobil(tipeMobil);

            // Validasi Bahan Bakar Mobil
            String tipeBahanBakar;
            while (true) {
                System.out.print("Masukkan Jenis Bahan Bakar (Solar/Pertamax Turbo/Pertamax/Pertalite): ");
                tipeBahanBakar = input.nextLine();
                if (tipeBahanBakar.equalsIgnoreCase("Solar") || tipeBahanBakar.equalsIgnoreCase("Pertamax Turbo")
                        || tipeBahanBakar.equalsIgnoreCase("Pertamax") || tipeBahanBakar.equalsIgnoreCase("Pertalite")) {
                    tipeBahanBakar = rapihkanTeks(tipeBahanBakar);
                    break;
                }
                System.out.println("[ Peringatan: Bahan bakar harus [Solar], [Pertamax Turbo], [Pertamax], atau [Pertalite] ]");
            }
            mobil.setTypeBahanBakar(tipeBahanBakar);

            daftarKendaraan.add(mobil);
            System.out.println(" Data Mobil berhasil ditambahkan!");

        } else if (kt.equals("K")) {
            Motor motor = new Motor();
            motor.setKodeKendaraan(kode);
            motor.setMerk(merk);
            motor.setWarna(warna);
            motor.setHarga(harga);

            System.out.print("Masukkan Nama Motor: ");
            motor.setNamaMotor(input.nextLine());

            // Validasi Tipe Motor
            String tipeMotor;
            while (true) {
                System.out.print("Masukkan Tipe Motor (Matic, Gigi, atau Kopling): ");
                tipeMotor = input.nextLine();
                if (tipeMotor.equalsIgnoreCase("Matic") || tipeMotor.equalsIgnoreCase("Gigi")
                        || tipeMotor.equalsIgnoreCase("Kopling")) {
                    tipeMotor = tipeMotor.substring(0, 1).toUpperCase() + tipeMotor.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Tipe motor hanya boleh 'Matic', 'Gigi', atau 'Kopling'! ]");
            }
            motor.setTypeMotor(tipeMotor);

            // Validasi Bahan Bakar Motor
            String tipeBhnMotor;
            while (true) {
                System.out.print("Masukkan Jenis Bahan Bakar (Pertalite / Pertamax): ");
                tipeBhnMotor = input.nextLine();
                if (tipeBhnMotor.equalsIgnoreCase("Pertalite") || tipeBhnMotor.equalsIgnoreCase("Pertamax")) {
                    tipeBhnMotor = tipeBhnMotor.substring(0, 1).toUpperCase() + tipeBhnMotor.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Bahan Bakar Motor harus 'Pertalite' atau 'Pertamax'! ]");
            }
            motor.setTypeBahanBakar(tipeBhnMotor);

            daftarKendaraan.add(motor);
            System.out.println(" Data Motor berhasil ditambahkan!");
        }
    }

    public static void lihatData() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("\n[ Data Kendaraan Masih Kosong ]");
            return;
        }

        System.out.println("\n==========================================================================");
        System.out.println("                         DAFTAR DATA KENDARAAN                            ");
        System.out.println("==========================================================================");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println("NO DATA : [" + (i + 1) + "]");
            daftarKendaraan.get(i).tampilkanInfo();
            System.out.println("--------------------------------------------------------------------------\n");
        }
    }

    public static void lihatDetailBerdasarkanNomor() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("\n[ Data Kendaraan Masih Kosong ]");
            return;
        }

        System.out.print("\nMasukkan Nomor Data Kendaraan (1 - " + daftarKendaraan.size() + "): ");
        int noData = inputAngkaValid();

        if (noData >= 1 && noData <= daftarKendaraan.size()) {
            System.out.println("\n=======================================");
            System.out.println("      DETAIL KENDARAAN NO. " + noData);
            System.out.println("=======================================");
            daftarKendaraan.get(noData - 1).tampilkanInfo();
            System.out.println("=======================================");
        } else {
            System.out.println("[ Nomor data tidak valid! ]");
        }
    }

    // Fitur: Pencarian berdasarkan Kode atau Merk
    public static void cariKendaraanMenu() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("\n[ Data Kendaraan Masih Kosong ]");
            return;
        }

        System.out.println("\n--- Cari Kendaraan ---");
        System.out.println("1. Cari Berdasarkan Kode");
        System.out.println("2. Cari Berdasarkan Merk");
        System.out.print("Pilih opsi (1-2): ");
        int opsi = inputAngkaValid();

        if (opsi == 1) {
            System.out.print("Masukkan Kode Kendaraan: ");
            String kode = input.nextLine();
            Kendaraan k = cariKendaraanKode(kode);
            if (k != null) {
                System.out.println("\n--- Data Ditemukan ---");
                k.tampilkanInfo();
            } else {
                System.out.println("[ Data dengan kode '" + kode + "' tidak ditemukan! ]");
            }
        } else if (opsi == 2) {
            System.out.print("Masukkan Merk Kendaraan: ");
            String merk = input.nextLine();
            boolean ditemukan = false;
            System.out.println("\n--- Hasil Pencarian Merk '" + merk + "' ---");
            for (Kendaraan k : daftarKendaraan) {
                if (k.getMerk().equalsIgnoreCase(merk)) {
                    k.tampilkanInfo();
                    System.out.println("---------------------------------------");
                    ditemukan = true;
                }
            }
            if (!ditemukan) {
                System.out.println("[ Tidak ada kendaraan dengan merk '" + merk + "' ]");
            }
        } else {
            System.out.println("[ Opsi tidak valid! ]");
        }
    }

    public static void tampilkanStatistik() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("\n[ Data Kendaraan Masih Kosong ]");
            return;
        }

        int jumlahMobil = 0;
        int jumlahMotor = 0;
        double totalHarga = 0;

        for (Kendaraan k : daftarKendaraan) {
            if (k instanceof Mobil) {
                jumlahMobil++;
            } else if (k instanceof Motor) {
                jumlahMotor++;
            }
            totalHarga += k.getHarga();
        }

        double rataRata = totalHarga / daftarKendaraan.size();

        System.out.println("\n=======================================");
        System.out.println("     RINGKASAN & STATISTIK KENDARAAN    ");
        System.out.println("=======================================");
        System.out.println(" Total Kendaraan : " + daftarKendaraan.size() + " unit");
        System.out.println("   - Jumlah Mobil  : " + jumlahMobil + " unit");
        System.out.println("   - Jumlah Motor  : " + jumlahMotor + " unit");
        System.out.println("---------------------------------------");
        System.out.println(" Total Harga     : Rp. " + kursIndonesia.format(totalHarga));
        System.out.println(" Rata-Rata Harga : Rp. " + kursIndonesia.format(rataRata));
        System.out.println("=======================================");
    }

    public static void ubahData() {
        System.out.println("\n--- Ubah Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[ Data kosong, tidak ada yang bisa diubah ]");
            return;
        }

        System.out.print("Masukkan Kode Kendaraan yang ingin diubah: ");
        String kode = input.nextLine();
        Kendaraan k = cariKendaraanKode(kode);

        if (k == null) {
            System.out.println("[ Data dengan kode '" + kode + "' tidak ditemukan! ]");
            return;
        }

        System.out.println("\nData Lama Ditemukan.");
        System.out.print("Masukkan Merek Baru: ");
        k.setMerk(input.nextLine());
        System.out.print("Masukkan Warna Baru: ");
        k.setWarna(input.nextLine());
        
        System.out.print("Masukkan Harga Baru: Rp. ");
        k.setHarga(inputDoubleValid());

        if (k instanceof Mobil) {
            Mobil m = (Mobil) k;
            System.out.print("Masukkan Nama Mobil Baru: ");
            m.setNamaMobil(input.nextLine());

            String tipeMobil;
            while (true) {
                System.out.print("Masukkan Tipe Mobil Baru (Matic or Manual): ");
                tipeMobil = input.nextLine();
                if (tipeMobil.equalsIgnoreCase("Matic") || tipeMobil.equalsIgnoreCase("Manual")) {
                    tipeMobil = tipeMobil.substring(0, 1).toUpperCase() + tipeMobil.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Tipe mobil hanya boleh 'Matic' atau 'Manual'! ]");
            }
            m.setTypeMobil(tipeMobil);

            String tipeBahanBakar;
            while (true) {
                System.out.print("Masukkan Jenis Bahan Bakar Baru: ");
                tipeBahanBakar = input.nextLine();
                if (tipeBahanBakar.equalsIgnoreCase("Solar") || tipeBahanBakar.equalsIgnoreCase("Pertamax Turbo")
                        || tipeBahanBakar.equalsIgnoreCase("Pertamax") || tipeBahanBakar.equalsIgnoreCase("Pertalite")) {
                    tipeBahanBakar = rapihkanTeks(tipeBahanBakar);
                    break;
                }
                System.out.println("[ Peringatan: Bahan bakar harus [Solar], [Pertamax Turbo], [Pertamax], atau [Pertalite] ]");
            }
            m.setTypeBahanBakar(tipeBahanBakar);

        } else if (k instanceof Motor) {
            Motor mot = (Motor) k;
            System.out.print("Masukkan Nama Motor Baru: ");
            mot.setNamaMotor(input.nextLine());

            String tipeMotor;
            while (true) {
                System.out.print("Masukkan Tipe Motor Baru (Matic, Gigi, atau Kopling): ");
                tipeMotor = input.nextLine();
                if (tipeMotor.equalsIgnoreCase("Matic") || tipeMotor.equalsIgnoreCase("Gigi")
                        || tipeMotor.equalsIgnoreCase("Kopling")) {
                    tipeMotor = tipeMotor.substring(0, 1).toUpperCase() + tipeMotor.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Tipe motor hanya boleh 'Matic', 'Gigi', atau 'Kopling'! ]");
            }
            mot.setTypeMotor(tipeMotor);

            String tipeBhnMotor;
            while (true) {
                System.out.print("Masukkan Jenis Bahan Bakar Baru: ");
                tipeBhnMotor = input.nextLine();
                if (tipeBhnMotor.equalsIgnoreCase("Pertalite") || tipeBhnMotor.equalsIgnoreCase("Pertamax")) {
                    tipeBhnMotor = tipeBhnMotor.substring(0, 1).toUpperCase() + tipeBhnMotor.substring(1).toLowerCase();
                    break;
                }
                System.out.println("[ Peringatan: Bahan Bakar Motor harus 'Pertalite' atau 'Pertamax'! ]");
            }
            mot.setTypeBahanBakar(tipeBhnMotor);
        }

        System.out.println(" Data kendaraan dengan kode " + kode + " berhasil diperbarui!");
    }

    public static void hapusData() {
        System.out.println("\n--- Hapus Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[ Data kosong, tidak ada yang bisa dihapus ]");
            return;
        }

        System.out.print("Masukkan Kode Kendaraan yang ingin dihapus: ");
        String kode = input.nextLine();
        Kendaraan k = cariKendaraanKode(kode);

        if (k == null) {
            System.out.println("[ Data dengan kode '" + kode + "' tidak ditemukan! ]");
            return;
        }

        daftarKendaraan.remove(k);
        System.out.println(" Data kendaraan dengan kode " + kode + " berhasil dihapus!");
    }

    // --- HELPER / METHOD VALIDASI ---

    private static Kendaraan cariKendaraanKode(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    // Validasi input angka integer aman dari crash
    private static int inputAngkaValid() {
        while (!input.hasNextInt()) {
            System.out.print("[ Input harus berupa angka! ]: ");
            input.next();
        }
        int nilai = input.nextInt();
        input.nextLine();
        return nilai;
    }

    // Validasi input harga (double) tidak boleh minus & aman dari crash
    private static double inputDoubleValid() {
        double val;
        while (true) {
            while (!input.hasNextDouble()) {
                System.out.print("[ Input harga harus berupa angka! ]: Rp. ");
                input.next();
            }
            val = input.nextDouble();
            input.nextLine();
            if (val >= 0) {
                break;
            }
            System.out.print("[ Harga tidak boleh negatif! ]: Rp. ");
        }
        return val;
    }

    private static String rapihkanTeks(String teks) {
        String[] kata = teks.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String k : kata) {
            if (!k.isEmpty()) {
                sb.append(Character.toUpperCase(k.charAt(0)))
                  .append(k.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    private static void tekanEnterUntukLanjut() {
    System.out.print("\nTekan [ENTER] untuk kembali ke menu utama...");
    input.nextLine();
}


private static void jeda(int milidetik) {
    try {
        Thread.sleep(milidetik);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

// Helper untuk membersihkan layar konsol
private static void bersihkanLayar() {
    try {
        // Deteksi sistem operasi
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            // Untuk Windows Command Prompt / CMD
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            // Untuk Terminal Linux / macOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        // Fallback jika dijalankan di Terminal IDE (seperti Eclipse/IntelliJ/NetBeans)
        // yang tidak mendukung perintah bawaan OS
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
}