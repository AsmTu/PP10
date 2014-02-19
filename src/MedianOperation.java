

import java.util.ArrayList;
import java.util.Collections;


public class MedianOperation extends  FilterOperation {

    public AsciiImage execute(AsciiImage img) throws OperationException {
        AsciiImage temp = AsciiImage.copy2(img);
        for(int i=0;i< temp.getHeight();i++){
            for(int j=0;j< temp.getWidth();j++){
                temp.setPixel(j, i, getMedian(AsciiPoint.createNewINstance(j, i), img));
            }
        }
        return temp;
    }

    @Override
    public int filter(int[] valuers) {
        return 0;
    }

    private char getMedian(AsciiPoint p,AsciiImage img){
        ArrayList<Integer> returnList= getListWColors(p,img);
        Collections.sort(returnList);
        char medianValue;
        medianValue=img.getCharset().charAt(returnList.get((returnList.size()/2)));
        return medianValue;

    }
    public static  ArrayList<Integer> getListWColors(AsciiPoint p,AsciiImage img){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        ArrayList<Character> neiborList = checkN(p,img);
        for (Character aNeiborList : neiborList) {
            returnList.add(img.returnIntValueOf(aNeiborList));
        }
        return returnList;
    }


    private static ArrayList<Character>  checkN(AsciiPoint center, AsciiImage img){
        ArrayList<Integer> returnlist = new ArrayList<Integer>();
        ArrayList<Character>  tempList = new ArrayList<Character>();
        for(int i=center.getY()-1;i<=center.getY()+1;i++){

            for(int j=center.getX()-1;j<=center.getX()+1;j++){
                returnlist.add(i);
                returnlist.add(j);
            }
        }
        for(int t=0;t<returnlist.size()-1;t+=2){
            if(returnlist.get(t)<0||returnlist.get(t+1)<0||
                    returnlist.get(t)>=img.getHeight()
                    ||returnlist.get(t+1)>=img.getWidth()){
                tempList.add(img.getBlankChar());
            }else{
                tempList.add(img.getPixel(AsciiPoint.createNewINstance(
                        returnlist.get(t + 1), returnlist.get(t))));
            }
        }


        return tempList;
    }
}