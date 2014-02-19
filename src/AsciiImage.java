
import java.util.*;

public class AsciiImage {

    private int height;
    private int width;
    private String charset;
    private final char[][] image;

    /**
     * @param x       Width
     * @param y       Height
     * @param charset String mit Charset
     * @return new AsciiImage
     */
    public static AsciiImage createNewInstance(int x, int y, String charset) throws OperationException {
        if(x==0||y==0){
            throw new OperationException("INPUT MISMATCHgyyyy");
        }
        return new AsciiImage(x, y, charset);
    }



    public static AsciiImage copy2(AsciiImage img) throws OperationException {
        AsciiImage temp = AsciiImage.createNewInstance(img.getWidth(), img.getHeight(), img.getCharset());
        temp.makeEquals(img);
        return temp;
    }

    public static AsciiImage copyOldInstance(AsciiImage img) {

        return new AsciiImage(img);
    }


    /**
     * @param width  Breite des Bildes
     * @param height Höhe des Bildes
     */
    private AsciiImage(int width, int height, String charset) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCharset(charset);
        this.image = new char[this.getHeight()][this.getWidth()];
        this.makeClear();

    }

    public void makeClear(){
        char blankChar =this.charset.charAt(this.charset.length()-1);
        for(int i=0;i<this.getHeight();i++){
            for(int j=0;j<this.getWidth();j++){
                this.setPixel(AsciiPoint.createNewINstance(j, i), blankChar);
            }
        }
    }

    /**
     * Coppy Constructor
     *
     * @param img AsciiImage, der copiert werde
     */
    private AsciiImage(AsciiImage img) {
        this.setHeight(img.getHeight());
        this.setWidth(img.getWidth());
        this.setCharset(img.getCharset());
        // this.image=Arrays.copyOf(img.getImage(),img.image.length);
        this.image = img.image.clone();
    }


    /**
     * Getters und Setters
     */

    public char getBlankChar() {
        return this.getCharset().charAt(this.getCharset().length() - 1);
    }

    public int getHeight() {
        return this.height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    public String getCharset() {
        return this.charset;
    }

    void setCharset(String charset) {
        this.charset = charset;
    }

    public ArrayList<Character>  getPointList(char c) {
        ArrayList<Character> listWPoints = new ArrayList<Character>();
        for(int i=0;i<this.getHeight();i++){
            for(int j=0;j<this.getWidth();j++){
                if(this.image[i][j]==c){
                    listWPoints.add(image[i][j]);
                }
            }
        }
    //    System.out.println(" count of chars is  "+c+"   "+listWPoints.size());
        return listWPoints;
    }

    public void setPixel(int x, int y, char c) {
        this.image[y][x] = c;

    }

    public char getPixel(AsciiPoint p) {
        return this.image[p.getY()][p.getX()];
    }

    void setPixel(AsciiPoint p, char c) {
        setPixel(p.getX(), p.getY(), c);
    }

    public char[][] getImage() {
        return this.image;
    }

    public void print() {
        for (int i = 0; i < this.getHeight(); i++) {
            String temp = "";
            for (int j = 0; j < this.getWidth(); j++) {
                temp += image[i][j];
            }
            System.out.println(temp);
        }
    }

    private void makeEquals(AsciiImage img) {
  //      this.setHeight(img.getHeight());
    //    this.setWidth(img.getWidth());
      //  this.charset = img.charset;
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                this.setPixel(j, i, img.image[i][j]);
            }
        }

    }

    /**
     * @param c char , nach welchen index gesucht
     * @return Liefert zuruck index des Chars
     */
    public int returnIntValueOf(char c) {
       /* for (int i = 0; i <= this.charset.length(); i++) {
            if (this.charset.charAt(i) == c) {
                return this.charset.indexOf(c);
            }
        }*/
        return this.charset.indexOf(c);
    }

    public boolean returnIfinCharSeq(char c) {
        for (int i = 0; i < this.getCharset().length(); i++) {
            if (this.getCharset().charAt(i) == c) {
                return true;
            }
        }
        return false;
    } 
    /**
     * Methoden, die man laut Aufgabe Implementieren muss
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                temp += image[i][j];
            }
        }
        return temp;
    }

    @Override
    public boolean equals(Object o){
        if(o.toString().length()==this.toString().length()){
            for(int i=0;i<o.toString().length();i++){
                if(o.toString().charAt(i)!=this.toString().charAt(i)){
                    return false;
                }
            }
        }
        return true;

    }

    public int getUniqueChars(){
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(this.toString()));
        return set.size();
    }

    public int hashCode(){
       int hash=0;
        for(int i=0;i<this.charset.length();i++){
            hash+=(int)this.charset.charAt(i);
        }
        return hash;
    }
}