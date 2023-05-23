package login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserService {

    List<String> usernameList = new ArrayList<>(); //indekse ihtiyac oldugu icin list kullanilir.//bu listler sadece burada kullanilir
    List<String> emailList = new ArrayList<>();
    List<String> passwordList = new ArrayList<>();

    //menuyu gosteren  method
public void showMenu() {
        System.out.println("===TECHPROEDUCATION====");
        System.out.println("1-uye ol");
        System.out.println("2-Giris Yap");
        System.out.println("3-Cikis");
        System.out.println("Seciminiz: ");
    }

    /*
     Giris(Login) :    kullanici adi/email ve sifre girilir.

                       kullanici adi veya email ile bulunamazsa kayitli degil,uye olun uyarisi verilir.

                       kullanici adi/email ile ayni indekste kayitli sifre dogrulanirsa siteye giris yapilir
     */
public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ad-Soyad :");//iste tutulmayacak giriste kontrol edilen olmadigi icin
        String name = scanner.nextLine();

        String username;

        boolean existUsername;//
        do {
            System.out.println("Kullanici adini giriniz");
            username = scanner.nextLine();
            existUsername = usernameList.contains(username);

            if (existUsername) {
                System.out.println("Bu UserName daha once kullanilmistir.Yeni bir UserName deneyiniz");
            }
        } while (existUsername);



        String email;
        boolean isValid;//gerekli kosul uygun mu kontrol
        boolean existEmail;//liste var kontrolu icin
        do {
            System.out.println("Email Giriniz");
            email = scanner.nextLine().trim();
            isValid =validateEmail(email);
            existEmail = emailList.contains(email);

            if (existEmail) {
                isValid = false;
                System.out.println("Bu email daha once kullanilmistir.Yeni bir email deneyiniz");
            }
            // isValid=scanner.nextLine().contains()
        } while (!isValid);


        String password;
        boolean isValidPsw;
        do{
            System.out.println("sifre giriniz");
            password=scanner.nextLine();
            isValidPsw=validatePassword(password);

        }while(!isValidPsw);



        User user=new User(name,username,email,password);
        usernameList.add(username);
        emailList.add(email);
        passwordList.add(password);

        System.out.println(user);
    System.out.println("Tebrikler Kayit isleminiz gerceklestirilmistir.");
    System.out.println("Kullanici adi veya email ve sifre ile sisteme giris yapabilirsiniz");
    }


    public void login () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanici adi veya email giriniz");
        String usernameOremail = scanner.nextLine();

        boolean isEMail = emailList.contains(usernameOremail);
        boolean isUsername = usernameList.contains(usernameOremail);

        if (isEMail || isUsername) {

            while(true){
                System.out.println("Sifrenizi giriniz");
                String password = scanner.nextLine();
                int idx;
                if (isUsername) {
                    idx = usernameList.indexOf(usernameOremail);
                } else {
                    idx = emailList.indexOf(usernameOremail);
                }
                if (passwordList.get(idx).equals(password)) {
                    System.out.println("Sisteme giris yaptiniz");
                    break;
                }else{
                    System.out.println("Sifreniz yanlis.Tekrar deneyiniz.");
                }

            }

        }else {
            System.out.println("Sisteme kayitli kullanici bulunamadi");
            System.out.println("Bilgileri Kontrol ediniz yada uye olunuz");
        }

    }



public static boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");
        if (space) {
            System.out.println("email bosluk iceremez");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("email '@' icermelidir");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean checkStart = firstPart.replaceAll("[a-zA-Z0-9._-]", "").length() == 0;
            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("yahoo.com") ||
                    secondPart.equals("hotmail.com");

            if (!checkStart) {
                System.out.println("Email kucuk harf,buyuk harf,rakam ve _.- bunlar disinda karakter iceremez");
            } else if (!checkEnd) {
                System.out.println("email'gmail.com,hotmail.com veya hotmail.com ile bitmeli'");
            }
            isValid= checkEnd && checkStart;
            }
        return isValid;
        }

    public static boolean validatePassword(String password) {
        boolean isValid;

        boolean space = password.contains(" ");
        boolean lenghtGt6 = password.length() >= 6;
        boolean existUpper = password.replaceAll("[^A-Z]", "").length() > 0;
        boolean existLower = password.replaceAll("[^a-z]", "").length() > 0;
        boolean existDigit = password.replaceAll("[^0-9]", "").length() > 0;//[\\D]
        boolean existSymbol = password.replaceAll("[\\P{Punct}]", "").length() > 0;

        if (space) {
            System.out.println("Sifre bosluk iceremez");
        } else if (!lenghtGt6) {
            System.out.println("sifre en az 6 karakter icermelidir ");
        } else if (!existUpper) {
            System.out.println("Sifre en az 1 buyuk harf icermelidir");
        } else if (!existLower) {
            System.out.println("Sifre en az 1 kucuk harf icermelidir");
        } else if (!existDigit) {
            System.out.println("Sifre en az 1 rakam icermelidir");
        } else if (!existSymbol) {
            System.out.println("Sifre en az 1 sembol icermelidir");

        }

        isValid=!space && lenghtGt6 && existUpper && existLower && existDigit && existSymbol;
        if(!isValid){
            System.out.println("Tekrar deneyiniz");

        }
        return isValid;
    }

    }
