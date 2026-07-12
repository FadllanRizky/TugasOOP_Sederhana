package tugas.pertemuan2;

public class NilaiService {

    public double hitungNilaiAkhir(Mahasiswa mhs){

        return (mhs.getNilaiTugas()*0.20)
            +  (mhs.getNilaiUts()*0.30)
            +  (mhs.getNilaiUas()*0.40);
    }

    public String hitungGrade(double nilai){

        if(nilai >= 85 && nilai <= 100){
            return "A+";
        }
        else if(nilai >= 80 && nilai < 85){
            return "A";
        }
        else if(nilai >= 70 && nilai < 80){
            return "B";
        }
        else if(nilai >= 60 && nilai < 70){
            return "C";
        }
        else if(nilai >= 50 && nilai < 60){
            return "D";
        }
        else{
            return "E";
        }
    }

    public String statusKelulusan(double nilai){

        return nilai >= 70 ? "LULUS" : "TIDAK LULUS";
    }

    public static void Keterangan(String grade){

        switch(grade){

            case "A+" :
                System.out.println("Predikat : Sangat baik");
                break;
            case "A" :
                System.out.println("Predikat : Baik");
                break;
            case "B" :
                System.out.println("Predikat : Cukup");
                break;
            case "C" :
                System.out.println("Predikat : Kurang");
                break;
            case "D" :
                System.out.println("Predikat : Kurang sekali");
                break;
            default :
                System.out.println("Predikat : Golongan orang celaka (kalo kata bapak)");
                break;
        }
    }
}
