package tugas2.pertemuan3;

public class Motor extends Kendaraan {

    private String namaMotor;
    private String typeMotor;
    private String typeBahanBakar;

    public Motor() {

    }

    public String getNamaMotor() {
        return namaMotor;
    }

    public String getTypeMotor() {
        return typeMotor;
    }

    public String getTypeBahanBakar() {
        return typeBahanBakar;
    }

    public void setNamaMotor(String namaMotor) {
        this.namaMotor = namaMotor;
    }

    public void setTypeMotor(String typeMotor) {
        this.typeMotor = typeMotor;
    }

    public void setTypeBahanBakar(String typeBahanBakar) {
        this.typeBahanBakar = typeBahanBakar;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("|||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t Data Motor ");
        System.out.println("|||||||||||||||||||||||||||||||||||||||");

        System.out.println("Kode Motor : " + getKodeKendaraan());
        System.out.println("Merek Motor : " + getMerk());
        System.out.println("Warna Motor : " + getWarna());
        System.out.println("Harga Motor : Rp. " + getHarga());
        System.out.println("Nama Motor : " + namaMotor);
        System.out.println("Tipe Motor : " + typeMotor);
        System.out.println("Jenis Bahan Bakar : " + typeBahanBakar);
    }

}
