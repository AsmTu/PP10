

/**
 * Created by taras on 20.01.14.
 */
public class LoadOperation implements  Operation{
    private final String data;

    public LoadOperation(String data ){ //  toDo ******check Length ifEquals
        this.data=data;
    }


    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage temp = AsciiImage.copy2(img);

        for(int i=0;i<temp.getHeight();i++){
            for(int j=0;j<temp.getWidth();j++){
                if(temp.returnIfinCharSeq(data.charAt(i * temp.getWidth() + j))){
                temp.setPixel(j,i,data.charAt(i * temp.getWidth() + j));
                }else{
                    throw new OperationException("OPERATION FAILED");
                }
            }
        }
        return temp;
    }
}
