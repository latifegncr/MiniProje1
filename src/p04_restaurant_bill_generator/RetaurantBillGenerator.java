package p04_restaurant_bill_generator;
/*
    Proje: Restaurant fiş üretim uygulaması (Bill Generator).

            1- Bir restaurantın online sipariş sisteminde hesabı yazdıran
               uygulama tasarlayınız
            2- Restauranttaki yiyecekler bir liste tutulsun
               yiyeceklerin kodu,ismi ve ücreti olsun
            3- Yiyecek menüsü sipariş oluşturma iptal ve hesap oluşturma
               için seçim menüsü gösterilsin
            4- Yiyecek listedeki yiyecekler menü şeklinde listelensin
               Sipariş girme: Yiyeceğin kodu ve istenilen adet girilerek
               sipariş oluşturulsun her sipariş için kod üretilsin
               (başlangıç 1000 artarak devam eder)
               Her bir yiyecek siparişi için tutar hesaplansın


             Sipariş iptal : Sipariş kodu girilerek sipariş silinsin
             Hesap oluşturma : Tutarları ile birlikte tüm siparişleri
                               ve toplam tutarı gösteren bir hesap fişi yazdırılsın
 */

import java.util.Scanner;

public class RetaurantBillGenerator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DishService dishService=new DishService();
        OrderService orderService=new OrderService();
        int select=-1;
        while(select!=0) {
            System.out.println("-------------------------------------------------------");
            System.out.println("***           Lezzet-i Âla QA06 Restaurant          ***");
            System.out.println("***                    HOŞGELDİNİZ                  ***");
            System.out.println("-------------------------------------------------------");
            System.out.println("***                Sipariş Uygulaması               ***");
            System.out.println("-------------------------------------------------------");
            System.out.println("1- Menü");
            System.out.println("2- Sipariş Gir");
            System.out.println("3- Siparişi İptal Et");
            System.out.println("4- Hesap Oluştur");
            System.out.println("0- Çıkış");
            System.out.println("-------------------------------------------------------");
            System.out.println("İşlem Yapmak İçin Bir Değer Giriniz");
            System.out.println("-------------------------------------------------------");
            System.out.println("Seçiminiz :");
            select=input.nextInt();
            switch (select){
                case 1:
                   dishService.showMenu();
                    break;
                case 2:
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    orderService.deleteOrder();
                    break;
                case 4:
                    orderService.printBill();
                case 0:
                    System.out.println("İyi Günler...");
                    break;
                default:
            }
        }

    }
}
