
/**Yorum Satırına Aldıklarım Hatalı Uygulamadır Dikkate Almayınız */


/**AOP */
//AOP nedir? Neden kullanmalıyız ?
//Kullandığımız yazılım dilleri sadece tek yazılım geliştirme yaklaşımını desteklemez.
//Birden fazla yaklaşımı uygulayarak kolay, kullanılabilir, esnek, okunabilir, çok kafa yormayan, bakımı kolay kod yazabilmemizi 
//amaçlar. 
//Object Oriented Programming (OOP) tabanlı dillerde yapılan işler davranışlarına göre sınıflara, paketlere ayrılarak yönetmeyi 
//amaçlar. Fakat bu sınıflar arasında yapılan bazı işler davranışsal olarak birbirine benzeme eğilimindedir.
//Örnek vermek gerekirse veritabanı işlemlerinden sorumlu olan paketimiz içinde log tutma ihtiyacı duyuyorken network işlemlerinden sorumlu olan paketimizde log tutma ihtiyacı duyabiliyoruz. İki pakette de böyle bir ihtiyacın olması davranışsal olarak benzer işlerin yapılmasına neden olur. OOP, Separation of Concerns’i (ilgi-davranışların ayrılmasını) amaçlamasına rağmen bu gibi durumlarda isteklerimize cevap vermemektedir. 
//AOP bu gibi problemlerde OOP’yi tamamlayan bir teknik olarak karşımıza çıkar. En çok ;
//Kayıt tutma (Logging)
//Doğrulama (Validation)
//Ön bellekleme (Caching)
//Hata Ayıklama (Exception Handling)
//Yetkilendirme (Authorizing)
//Performans Yönetimi
//Transaction Yönetimi
//Pooling
//gibi işlemlerinde AOP’i kullanabiliyoruz.


/** LOOSELY COUPLED */

// Insan denilen class, construction aşamasında IBesin adı verilen interface’e
// ihtiyaç duyuyor. Bu interface “TemelBesinOgeleriniSagla()” adlı bir
// fonksiyonaliteye sahip ve bu interface’in implement edildiği herhangi bir
// class, bu fonksiyonu sahip olduğu özelliklerle zenginleştiriyor. En
// nihayetinde Insan, bu fonksiyonu çağırıp ihtiyaçlarını karşılayabiliyor.
// https://medium.com/@selcukusta/sen-loosely-coupled-iken-yaz%C4%B1l%C4%B1m%C4%B1n-neden-olmas%C4%B1n-50bf9ef7ccd1
// https://medium.com/@hakanyucel/javascript-ve-aspect-oriented-programming-a4fdecc7c91b

/** REFERANS TİPLERİ */
//Değer Tipleri: “int”, “long”, “float”, “double”, “decimal”, “char”, “bool”, “byte”, “short”, “struct”, “enum”
// Referans Tipleri: “string”, “object”, “class”, “interface”, “array”, “delegate”, “pointer”
// C#’da Değer Tipleri ve Referans Tipler olarak iki veri tipi vardır. Bu veri
// tiplerini ayıran özellik ise bellekte tutulma şekilleridir. C# belleği iki
// bölge olarak kullanır. Bunlardan biri Stack(Yığın) diğeri ise Heap(Öbek)’dir.
// Stack Heap’den daha hızlıdır. Peki bu Değer ve Referans tipler, bahsettiğimiz
// belleği nasıl kullanıyor, hemen bakalım.
// değer tipindeki veri tipleri ile bir değişken tanımlandığında değişkenin
// değeri Stack adı verilen bellek bölgesinde tutulur.
//Referans tipindeki veri tipinde bir değişken tanımlandığında ise değişkenin değeri Heap bölgesinde ve Heap bölgesindeki değeri gösteren adres değeri ise Stack bölgesinde tutulur. Referans tipindeki bir değişkene bellekte yer ayırırken de “new” anahtar kelimesi kullanılır.
//Kabaca yukarıda bahsettiklerimi örnek üzerinde anlatmak gerekirse;
//int a = 2; //stack’de a değişkeni için yer açıldı ve değeri 2 atandı
//int b = a; //stack’de b değişkeni için yer açıldı ve değeri a’nın değeri //olan atandı (klonlandı)
//Bu durumda çıktı:
//a= 2 ve b=2 olur
//a=3; //bu durumda sadece b’nin değeri değişir.
//Bu duumda çıktı:
//a=3 ve b=2 olur
//Bu işlemde b’nin a’nın değerinin değişmesinden etkilenmemesinin sebebi bellekte değerleriyle tutulmaları ve değişim olursa kendi değerlerinin değişmesi oldu.
//Referans tipindeki aynı işlemin sonuçlarına bakalım.
//int[] a = {1,2,3,4,5};
//int[] b = a;
//Bu durumda çıktı:
//a = 1,2,3,4,5 ve b = 1,2,3,4,5 olur.
//→ Burada aslında b’nin değerleri için Heap’de alan yaratılmadı. Stack’de a’nın tuttuğu adresi b’ye eşitlemiş olduk. Dolayısıyla artık a ve b aynı adrese sahip ve aynı değerleri gösteriyorlar.
//a[0] = 9;
//Bu durumda çıktı:
//a = 9,2,3,4,5 ve b=9,2,3,4,5 olur.
//Çünkü bahsettiğimiz gibi aynı adresi gösteriyorlar.
//object c = new object(); //heap’de c için yer açıldı ve c’nin Heap’deki değerini gösteren adres Stack’e yazıldı.






