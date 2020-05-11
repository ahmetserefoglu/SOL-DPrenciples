
public class SingleResponsibility {
    
    public static void main(String[] args) {
        
    }
}

class CustomerManager { 

    //Aspect Oriented Programming ile burada devreye giriyor
    //SingleResponsibility'i bu şekilde koruyabiliyoruz
    public void TransactionalOperation() {

        //Loglama
        //Validation
        //Caching
        //Auth
        //Performance
        Insert();
        Update();
    }

    public void Insert() {
        MyContext context = new MyContext();
        context.Insert();
    }

    public void Update() {
        MyContext context = new MyContext();
        context.Update();
    }
}

class PersonManager {

    public void Add() {
        
        CustomerManager customerManager = new CustomerManager();
        //Hatalı Bir Kullanım
        customerManager.TransactionalOperation();
    }
}

class MyContext {

    public void Update() {
        
    }

    public void Insert() {
        
    }
}
