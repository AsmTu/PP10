/**
 * Created by taras on 17.01.14.
 */
class OperationException extends Exception {

    public OperationException(){
        super();
    }

    public OperationException(String message){
        System.out.println(message);
        System.exit(0);
       // super(message);
    }
}
