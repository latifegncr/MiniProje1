package P01_login;
//<---------------Gerekli Yonergeler-------------------->\\

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
                    : mailin kullanici adi kisminda (@ den once) sadece buyuk-kucuk harf,rakam yada -._ sembolleri olabilir

    password validation : bosluk icermemeli
                        : en az 6 karakter olmalidir
                        : en az bir tane kucuk harf icermeli
                        : en az bir tane buyuk harf icermeli
                        : en az bir tane rakam icermeli
                        : en az bir tane sembol icermeli


 */


public class   User {

    private  String name;
    private  String username;
    private  String email;
    private  String password;

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        //DEFAULT CONSTRACTOR YENI BIR DEGER ATAMADAN
        //PARAMETRESIZ OBJE OLUSTURMAK ICIN KULLANILIR
        // ZORUNLU DEGIL BU PROJE ICIN OGRENMEK AMACLI
        // HERHANGI BIR OBJE OLUSTURMADANDA GET VE SET ILE GETIREBILIRIM
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {//NASII GOSTERILMESINI ISTIYORSAK OYLE DEGISTIREBILIRIZ
        return "UserService{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
