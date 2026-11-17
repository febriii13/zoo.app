import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Hewan {
    protected String nama;

    public Hewan(String nama) {
        this.nama = nama;
    }

    public abstract void makan();
    public abstract void bergerak();
    public String getNama() {
        return nama;
    }
}

interface Bersuara {
    void suara();
}

class Burung extends Hewan implements Bersuara {
    public Burung(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan biji-bijian.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " terbang di udara.");
    }

    @Override
    public void suara() {
        System.out.println(nama + " berkicau: cip cip!");
    }
}

class Ikan extends Hewan {
    public Ikan(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan plankton.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berenang di air.");
    }
}

class Kucing extends Hewan implements Bersuara {
    public Kucing(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan ikan.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan empat kaki.");
    }

    @Override
    public void suara() {
        System.out.println(nama + " mengeong: Meooong!");
    }
}

class Singa extends Hewan implements Bersuara {
    public Singa(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan daging.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berlari di padang rumput.");
    }

    @Override
    public void suara() {
        System.out.println(nama + " mengaum: Roaaar!");
    }
}

class Gajah extends Hewan implements Bersuara {
    public Gajah(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan rumput dan daun.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan langkah berat.");
    }

    @Override
    public void suara() {
        System.out.println(nama + " trompet: Paaaaawww!");
    }
}

class Ular extends Hewan {
    public Ular(String nama) {
        super(nama);
    }

    @Override
    public void makan() {
        System.out.println(nama + " makan tikus.");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " merayap di tanah.");
    }
}

public class ZooApp {
    private static List<Hewan> daftarHewan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarHewan.add(new Burung("Burung Merpati"));
        daftarHewan.add(new Ikan("Ikan Mas"));
        daftarHewan.add(new Kucing("Kucing Anggora"));
        daftarHewan.add(new Singa("Singa Afrika"));

        tampilkanSemuaHewan();

        menuInteraktif();
    }

    private static void tampilkanSemuaHewan() {
        for (Hewan hewan : daftarHewan) {
            hewan.makan();
            hewan.bergerak();
            if (hewan instanceof Bersuara) {
                ((Bersuara) hewan).suara();
            }
            System.out.println("---------------------");
        }
    }

    private static void menuInteraktif() {
        int pilihan;
        do {
            System.out.println("\n=== Menu Kebun Binatang ===");
            System.out.println("1. Tampilkan semua hewan");
            System.out.println("2. Tambah hewan baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanSemuaHewan();
                    break;
                case 2:
                    tambahHewan();
                    break;
                case 3:
                    System.out.println("Terima kasih telah mengunjungi Kebun Binatang!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
        scanner.close();
    }

    private static void tambahHewan() {
        System.out.println("\nPilih jenis hewan:");
        System.out.println("1. Burung");
        System.out.println("2. Ikan");
        System.out.println("3. Kucing");
        System.out.println("4. Singa");
        System.out.println("5. Gajah");
        System.out.println("6. Ular");
        System.out.print("Pilih (1-6): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nama hewan: ");
        String nama = scanner.nextLine();

        Hewan hewanBaru = null;
        switch (jenis) {
            case 1:
                hewanBaru = new Burung(nama);
                break;
            case 2:
                hewanBaru = new Ikan(nama);
                break;
            case 3:
                hewanBaru = new Kucing(nama);
                break;
            case 4:
                hewanBaru = new Singa(nama);
                break;
            case 5:
                hewanBaru = new Gajah(nama);
                break;
            case 6:
                hewanBaru = new Ular(nama);
                break;
            default:
                System.out.println("Jenis hewan tidak valid!");
                return;
        }

        if (hewanBaru != null) {
            daftarHewan.add(hewanBaru);
            System.out.println("Hewan " + nama + " berhasil ditambahkan!");
            hewanBaru.makan();
            hewanBaru.bergerak();
            if (hewanBaru instanceof Bersuara) {
                ((Bersuara) hewanBaru).suara();
            }
            System.out.println("---------------------");
        }
    }
}
