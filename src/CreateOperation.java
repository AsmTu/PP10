/**
 * Created by taras on 13.02.14.
 */
public class CreateOperation implements Operation {

    private final int h;
    private final int w;
    private final String charset;

    public CreateOperation(int w,int h,String charset){
        this.w=w;
        this.h=h;
        this.charset=charset;
    }
    public AsciiImage execute(AsciiImage img) throws OperationException {
        //System.out.println("Im here,"+ this.w +"    "+this.h+"   "+this.charset);
        return AsciiImage.createNewInstance(this.w,this.h,this.charset);
    }
}
