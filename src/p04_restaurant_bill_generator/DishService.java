package p04_restaurant_bill_generator;

import java.util.ArrayList;
import java.util.List;

public class DishService {
    private List<Dish> dishList=new ArrayList<>();

    public DishService(){
        Dish dish1=new Dish(100,"Adana Kebabı",220.00);
        Dish dish2 = new Dish(101, "Urfa Kebabı", 200.00);
        Dish dish3 = new Dish(102, "Çökertme Kebabı", 200.00);
        Dish dish4 = new Dish(200, "Baklava", 100.00);
        Dish dish5 = new Dish(201, "Kadayıf", 85.00);
        Dish dish6 = new Dish(202, "Künefe", 75.00);
        Dish dish7 = new Dish(300, "Yayık Ayran", 30.00);
        Dish dish8 = new Dish(301, "Kola", 35.00);
        Dish dish9 = new Dish(302, "Çay", 15.00);
        Dish dish10 = new Dish(303, "Su", 7.50);
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);

    }

    public void showMenu() {
        System.out.println("----------------------------------------");
        System.out.println("         *** Lezzetlerimiz ***          ");
        System.out.println("----------------------------------------");
        System.out.printf("%-3s    %-20s   %-6s    \n", "Kod", "     Adı     ", "     Fiyat ");//tablo başlığı
        System.out.printf("%-3s    %-20s   %-6s    \n", "---", "-------------", "-------------");//tablo ayraçı
        for (Dish dish : this.dishList) {
            System.out.printf("%-3s    %-20s   %-5s Lira\n", dish.getCode(), dish.getName(), dish.getPrice());// "\n" alt satıra gitmesi için
        }

    }
    public Dish findByDishCode(int code){
        if (code==0){
            System.out.println("Ana Menüye yönlendiriliyorsunuz");//zaten çıkış işlemi gerçekleştirilecek
        }else {
            for (Dish dish:this.dishList) {
                if (dish.getCode()==code){
                    return dish;
                }
            }
            System.out.println("Ürün Bulunamadı");//for ile yemek getirilemez ise bu mesaj yazılacak return ederse bu mesaj yazılmadan metod bitecek.
        }

        return null;
    }

}
