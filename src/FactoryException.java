/**
 * Created by taras on 17.01.14.
 */
class FactoryException extends  Exception {

    public FactoryException(){
        super();
    }
    public FactoryException(String message){
        System.out.println(message);
        System.exit(0);
     //   super(message);
    }
}
