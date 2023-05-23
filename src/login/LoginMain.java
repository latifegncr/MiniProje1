package login;

import java.util.Scanner;

public class LoginMain {
//<--------------- Yonergeler-------------------->\\

    /*
    --->Bir siteye uye olma ve giris yapma sayfasi tasarlayiniz

        menu : Kullaniciya islem secimi icin menu gosterilir.

        uye olma(register): Kullanicidan ad-soyad, kullanici adi, email ve sifre bilgilerini aliniz.
                            Kullanici adi,email ve sifre birer listede tutulur.
                            ayni kullanici adi veya mail kabul edilmez.

        Giris(Login) : kullanici adi/email ve sifre girilir.
                       kullanici adi veya email ile bulunamazsa kayitli degil,uye olun uyarisi verilir.
                       kullanici adi/email ile ayni indekste kayitli sifre dogrulanirsa siteye giris yapilir

       email validation : bosluk icermemeli
                        : @ icermeli
                        : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                        : mailin kullanici adi kisminda (@ den once) sadece buyuk-kucuk harf,rakam yada  -._ sembolleri olabilir

        password validation : bosluk icermemeli
                            : en az 6 karakter olmalidir
                            : en az bir tane kucuk harf icermeli
                            : en az bir tane buyuk harf icermeli
                            : en az bir tane rakam icermeli
                            : en az bir tane sembol icermeli


     */
    public static void main(String[] args) {
        start();


    }

    public static void start() {
        //menuyu busan baslatir

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        int select;

        do {
            userService.showMenu();
            select=scanner.nextInt();
            switch (select) {
                case 1:
                    userService.register();
                    break;
                case 2:
                userService.login();
                    break;
                case 3:
                    System.out.println("Iyi Gunler dileriz");
                    break;
                default:
                    System.out.println("Hatali Giris Yaptiniz Yeniden Deneyiniz");

            }
            }while (select != 3) ;


        }
    }
