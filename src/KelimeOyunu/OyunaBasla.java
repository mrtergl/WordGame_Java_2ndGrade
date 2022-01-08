/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KelimeOyunu;

import KelimeOyunu.YarismaciBilgisi;
import KelimeOyunu.Tercih;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;


/**
 *
 * @author Murat <your.name at your.org>
 */
public class OyunaBasla extends javax.swing.JFrame {

    /**
     * Creates new form OyunaBasla
     */
    Timer timer;
    Timer timer2;
    int san =20;
    int min =3;
    int sec =59;
    public OyunaBasla() throws IOException {
        initComponents();
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(null);
        Dakika.setText("4");
        Saniye.setText("00");
    }
    
    Sorular cevap = new Sorular();

   public void Dongu()
   {
       int puan =0;
       for (int i = 1; i < 15; i++) 
       {
           if (min==0&&sec==0) 
           {
            ImageIcon img = new ImageIcon("src/KelimeOyunu/clock.png");
            JLabel lb = new JLabel("Süre Doldu !!!");
            lb.setFont(new Font("Century Gothic",Font.BOLD,20));
            JOptionPane.showMessageDialog(this,lb,"SÜRE DOLDU !!",JOptionPane.PLAIN_MESSAGE,img);
            i=15;
           }
           else
           {
               if (i>0&&i<3) 
               {
                   Ekran.setText("");
                   EkranC.setText("");
                   Ekran.append(i+") ");
                   SoruCikar(cevap.dortHarfcevap,cevap.dortHarfSoru,puan);  
                }
                if (i>2&&i<5) 
                {
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.besHarfcevap,cevap.besHarfSoru,puan);  
                }
                if (i>4&&i<7) 
                {
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.altiHarfcevap,cevap.altiHarfSoru,puan);  
                }
                if (i>6&&i<9) 
                {
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.yediHarfcevap,cevap.yediHarfSoru,puan);  
                }
                if (i>8&&i<11) 
                {                       
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.sekizHarfcevap,cevap.sekizHarfSoru,puan);  
                }
                if (i>10&&i<13) 
                {
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.dokuzHarfcevap,cevap.dokuzHarfSoru,puan);  
                }
                if (i>12&&i<15) 
                {
                    Ekran.setText("");
                    EkranC.setText("");
                    Ekran.append(i+") ");
                    SoruCikar(cevap.onHarfcevap,cevap.onHarfSoru,puan);  
                }
           }
        }
       
   }
   
   int toplam =0; // puan toplamını tutan integer.
   
   int konum; // rastgele sayilari tutan integer.
   
   int unopenedC;
   
   int sayi=99; // gelen sorunun indexini tutmak için oluşturulan integer;
   
   boolean durum =false;
   
   void SoruCikar(String[]cevaplar, String[] sorular, int puan) //Sorulara cevap verirken tercih yapmak ve rastgele soru ve kelime çekmek için kullanılan fonk.
   {
       int index=(int)(Math.random()*cevaplar.length);
       while(cevaplar[index]==null|| sayi == index) // önceki soruyla aynı olup olmadığını ve gelen satırın boş olup olmadığını kontrol ediyor.
       {
           index=(int)(Math.random()*cevaplar.length);
       }
       sayi=index;
       
       String cevap1 = cevaplar[index];
       
       char [] kelime=new char[cevap1.length()];
       for (int i = 0; i <cevap1.length();i++) //kelimenin harflerini diziye atadık.
       {
           kelime[i]=cevap1.charAt(i);
       }
       unopenedC= cevap1.length(); // açılmamış karakterlerin saysını belirlemek için oluşturuldu. her karakter alışta -1 azalıyor.
       
       int[]dizisayi=new int[cevap1.length()];//random sayilari tutmak için bir dizi
       Arrays.fill(dizisayi, 11); // maksimum 10 harfli kelime olduğu için random gelecek sayı 11 olamaz,11 olan indeks boş demektir

       Ekran.append(sorular[index]);//Soruyu yazıdran kod
       for (int i = 0; i < cevaplar[index].length(); i++) 
       {
         EkranC.replaceSelection("_ ");
       }
       durum =false;
       while(durum !=true )
       {
           Tercih a = new Tercih(this,true); //Tercih ekranı
           a.setVisible(true);
           int result = a.getReturnStatus();
            
           if (result==1) //harf al basıldığında
           {
              if (unopenedC>1) 
               {
                   EkranC.setText("");
                   unopenedC--; // açılan her harfte puan düşmek için...
                   konum = (int)(Math.random()*cevap1.length());

                   TekrarKontrol(dizisayi,konum,cevap1); // sayi tekrar ediyorsa yeni random üreten fonk.

                   dizisayi[konum]=konum;// tekrar etmeyen rastgele sayıyı diziye atama

                   for (int i=0; i< kelime.length;i++) 
                   {
                     if (dizisayi[i]!=11) {
                        EkranC.replaceSelection(kelime[dizisayi[i]]+" ");
                       }
                       else
                          EkranC.replaceSelection("_ ");
                    }
               }
               else
               {
                   unopenedC--; // açılan her harfte puan düşmek için...
                   KazanP.setText("Cevap: "+cevap1+"\nPuan kazanamadınız !!!");
                   Puan.setText("");
                   Puan.replaceSelection(Integer.toString(toplam));
                   durum=true;
               }
           }
           else if(result==2)//cevap ver basıldığında
           {
               timer.stop();
               timer2 = new Timer(1000,new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                  san--;
                   if (san==0) {
                       timer2.stop();
                   }
               }
               });
               timer2.start(); // 20 saniye sayaç başlıyor
               while(durum !=true ||timer2.isRunning())
               {
                   if (!timer2.isRunning()) 
                   {
                    ImageIcon img = new ImageIcon("src/KelimeOyunu/clock.png");
                    JTextArea lb = new JTextArea("Süre Doldu !!"
                            + "\nBu Soru İçin Cevap Veremezsiniz!!"
                            + "\n"
                            + "\nCevap:"+cevap1);
                    lb.setBorder(null);
                    lb.setBackground(new Color(215,215,217));
                    lb.setFont(new Font("Century Gothic",Font.BOLD,20));
                    getContentPane().setBackground(Color.DARK_GRAY);
                    JOptionPane.showMessageDialog(this,lb,"SÜRE DOLDU !!",JOptionPane.PLAIN_MESSAGE,img);
                    durum = true;
                    puan =(100*cevap1.length());
                    toplam = toplam-puan;
                   }
                   else
                   {
                       CevapVer f = new CevapVer(this,true);
                       f.setVisible(true);
                       String answer = f.txt.getText().toUpperCase();
                       if (cevap1.equals(answer)) // girilen cevaplar doğruysa puan ver ve sonraki soruya geçmek için döngüden çık
                       {
                          timer2.stop();
                          puan =(100*unopenedC);
                          durum=true;
                          
                          KazanP.setText("");
                          EkranC.setText(cevap1);
                          SoruGeçme S = new SoruGeçme(this,true);
                          S.Durum.setText("Tebrikler !!!");
                          S.PuanK.setText("Kazanılan puan: "+puan);
                          S.setVisible(true);
                          S.getReturnStatus();
                       }
                       else
                           KazanP.setText("Verdiğiniz Cevap Yanlış\n"
                                   + "Tekrar Deneyin");
                       
                       toplam =toplam+puan;
                   }
               }
            }
       }
       san=20;
       Puan.setText(Integer.toString(toplam));
       konum =0;
       timer.start();
   }
   
   public int TekrarKontrol(int dizi[],int a,String o) // Tekrar eden rastgele sayı varsa yeni sayi üretir ve onu kontrol eder. 
   {
       
       for (int x :dizi) 
       {
           while(x==a) 
           {
               a = (int)(Math.random()*o.length());
               return TekrarKontrol(dizi,a,o);
           }
       }
       konum=a;
       return 0;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EkranC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ekran = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        AdSoyadBasla = new javax.swing.JButton();
        İsimSoyisimL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Puan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        KazanP = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        Dakika = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Saniye = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("KELİME OYUNU");
        setLocation(new java.awt.Point(240, 170));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KELİME OYUNU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Elephant", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        EkranC.setEditable(false);
        EkranC.setBackground(new java.awt.Color(51, 51, 51));
        EkranC.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        EkranC.setForeground(new java.awt.Color(255, 255, 255));
        EkranC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EkranC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KELİME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        Ekran.setBackground(new java.awt.Color(51, 51, 51));
        Ekran.setColumns(1);
        Ekran.setFont(new java.awt.Font("Century Gothic", 2, 20)); // NOI18N
        Ekran.setForeground(new java.awt.Color(255, 255, 255));
        Ekran.setLineWrap(true);
        Ekran.setRows(2);
        Ekran.setAutoscrolls(false);
        Ekran.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SORU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        Ekran.setMaximumSize(new java.awt.Dimension(16, 60));
        jScrollPane1.setViewportView(Ekran);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Adınızı ve Soyadınızı yazarak oyuna başlayabilirsiniz*");

        AdSoyadBasla.setBackground(new java.awt.Color(255, 0, 0));
        AdSoyadBasla.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        AdSoyadBasla.setForeground(new java.awt.Color(255, 255, 255));
        AdSoyadBasla.setText("Oyuna Başla");
        AdSoyadBasla.setBorderPainted(false);
        AdSoyadBasla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdSoyadBaslaActionPerformed(evt);
            }
        });

        İsimSoyisimL.setBackground(new java.awt.Color(51, 51, 51));
        İsimSoyisimL.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        İsimSoyisimL.setForeground(new java.awt.Color(255, 255, 255));
        İsimSoyisimL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ad Soyad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        İsimSoyisimL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                İsimSoyisimLActionPerformed(evt);
            }
        });
        İsimSoyisimL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                İsimSoyisimLKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOPLAM PUAN:");

        Puan.setEditable(false);
        Puan.setBackground(new java.awt.Color(51, 51, 51));
        Puan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Puan.setForeground(new java.awt.Color(255, 255, 255));
        Puan.setToolTipText("");
        Puan.setBorder(null);
        Puan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuanActionPerformed(evt);
            }
        });

        KazanP.setEditable(false);
        KazanP.setBackground(new java.awt.Color(51, 51, 51));
        KazanP.setColumns(20);
        KazanP.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        KazanP.setForeground(new java.awt.Color(255, 255, 255));
        KazanP.setLineWrap(true);
        KazanP.setRows(2);
        KazanP.setBorder(null);
        KazanP.setFocusable(false);
        jScrollPane2.setViewportView(KazanP);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Süre", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Elephant", 2, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        Dakika.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        Dakika.setForeground(new java.awt.Color(255, 255, 255));
        Dakika.setText("0");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        Saniye.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        Saniye.setForeground(new java.awt.Color(255, 255, 255));
        Saniye.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Dakika, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Saniye)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Dakika)
                .addComponent(jLabel6)
                .addComponent(Saniye))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(İsimSoyisimL, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(AdSoyadBasla, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Puan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1026, 1026, 1026))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(EkranC, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(İsimSoyisimL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdSoyadBasla, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EkranC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Puan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuanActionPerformed

    }//GEN-LAST:event_PuanActionPerformed

    private void İsimSoyisimLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_İsimSoyisimLKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            try {
                File oyuncular = new File("src/Oyuncular.txt");
                Date simdikiZaman = new Date();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy - kk:mm");
                cevap.DiziyeAta(cevap.dortharf,cevap.dortHarfDOSYA,cevap.dortHarfcevap,cevap.dortHarfSoru);
                cevap.DiziyeAta(cevap.besharf,cevap.besHarfDOSYA,cevap.besHarfcevap,cevap.besHarfSoru);
                cevap.DiziyeAta(cevap.altiharf,cevap.altiHarfDOSYA,cevap.altiHarfcevap,cevap.altiHarfSoru);
                cevap.DiziyeAta(cevap.yediharf,cevap.yediHarfDOSYA,cevap.yediHarfcevap,cevap.yediHarfSoru);                 // Girilen ve dosyada olan soruları okutup diziye atıyor.
                cevap.DiziyeAta(cevap.sekizharf,cevap.sekizHarfDOSYA,cevap.sekizHarfcevap,cevap.sekizHarfSoru);
                cevap.DiziyeAta(cevap.dokuzharf,cevap.dokuzHarfDOSYA,cevap.dokuzHarfcevap,cevap.dokuzHarfSoru);
                cevap.DiziyeAta(cevap.onharf,cevap.onHarfDOSYA,cevap.onHarfcevap,cevap.onHarfSoru);
                
                if (İsimSoyisimL.getText().isEmpty()) {
                    JLabel lbl=new JLabel("Lütfen Adınızı Girin !!!");
                    lbl.setFont(new Font("Century Gothic",Font.BOLD,18));
                    JOptionPane.showMessageDialog(null,lbl,"HATA",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    String isimSoyisim = İsimSoyisimL.getText().trim().toUpperCase();
                    timer = new Timer(1000,new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (min==0&&sec==0) {
                                Saniye.setText("0"+String.valueOf(sec));
                                Dakika.setText(String.valueOf(min));
                                timer.stop();
                                durum =true;
                            }
                            else
                            {
                                if (sec==0) {
                                    sec =59;
                                    min--;
                                }
                                if (sec<10) {
                                    Saniye.setText("0"+String.valueOf(sec));
                                }
                                else
                                    Saniye.setText(String.valueOf(sec));
                                
                                Dakika.setText(String.valueOf(min));
                                sec--;
                            }
                        }
                    });
                    timer.start();
                    Dongu();
                    timer.stop();
                    YarismaciBilgisi Bilgi = new YarismaciBilgisi(this,true);
                    
                    Bilgi.AdSoyadBilgi.setText(isimSoyisim);
                    Bilgi.PuanB.setText(String.valueOf(toplam));
                    Bilgi.SüreB.setText(String.valueOf(Dakika.getText())+":"+String.valueOf(Saniye.getText()));
                    Bilgi.SaatB.setText(String.valueOf(df.format(simdikiZaman)));
                    this.dispose();
                    Bilgi.setVisible(true);
                    try
                    {
                        PrintWriter yazdir = new PrintWriter(new FileOutputStream(oyuncular,true));
                        yazdir.println("\t"+isimSoyisim+"\t\t"+toplam+"\t\t"+Dakika.getText()+":"+Saniye.getText()+"\t\t"+df.format(simdikiZaman));
                        yazdir.close();
                    }catch(FileNotFoundException A){
                        System.err.println("Dosya yok");
                    }
                }   } catch (IOException ex) {
                Logger.getLogger(OyunaBasla.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }//GEN-LAST:event_İsimSoyisimLKeyPressed

    private void İsimSoyisimLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_İsimSoyisimLActionPerformed

    }//GEN-LAST:event_İsimSoyisimLActionPerformed

    private void AdSoyadBaslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdSoyadBaslaActionPerformed
        try {
            File oyuncular = new File("src/Oyuncular.txt");
            Date simdikiZaman = new Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy - kk:mm");
            cevap.DiziyeAta(cevap.dortharf,cevap.dortHarfDOSYA,cevap.dortHarfcevap,cevap.dortHarfSoru);
            cevap.DiziyeAta(cevap.besharf,cevap.besHarfDOSYA,cevap.besHarfcevap,cevap.besHarfSoru);
            cevap.DiziyeAta(cevap.altiharf,cevap.altiHarfDOSYA,cevap.altiHarfcevap,cevap.altiHarfSoru);
            cevap.DiziyeAta(cevap.yediharf,cevap.yediHarfDOSYA,cevap.yediHarfcevap,cevap.yediHarfSoru);               // Girilen ve dosyada olan soruları okutup diziye atıyor.
            cevap.DiziyeAta(cevap.sekizharf,cevap.sekizHarfDOSYA,cevap.sekizHarfcevap,cevap.sekizHarfSoru);
            cevap.DiziyeAta(cevap.dokuzharf,cevap.dokuzHarfDOSYA,cevap.dokuzHarfcevap,cevap.dokuzHarfSoru);
            cevap.DiziyeAta(cevap.onharf,cevap.onHarfDOSYA,cevap.onHarfcevap,cevap.onHarfSoru);
            
            if (İsimSoyisimL.getText().isEmpty()) {
                JLabel lbl=new JLabel("Lütfen Adınızı Girin !!!");
                lbl.setFont(new Font("Century Gothic",Font.BOLD,18));
                JOptionPane.showMessageDialog(null,lbl,"HATA",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String isimSoyisim = İsimSoyisimL.getText().trim().toUpperCase();
                timer = new Timer(1000,new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (min==0&&sec==0) {
                            Saniye.setText("0"+String.valueOf(sec));
                            Dakika.setText(String.valueOf(min));
                            timer.stop();
                            durum =true;
                        }
                        else
                        {
                            if (sec==0) {
                                sec =59;
                                min--;
                            }
                            if (sec<10) {
                                Saniye.setText("0"+String.valueOf(sec));
                            }
                            else
                                Saniye.setText(String.valueOf(sec));
                            
                            Dakika.setText(String.valueOf(min));
                            sec--;
                        }
                    }
                });
                timer.start();
                Dongu();
                timer.stop();
                YarismaciBilgisi Bilgi = new YarismaciBilgisi(this,true);
                
                Bilgi.AdSoyadBilgi.setText(isimSoyisim);
                Bilgi.PuanB.setText(String.valueOf(toplam));
                Bilgi.SüreB.setText(String.valueOf(Dakika.getText())+":"+String.valueOf(Saniye.getText()));
                Bilgi.SaatB.setText(String.valueOf(df.format(simdikiZaman)));
                this.dispose();
                Bilgi.setVisible(true);
                try
                {
                    PrintWriter yazdir = new PrintWriter(new FileOutputStream(oyuncular,true));
                    yazdir.println("\t"+isimSoyisim+"\t\t"+toplam+"\t\t"+Dakika.getText()+":"+Saniye.getText()+"\t\t"+df.format(simdikiZaman));
                    yazdir.close();
                }catch(FileNotFoundException A){
                    System.err.println("Dosya yok");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(OyunaBasla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AdSoyadBaslaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OyunaBasla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OyunaBasla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OyunaBasla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OyunaBasla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new OyunaBasla().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(OyunaBasla.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdSoyadBasla;
    private javax.swing.JLabel Dakika;
    private javax.swing.JTextArea Ekran;
    private javax.swing.JTextField EkranC;
    private javax.swing.JTextArea KazanP;
    private javax.swing.JTextField Puan;
    private javax.swing.JLabel Saniye;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField İsimSoyisimL;
    // End of variables declaration//GEN-END:variables
}
