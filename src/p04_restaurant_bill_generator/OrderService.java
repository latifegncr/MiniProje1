package p04_restaurant_bill_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner input = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>();

    //11.AdımSipariş Oluşturma
    public void createOrder(DishService dishService) {//parametre DishService objesi olacak
        int dishCode;
        do {
            System.out.println("Lütfen Ürün kodunu giriniz: (Çokış için 0 giriniz!) ");
            dishCode = input.nextInt();//codee ile ürünü bulacağız--> 12.Adım DishServise yemek bulma metodu gireceğiz.
            if (dishService.findByDishCode(dishCode) != null) {//ürün bulundu dmektir
                Dish dish = dishService.findByDishCode(dishCode);//bulunan yemeği oluştur.
                System.out.println("Sipariş adedi giriniz");
                int numberOfOrder = input.nextInt();
                //bu yemek daha önce sipariş edilmişmi?-->13.Adım Aşğıda
                Order order;//bu satır if deki order için deklare edildi
                if (findByOrderByDish(dish) != null) {//güncelleme yapıyoruz siparişde
                    order = findByOrderByDish(dish);
                    order.numberOfDish += numberOfOrder;
                    order.setPrice();
                } else {//yeni sipariş oluşturuldu
                    order = new Order(dish, numberOfOrder);//Order code otomatik olarak oluşturuldu
                    order.setPrice();
                    this.orderList.add(order);//sipariş listesine ekleme yapıldı
                }
            }//sİPARİŞ LİSTESİ OLUŞUNCA ALTTA SİPARİŞ LİSTESİNİ GÖRÜNTÜLEYELİM
            listOrder();//14. adım extract method yaparak oluşturuldu.

        } while (dishCode != 0);
    }


    private void listOrder() {//14. Adım:Siparişleri Listeleme metodu
        this.orderList.
                forEach(order -> System.out.printf("Sipariş Kodu :%-5s Lezzet Kou :%-4s Lezzet Adı :%-15s Adet =%-2s\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish));//lambda kullanılarak yapıldı.
    }

    //13.Adım: dish bilgisi ile sipariş bulma
    private Order findByOrderByDish(Dish dish) {
        for (Order order : this.orderList) {
            if (order.dish.equals(dish)) {
                return order;
            }
        }
        return null;
    }
    public void deleteOrder() {
        System.out.println("İptal etmek istediğiniz siparişn kodunu giriniz:");
        int code = input.nextInt();
        boolean isValid=true;
        for (Order order : this.orderList) {
            if (order.orderCode == code) {
                System.out.println("iptal etmek istediğiniz miktaı giriniz:");//3 urfa
                int numCancel = input.nextInt();
                if (order.numberOfDish > numCancel) {
                    order.numberOfDish -= numCancel;
                    order.setPrice();
                    System.out.println(numCancel + " adet siparişiniz iptal edilmiştir.\n" +
                            "İptal edilen sipariş : "+order.dish.getName());
                } else if (order.numberOfDish == numCancel) {
                    this.orderList.remove(order);
                    System.out.println("Tüm siparişiniz iptal edilmiştir");
                } else {
                    System.out.println("Hatalı Giriş!!!\nSipariş miktarından fazla iptal işlemi yapılamaz!!!");
                }
                isValid = true;
                break;
            } else {
                isValid = false;
            }
        }
        if (!isValid){
            System.out.println("Hatalı sipariş kodu girdiniz!!!\nYazılan sipariş kodu mevcut sipariş listenizde bulunmamaktadır ");
        }

    }

    public void printBill() {
        double total = 0;
        System.out.println("          QA06 Lezzet Fişiniz              ");
        System.out.println("-------------------------------------------");
        for (Order order:this.orderList) {
            System.out.printf("Sipariş Kodu :%-6s Lezzet Kodu :%-4s Lezzet Adı :%-15s Adet :%-2s Tutar :%-6s Lira\n",
                    order.orderCode,order.dish.getCode(),order.dish.getName(),order.numberOfDish,order.orderPrice);
            total+=order.orderPrice;
        }
        System.out.println("               Toplam Tutar              ");
        System.out.println("-----------------------------------------");
        System.out.println("                "+total+"                ");
        System.out.println("-----------------------------------------");
        System.out.println("           !!! Afiyet Olsun !!!          ");
        this.orderList.clear();//yeni siparişler için order list temizlendi

    }
}

