package tugas2.pertemuan3;

public class Mobil extends Kendaraan {
    
    private String namaMobil;
    private String typeMobil;
    private String typeBahanBakar;
 
    public Mobil(){

    }

    // GET

    public String getNamaMobil(){
        return namaMobil;
    }
    public String getTypeMobil(){
        return typeMobil;
    }
    public String getTypeBahanBakar(){
        return typeBahanBakar;
    }


    // SET

    public void setNamaMobil(String nama){
        this.namaMobil = nama;
    }
    public void setTypeMobil(String typeMobil){
        this.typeMobil = typeMobil;
    }
    public void setTypeBahanBakar(String type){
        this.typeBahanBakar = type;
    }


    
    @Override
    public void tampilkanInfo(){

        System.out.println("|||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t Data Mobil ");
        System.out.println("|||||||||||||||||||||||||||||||||||||||");

        System.out.println("Kode Mobil : " + getKodeKendaraan());
        System.out.println("Merek Mobil : " + getMerk());
        System.out.println("Warna Mobil : " + getWarna());
        System.out.println("Harga Mobil : Rp. " + getHarga());
        System.out.println("Nama Mobil : " + namaMobil);
        System.out.println("Tipe Mobil : " + typeMobil);
        System.out.println("Jenis Bahan Bakar : " + typeBahanBakar);
    }
}
