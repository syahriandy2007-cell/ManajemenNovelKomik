package com.mycompany.manajemennovelkomik;

public class Koleksi {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Variabel static untuk mencatat total objek yang berhasil dibuat
    public static int totalKoleksiBerhasilDibuat = 0;

    // Constructor menggunakan keyword this
    public Koleksi(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        setTahunTerbit(tahunTerbit); // Menggunakan setter untuk validasi
    }

    // Getter dan Setter dengan Encapsulation & Validasi
    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit > 0) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println("Tahun terbit tidak valid! Default diset ke 2026.");
            this.tahunTerbit = 2026;
        }
    }

    // Method dasar untuk info
    public void tampilkanInfo() {
        System.out.printf("Judul: %-20s | Penulis: %-15s | Tahun: %d%n", this.judul, this.penulis, this.tahunTerbit);
    }

    // Method dasar aksi pinjam (untuk di-override)
    public void caraPinjam() {
        System.out.println("Koleksi dipinjam secara fisik di meja administrasi.");
    }
}