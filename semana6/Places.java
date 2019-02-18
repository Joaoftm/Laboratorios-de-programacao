import java.util.Iterator;

public class Places implements Iterable<Integer> {

    public enum POSITIONS {AVAILABLE, OCCUPY};

    private POSITIONS[] elems;

    public Places(int size) {
        elems = new POSITIONS[size];
    }

    // pre: assumes is not occupied yet
    public void occupy(int place) {
        elems[place] = Places.POSITIONS.OCCUPY;
    }

    public void available(int place) {
        elems[place] = Places.POSITIONS.AVAILABLE;
    }

    // returns all occupied places
    public Iterator<Integer> iterator() { 
        return new PlaceIterator();
    }

    private class PlaceIterator implements Iterator<Integer> {

        private int index;
        
        private PlaceIterator() {
            index = -1;
        }

        public Integer next(){
            if(hasNext()){
                index ++;
                return index;
            }else{
                return -1;
            }

        }

        public boolean hasNext() {
            boolean found = false;
            while(!found && index != elems.length-1) {
                // verifica se já chegou ao final do array

                // verifica se é uma posição ocupada
                if (elems[index+1] == Places.POSITIONS.OCCUPY){
                    found = true;
                }else{
                    // avança o index até encontrar posição ocupada.
                    index++;
                }
            }
            return found;
        }
    }

    public static void main(String[] args) {
        Places p = new Places(10);

        p.occupy(0);
        p.occupy(1);
        p.occupy(7);
        p.occupy(9);
        p.available(1);

        Iterator<Integer> it = p.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


        // the previous cycle can also be executed with a for-each 
        for(Integer i : p) {
            System.out.println(i);
        }
    }

}
