package com.mycompany.manajemennovelkomik;

public class Novel extends Koleksi {
    private String genre;

    public Novel(String judul, String penulis, int tahunTerbit, String genre) {
        super(judul, penulis, tahunTerbit); // Memanggil constructor superclass
        this.genre = genre;
        Koleksi.totalKoleksiBerhasilDibuat++; // Increment counter static
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[NOVEL]       Judul: %-15s | Penulis: %-12s | Tahun: %d | Genre: %s%n", 
                getJudul(), getPenulis(), getTahunTerbit(), this.genre);
    }

    @Override
    public void caraPinjam() {
        System.out.println("-> Info Pinjam: Novel dapat dipinjam maksimal 7 hari di rak fiksi.");
    }
}