public class OpenClosesPrinciples {
    public static void main(final String[] args) {

        //IOC container aklımıza gelecek.// Ninject, AutoFac, Structure Map, Castle Windsor
        //Burada da hatalı bir yapı kuruldu interface oluşturmamız gerekiyor.Burada da 
        CustomerManagerOC customerManagerOC = new CustomerManagerOC(new EfCustomerDal());
        customerManagerOC.Add();
    }
}


//Servis Katmanı oluşturmamız gerekiyor 

interface ICustomerService {
    void Add();
}

// Business Katmanı kaynakları gevşek bağlı hale getirmek ne demek interface
// ile sadece iletişim kurabilirsin
class CustomerManagerOC implements ICustomerService {

    //Business veri erişim katmanı ile soyutlama teknikleri iletişim kurmalıdır
    private ICustomerDal _customerDal;

    public CustomerManagerOC(ICustomerDal customerDal)
    {
        _customerDal = customerDal;
    }

    public void Add() {

        //final CustomerDal customerDal = new CustomerDal();
        //customerDal.Add(Database.Mysql);
        _customerDal.Add();

    }
}

// Mvc projesi arayüz koyduk yarın başka bir api yazarsak orayada o kodlarıda gömmek mantıklı değil
// Backendde Bir IOC containerden destek alacağız.

//Dependency Inversion
// Bir Katman başka bir katmana gevşek bağlı olmalı
//Bir managerin yani iki classs arasında da bağlantı kurabiliriz

// Yeni Bir Veritabani tanımlaması yaparak işlemlerimizi yaparsak if else
// durumundan kurtulmamız gerek bu şekilde doğru bir kod
// yazılımı kabul görmemektedir.

// Burada yazılan işlemlere çok dikkat etmelisin
/*
 * class CustomerDal implements ICustomerDal {
 * 
 * 
 * public void Add(final Database database) { //EntityCode if(database ==
 * Database.Mysql) {
 * 
 * System.out.println("Added to Mysql database");
 * 
 * }else if(database == Database.Oracle) {
 * 
 * System.out.println("Added to Oracle database");
 * 
 * }else{
 * 
 * System.out.println("Added to SqlServer database"); }
 * 
 * }
 * 
 * 
 * }
 */


 //Veri Erişim Katmanı
class EfCustomerDal implements ICustomerDal {

    public void Add() {

        System.out.println("Added by EF");

    }
}

class NhCustomerDal implements ICustomerDal {

    public void Add() {

        System.out.println("Added by Nh");

    }
}

class DapperCustomerDal implements ICustomerDal {

    public void Add() {

        System.out.println("Added by Dapper");

    }
}

/**Çözüm için oluşturduğumuz interface'miz */
interface ICustomerDal {
    
    void Add();
}


/** Oluşturulan Enum Sınıfı Gerek Kalmadı */
/**enum Database {
    SqlServer,
    Mysql,
    Oracle
}*/