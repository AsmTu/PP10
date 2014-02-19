/**
 * Created by taras on 21.01.14.
 */
public class BinaryOperation implements Operation {

    private final char charAtMid;

    public BinaryOperation(char threshold){
            this.charAtMid=threshold;
    }


    public AsciiImage execute(AsciiImage img) throws OperationException {
        if(!img.returnIfinCharSeq(charAtMid)){
            throw new OperationException("OPERATION FAILED");
        }
       AsciiImage temp = AsciiImage.copy2(img);
       int index=img.returnIntValueOf(charAtMid);
        for(int i=0;i<temp.getHeight();i++){
            for(int j=0;j<temp.getWidth();j++){
                if(temp.returnIntValueOf(temp.getPixel(AsciiPoint.createNewINstance(j,i)))<index){
                    temp.setPixel(j,i,temp.getCharset().charAt(1));
                }else{
                    temp.setPixel(j,i,temp.getBlankChar());
                }
            }
        }
        return temp;
    }
}

