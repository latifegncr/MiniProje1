package busTicket;
import java.util.Scanner;
public class Ticket {
        static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {

            int km=0;
            int yas=0;
            int yolculukTipi=1;
            String plakaNumarasi= "06 QA 06";

            System.out.println("Lütfen gideceğiniz mesafeyi km olarak giriniz");
            km = input.nextInt();
            System.out.println("Lütfen yaşınızı giriniz");
            yas= input.nextInt();
            System.out.println("Lütfen yolculuk tipini giriniz.\n Sadece gidiş ise 1, gidiş-dönüş ise 2 yazınız");
            yolculukTipi = input.nextInt();

            double biletUcreti=0;

            if (km>0 && yas>0 && (yolculukTipi==1 || yolculukTipi==2)) {
                biletUcreti = km * 0.1;
                System.out.println("İndirimsiz Bilet Ücreti" + biletUcreti);

                double yasIndirimOrani =0;

                if (yas<12){
                    yasIndirimOrani =0.5;
                } else if (yas<24) {
                    yasIndirimOrani = 0.1;
                } else if (yas>65) {
                    yasIndirimOrani = 0.3;
                }
                biletUcreti -= biletUcreti * yasIndirimOrani;

                if (yolculukTipi==2){
                    biletUcreti -= biletUcreti * 0.2;
                    biletUcreti *=2;
                }
                else System.out.println("Hatalı veri girdiniz");
            }


            biletDokum(plakaNumarasi,km,yolculukTipi,biletUcreti);



        }

        private static void biletDokum(String plakaNumarasi, int km, int yolculukTipi, double biletUcreti) {
            System.out.println("===============BİLET DÖKÜM==============");
            System.out.println("Otobüsün Plaka Numarası: " + plakaNumarasi);
            System.out.println("Mesafe: "+ km+ "KM");
            System.out.println("Yolculuk Tipi: " + (yolculukTipi==1 ? "Tek Yön" : "Gidiş-Dönüş"));
            System.out.println("Bilet Ücreti: " + biletUcreti);

            slowPrint("KEYİFLİ YOLCULUKLAR DİLERİZ...", 50);


        }

        public static void slowPrint(String text, int delay){
            for (char c: text.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }


    }

