/**
 * Created by taras on 14.02.14.
 */
public class PixelCountMetric implements Histogram<AsciiImage> {
    public int distance(AsciiImage i1, AsciiImage i2) {
      if(i1.getHeight()*i1.getWidth()>=i2.getHeight()*i2.getWidth()){
          return (i1.getHeight()*i1.getWidth())-(i2.getHeight()*i2.getWidth());
      }else{
          return (i2.getHeight()*i2.getWidth())-(i1.getHeight()*i1.getWidth());
      }
    }
}
