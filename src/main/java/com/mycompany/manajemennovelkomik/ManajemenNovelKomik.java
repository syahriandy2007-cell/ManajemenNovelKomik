package com.mycompany.manajemennovelkomik;

import java.util.Scanner;

public class ManajemenNovelKomik {

    // Method Overloading 1: Pencarian berdasarkan Judul (String)
    public static void cariKoleksi(String judul, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Judul: \"" + judul + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Koleksi dengan judul tersebut tidak ditemukan.");
        }
    }

    // Method Overloading 2: Pencarian berdasarkan Tahun Terbit (int)
    public static void cariKoleksi(int tahunTerbit, Koleksi[] daftarKoleksi, int jumlahKoleksi) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Tahun: " + tahunTerbit + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahKoleksi; i++) {
            if (daftarKoleksi[i].getTahunTerbit() == tahunTerbit) {
                System.out.print("- Ditemukan: ");
                daftarKoleksi[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Koleksi pada tahun tersebut tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Wadah Array dengan kapasitas maksimal 10 data
            Koleksi[] daftarKoleksi = new Koleksi[10];
            int jumlahKoleksi = 0;
            boolean isRunning = true;

            // Inisialisasi minimal 3-5 data objek awal lengkap dengan atribut spesifiknya
            daftarKoleksi[jumlahKoleksi++] = new Novel("Laskar Pelangi", "Andrea Hirata", 2005, "Drama/Inspiratif");
            daftarKoleksi[jumlahKoleksi++] = new Komik("Naruto Vol. 1", "Masashi Kishimoto", 1999, 1);
            daftarKoleksi[jumlahKoleksi++] = new Novel("Bumi", "Tere Liye", 2014, "Sci-Fi/Fantasi");
            daftarKoleksi[jumlahKoleksi++] = new Komik("One Piece Vol. 100", "Eiichiro Oda", 2021, 100);

            System.out.println("==================================================");
            System.out.println("   SELAMAT DATANG DI SISTEM MANAJEMEN NOVEL & KOMIK  ");
            System.out.println("==================================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Koleksi Baru (Novel / Komik)");
                System.out.println("2. Tampilkan Seluruh Koleksi");
                System.out.println("3. Cari Koleksi (Fitur Method Overloading)");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu (1-4): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer enter

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahKoleksi < daftarKoleksi.length) {
                            System.out.println("\n--- Pilih Jenis Koleksi ---");
                            System.out.println("1. Novel");
                            System.out.println("2. Komik");
                            System.out.print("Pilihan (1/2): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Judul       : ");
                            String judulBaru = scanner.nextLine();
                            System.out.print("Masukkan Penulis     : ");
                            String penulisBaru = scanner.nextLine();
                            System.out.print("Masukkan Tahun Terbit: ");
                            int tahunBaru = scanner.nextInt();
                            scanner.nextLine();

                            if (jenis == 1) {
                                System.out.print("Masukkan Genre Novel : ");
                                String genreBaru = scanner.nextLine();
                                // Instansiasi objek Novel (Subclass)
                                daftarKoleksi[jumlahKoleksi] = new Novel(judulBaru, penulisBaru, tahunBaru, genreBaru);
                                jumlahKoleksi++;
                                System.out.println("Sukses! Novel baru berhasil ditambahkan.");
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Nomor Volume: ");
                                int volBaru = scanner.nextInt();
                                scanner.nextLine();
                                // Instansiasi objek Komik (Subclass)
                                daftarKoleksi[jumlahKoleksi] = new Komik(judulBaru, penulisBaru, tahunBaru, volBaru);
                                jumlahKoleksi++;
                                System.out.println("Sukses! Komik baru berhasil ditambahkan.");
                            } else {
                                System.out.println("Pilihan jenis koleksi tidak valid!");
                            }
                        } else {
                            System.out.println("Maaf, kapasitas penyimpanan koleksi penuh!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Novel & Komik ---");
                        if (jumlahKoleksi == 0) {
                            System.out.println("Belum ada koleksi yang tersimpan.");
                        } else {
                            for (int i = 0; i < jumlahKoleksi; i++) {
                                System.out.print((i + 1) + ". ");
                                // Memanggil method hasil overriding secara polimorfis
                                daftarKoleksi[i].tampilkanInfo();
                                daftarKoleksi[i].caraPinjam();
                                System.out.println("--------------------------------------------------");
                            }
                            // Memanggil variabel static
                            System.out.println("* Total Objek Koleksi Terdaftar: " + Koleksi.totalKoleksiBerhasilDibuat);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Koleksi (Overloading) ---");
                        System.out.println("1. Cari berdasarkan Judul (Teks)");
                        System.out.println("2. Cari berdasarkan Tahun Terbit (Angka)");
                        System.out.print("Pilih mode (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Judul yang dicari: ");
                            String kataKunci = scanner.nextLine();
                            cariKoleksi(kataKunci, daftarKoleksi, jumlahKoleksi); // Memanggil overloading versi String
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Tahun yang dicari: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariKoleksi(angkaKunci, daftarKoleksi, jumlahKoleksi); // Memanggil overloading versi int
                        } else {
                            System.out.println("Pilihan mode pencarian tidak valid.");
                        }
                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan Sistem Manajemen Novel & Komik!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan menu tidak valid. Silakan masukkan angka 1-4.");
                }
            }
        }
    }
}