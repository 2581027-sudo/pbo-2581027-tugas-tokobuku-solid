public class StrukPrinter {
    private static final int LEBAR = 41;

    public static void cetakKeranjang(String judul, Keranjang keranjang) {
        int sisa = LEBAR - judul.length() - 2;
        int kiri = sisa / 2;
        int kanan = sisa - kiri;
        System.out.println("=".repeat(kiri) + " " + judul + " " + "=".repeat(kanan));

        for (Buku b : keranjang.getIsi()) {
            System.out.println(b.getJudul() + " (" + b.getPenulis() + ")");
            System.out.println("  Harga       : " + Buku.formatRupiah(b.getHarga()));
            System.out.println("  Keterangan  : " + b.keterangan());
            System.out.println("  Harga akhir : " + Buku.formatRupiah(b.hargaAkhir()));
        }

        System.out.println("-".repeat(LEBAR));
        System.out.println("Total belanja : " + Buku.formatRupiah(keranjang.hitungTotal()));
    }

    public static void cetakPembayaran(int totalBelanja, MetodeBayar[] pilihan) {
        System.out.println("-".repeat(14) + " PEMBAYARAN " + "-".repeat(15));
        for (MetodeBayar m : pilihan) {
            System.out.printf("%-20s : %s%n", m.nama(), Buku.formatRupiah(m.totalBayar(totalBelanja)));
        }
    }
}