
public class ClearOperation implements Operation {

    public ClearOperation(){

    }

    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage temp = AsciiImage.createNewInstance(img.getWidth(), img.getHeight(), img.getCharset());
       temp.makeClear();
       return temp;
    }

}
