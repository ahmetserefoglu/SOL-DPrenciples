//Normalizasyon
// İlişkisel veri tabanları tasarlanırken gereksiz veri tekrarını, bilgi kaybını
// önlemek amacıyla normalizasyon işleminin uygulanması gerekmektedir.
// Normalizasyon uygulanarak ilişkilerin normal forma getirilmesi sağlanır.
// Normalizasyon, taslak veri tabanı üzerinde bazı işlemler yaparak taslağı son
// haline yaklaştırma yöntemidir. İyi tasarlanmamış bir veri tabanında ekleme,
// güncelleme ve silme işleminden kaynaklanan bozulmalar nedeniyle kullanım
// zorluklarını meydana gelir. Normalizasyon, veri tabanında bu tür sapmaları
// ortadan kaldırmayı sağlayan bir süreçtir.

/**Liskov's Substitution */
// Sırf birbirine benziyor diye birbinin kullanma
// Gerçek ve Tüzel Müşteri mantığı
//gerçek (Adi,Soyadi..)



public class LiskovsSubstitution {
    public static void main(String[] args) {
        
        /*Customer customer = new Customer();
        customer.Id = 1;
        customer.FirstName = "Ahmet";
        customer.LastName = "Şerefoğlu";*/

        //Fİrmayı da customerdan türetip kullandı bu yanlış bir uygulama yontemi
        /*Customer firma = new Customer();
        firma.Id = 2;
        customer.FirstName = "Abc Kozmetik";
        customer.LastName = null;*/
        

    }
}

class Customer {

    public int Id;
    
}

class RealCustomer extends Customer {

    public String FirstName;
    public String LastName;
    public int TcNo;

}

class TuzelCustomer extends Customer {

    public String Unvan;
    public int VergiNo;

}