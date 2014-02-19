
public class ReplaceOperation implements Operation  {

    private final char   charToReplace;
    private final char withWillReplace;

    public ReplaceOperation(char charToReplace,char withWillReplace) {
        this.charToReplace=charToReplace;
        this.withWillReplace=withWillReplace;
    }
    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage temp =AsciiImage.copyOldInstance(img);

        if(img.returnIfinCharSeq(charToReplace)&&img.returnIfinCharSeq(withWillReplace)){
            for(int i=0;i<temp.getHeight();i++){
                for(int j=0;j<temp.getWidth();j++){
                    if(temp.getPixel(AsciiPoint.createNewINstance(j,i))==charToReplace){
                        temp.setPixel(j,i,withWillReplace);
                    }
                }
            }
        }else{
            throw  new OperationException("OPERATION FAILED");
        }
        return temp;

    }
}
