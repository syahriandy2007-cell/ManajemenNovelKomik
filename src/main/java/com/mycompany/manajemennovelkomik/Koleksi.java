package com.mycompany.manajemennovelkomik;

public abstract class Koleksi {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public static int totalKoleksiBerhasilDibuat = 0;

    public Koleksi(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        setTahunTerbit(tahunTerbit);
        totalKoleksiBerhasilDibuat++;
    }

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

    public void tampilkanInfo() {
        System.out.printf("Judul: %-20s | Penulis: %-15s | Tahun: %d%n", this.judul, this.penulis, this.tahunTerbit);
    }

    public abstract void caraPinjam();
}