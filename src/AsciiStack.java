/**
 * Diese Klasse implementiert einen Stack (vgl. Stapelspeicher), der seine Größe dynamisch anpasst.
 * Es kann eine beliebige Anzahl an AsciiImage-Objekten gespeichert werden,
 * wobei der Zugriff immer nur auf das oberste Element möglich ist.
 * Diese Implementierung nutzt intern die Klasse AsciiStackNode um mehrere Bilder in einer Liste zu verketten.
 */
public class AsciiStack {

    private AsciiStackNode head;
    /**
     *  Constructor
     *  erzeugt einen leeren Stack
     */
    public AsciiStack(){
        this.head=null;
    }

    /**
     * überprüft, ob zumindest ein Element am Stack liegt.
     * @return
     */
    public boolean empty(){
        return this.size() == 0;
    }

    /**
     * gibt das oberste Element am Stack zurück und entfernt dieses.
     * Liegt kein Element am Stack, so soll null zurückgegeben werden.
     * @return
     */
    public AsciiImage pop(){
        if(this.head.getNext()==null){
            System.out.println("STACK EMPTY");
            return this.head.getImage();
        } else{
            AsciiStackNode temp =this.head;
            this.head = new AsciiStackNode(this.head.getNext().getImage(),this.head.getNext().getNext());
            return temp.getImage();
        }

    }


    /**
     * gibt das oberste Element am Stack zurück ohne es zu entfernen.
     * Liegt nichts am Stack, so soll null zurückgegeben werden.
     * @return
     */
    public AsciiImage peek(){

            return this.head.getImage();

    }

    /**
     * legt ein AsciiImage oben auf den Stack
     */
    public void push(AsciiImage image){
        if(this.head==null){
            this.head=new AsciiStackNode(image,null);
        }else{
            this.head= new AsciiStackNode(image,head);
        }
    }

    /**
     * gibt die Anzahl der Elemente im Stack zurück.
     * @return
     */
    int size(){
        return this.head.size();
    }

    public void printStack(){
        this.head.printSt();
    }



    class AsciiStackNode{


        private final AsciiImage           element;
        private final AsciiStackNode          next;


        /**
         * inizialisiert den Listenknoten.
         * @param image   Node inhalt
         * @param next    Refernz auf nexte element
         */
        public AsciiStackNode(AsciiImage image,AsciiStackNode next){
            this.element=image;
            this.next=next;
        }


        /**
         * iefert das vom Knoten referenzierte AsciiImage zurück.
         * @return
         */
        public AsciiImage getImage(){
            return  this.element;
        }


        /**
         * liefert eine Referenz auf den nächsten Knoten zurück.
         * @return
         */
        public AsciiStackNode getNext(){
            return this.next;
        }

        /**
         * liefert die Anzahl der Knoten in der von diesem Knoten
         * referenzierten Restliste plus eins (für diesen Knoten).
         * @return
         */
        public int size(){
            if(this.getNext()==null){
                return 1;
            }
            return this.getNext().size()+1;
        }

        public void printSt(){
            this.getImage().print();
            if(this.getNext()!=null){
                this.getNext().printSt();
            }
        }

    }

}
