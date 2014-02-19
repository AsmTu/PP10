/**
 * Diese Klasse repräsentiert einen Punkt, spezifiziert durch zwei ganzzahlige Koordinaten.
 * Diese Klasse ist unveränderlich (immutable), sprich die Koordinaten sollen nachträglich
 * nicht mehr veränderbar sein.
 */
public class AsciiPoint {

    private final int x;
    private final int y;

    public static AsciiPoint createNewINstance(int x, int y) {
        return new AsciiPoint(x, y);
    }

    /**
     * Constructor
     *
     * @param x
     * @param y
     */
    private AsciiPoint(int x, int y) {
        this.x = x;
        this.y = y;

    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }


}