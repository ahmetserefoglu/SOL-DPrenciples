public class InterfaceSegregation {
   public static void main(String[] args) {
       
   } 
}

// Fabrika düşünelim , çalışanları var , danışmanları var

interface IPay {
    
    void PaySalary();
    
}

interface IEat {

    void ProvideFood();
}
interface IWorker {
    
    void Work();
}

class CompanyWorker implements IWorker,IEat,IPay {

    @Override
    public void PaySalary() {
        // TODO Auto-generated method stub

    }

    @Override
    public void ProvideFood() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Work() {
        // TODO Auto-generated method stub

    }

    
}

class OutsourceWorker implements IWorker,IPay {

    @Override
    public void PaySalary() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Work() {
        // TODO Auto-generated method stub

    }

}

class RobotWorker implements IWorker {

    @Override
    public void Work() {
        // TODO Auto-generated method stub

    }

}