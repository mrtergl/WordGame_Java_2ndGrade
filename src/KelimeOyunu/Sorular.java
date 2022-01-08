/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KelimeOyunu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Murat <your.name at your.org>
 */
public class Sorular implements Serializable{
    File dortharf = new File("src/4Harf.txt");
    File besharf = new File("src/5Harf.txt");
    File altiharf = new File("src/6Harf.txt");
    File yediharf = new File("src/7Harf.txt");
    File sekizharf = new File("src/8Harf.txt");
    File dokuzharf = new File("src/9Harf.txt");
    File onharf = new File("src/10Harf.txt");
   
    PrintWriter yazma =null;
            
    int size =30;
    String[] dortHarfDOSYA = new String[size];// Dosyadan çekmek için kullanılacak dizi
    String[] besHarfDOSYA = new String[size];
    String[] altiHarfDOSYA = new String[size];
    String[] yediHarfDOSYA = new String[size];
    String[] sekizHarfDOSYA = new String[size];
    String[] dokuzHarfDOSYA = new String[size];
    String[] onHarfDOSYA = new String[size];
    
    String[] dortHarfcevap =new String[size];// Dosyadan çekilecek cevap için dizi
    String[] besHarfcevap =new String[size];
    String[] altiHarfcevap =new String[size];
    String[] yediHarfcevap =new String[size];
    String[] sekizHarfcevap =new String[size];
    String[] dokuzHarfcevap =new String[size];
    String[] onHarfcevap =new String[size];
    
    String[] dortHarfSoru =new String[size];// Dosyadan çekilecek soru için dizi
    String[] besHarfSoru =new String[size]; 
    String[] altiHarfSoru =new String[size];
    String[] yediHarfSoru =new String[size];
    String[] sekizHarfSoru =new String[size];
    String[] dokuzHarfSoru =new String[size];
    String[] onHarfSoru =new String[size];
 
 
   public void add(String k, String soru) throws FileNotFoundException, IOException //Soru ve kelime eklemek için fonksiyon
   {
       if (k.length()==4)
       {
           DosyayaEkle(dortharf,k,soru);
           DiziyeAta(dortharf,dortHarfDOSYA,dortHarfcevap,dortHarfSoru);
       }
       else if (k.length()==5) {
           DosyayaEkle(besharf,k,soru);
           DiziyeAta(besharf,besHarfDOSYA,dortHarfcevap,dortHarfSoru);
       }
       else if (k.length()==6) {
           DosyayaEkle(altiharf,k,soru);
           DiziyeAta(altiharf,altiHarfDOSYA,altiHarfcevap,altiHarfSoru);   
       }
       else if (k.length()==7) {
           DosyayaEkle(yediharf,k,soru);
           DiziyeAta(yediharf,yediHarfDOSYA,yediHarfcevap,yediHarfSoru);
       }
       else if (k.length()==8) {
           DosyayaEkle(sekizharf,k,soru);
           DiziyeAta(sekizharf,sekizHarfDOSYA,sekizHarfcevap,sekizHarfSoru);
       }
       else if (k.length()==9) {
           DosyayaEkle(dokuzharf,k,soru);
           DiziyeAta(dokuzharf,dokuzHarfDOSYA,dokuzHarfcevap,dokuzHarfSoru);
       }
       else if (k.length()==10) {
           DosyayaEkle(onharf,k,soru);
           DiziyeAta(onharf,onHarfDOSYA,onHarfcevap,onHarfSoru);
       }
    
   }
   
    void DosyayaEkle(File dosya,String a,String b) throws UnsupportedEncodingException, IOException //Dosyaya cevap eklemek için kullanlılan fonksiyon
   {
       try{
            yazma = new PrintWriter(new FileOutputStream(dosya,true));
       }catch(FileNotFoundException A){
            System.err.println("Dosya yok");
        }
       yazma.print(a);
       yazma.print("&");
       yazma.print(b);
       yazma.println();
       yazma.close();
       
     }
  
   void  DiziyeAta(File d,String dizi[],String cevap[],String soru[]) throws IOException // Dosyadan çekip diziye atamak için kullanılan fonk.
   {
       int i = 0;
       Scanner oku = new Scanner(d);
       while(oku.hasNext())
       {
           String satir =oku.nextLine();
           dizi[i]= satir;
           i++;
       } 
       oku.close();
       
       int sira = 0;
       int a =0;
       while(dizi[a]!=null) //Diziye atama
       {
           sira=dizi[a].indexOf('&'); // & işaretinin yeri
           soru[a]=dizi[a].substring(sira+1);
           cevap[a]=dizi[a].substring(0, sira);
           a++;
       }
   }
}
