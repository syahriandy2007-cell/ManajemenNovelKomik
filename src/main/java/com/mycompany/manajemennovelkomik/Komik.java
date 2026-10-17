package com.mycompany.manajemennovelkomik;

public class Komik extends Koleksi implements DapatDipinjam {
    private int volume;

    public Komik(String judul, String penulis, int tahunTerbit, int volume) {
        super(judul, penulis, tahunTerbit);
        setVolume(volume);
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            this.volume = 1;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[KOMIK]        Judul: %-15s | Penulis: %-12s | Tahun: %d | Vol  : %d%n", 
                getJudul(), getPenulis(), getTahunTerbit(), this.volume);
    }

    @Override
    public void caraPinjam() {
        System.out.println("   -> Info Pinjam: Komik wajib dibaca di tempat atau dipinjam 3 hari.");
    }

    @Override
    public void prosesPinjamFisik() {
        System.out.println("   -> [PROSES PERPUS] Komik diverifikasi kelengkapan halamannya sebelum dipinjam.");
    }
}