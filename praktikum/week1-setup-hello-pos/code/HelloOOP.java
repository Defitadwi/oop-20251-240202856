// HelloOOP.java
class Mahasiswa {
   String nama; int nim; 
   Mahasiswa(String nama, int nim) {
      this.nama = nama;
      this.nim = nim;
   }
   void sapa() { System.out.println("Hallo word, I am "+nama + ", " + nim);}
}

public class HelloOOP {
   public static void main(String[] args) {
      Mahasiswa m = new Mahasiswa ("Defita Dwi Wulandary", 240202856); 
        m.sapa(); 
       }
}