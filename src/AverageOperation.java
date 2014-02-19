import java.util.ArrayList;
public class AverageOperation  extends FilterOperation{
    public AverageOperation(){
    }
    public AsciiImage execute(AsciiImage   img) throws OperationException {
        AsciiImage temp = AsciiImage.copy2(img);
        for(int i=0;i< temp.getHeight();i++){
            for(int j=0;j< temp.getWidth();j++){
                temp.setPixel(j, i, returnChar(AsciiPoint.createNewINstance(j, i), img));
            }
        }
        return temp;

    }


    private   char returnChar(AsciiPoint p,AsciiImage img){
       ArrayList<Integer> listWColors=MedianOperation.getListWColors(p,img); // toDo ifChange use variable as array length
       int[] values= new int[listWColors.size()];
        int i=0;
        for(Integer n:listWColors){
            values[i++]=n;
        }
        return img.getCharset().charAt(filter(values));
    }

    public int filter(int[] values){
         float sum =0;
        for(int i=0;i<values.length;i++){
                  sum+=values[i];
        }
        return  Math.round(sum / values.length);
    }
}
