
/**
 * Queue representa uma fila, i.e., uma colecao linear de elementos que suportam 
 * a insercao e remocao de elementos no topo da fila, como uma lista simplesmente ligada.
 * 
 * @author Profs. LabP.
 *
 * @param <E> Tipo de elementos.
 */
public class Queue<E> implements Cloneable {



    //Nested class para os nos das filas

    private static class Node<E>{

        //Atributos

        private E element;
        private Node<E> next;


        /**
         * um noh com um dado elemento e a indicacao do proximo noh.
         * 
         * @param element o elemento
         * @param node o proximo noh
         */
        public Node(E element, Node<E> node){
            this.element = element; 
            this.next= node;
        }

        public String toString(){
            return element.toString();
        }

    }
    //End of nested class

    //Atributos

    private Node<E> head;
    private Node<E> rear;
    private int size;

    //construtores

    /**
     * constroi a fila vazia;
     */
    public Queue() {
        head = null;
        rear = null;
        size = 0;
    }

    /**
     * constroi a fila com um elemento dado;
     * @param element
     * @requires element != null
     */
    public Queue(E element){
        head = new Node<E>(element,null);
        rear = head;
        size++;
    }

    /**
     * @return comprimento da fila
     */
    public int size(){
        return size;
    }

    /**
     * @return true sse a fila esta vazia;  
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Determine a frente da fila
     * @return o primeiro elemento da lista;
     * @requires !isEmpty();  
     */
    public E front(){
        return head.element;
    }


    /**
     * Adiciona um novo elemento no fim da fila.
     * 
     * @param element O elemento a adicionar
     *
     * @requires element != null;
     */
    public void enqueue(E element) {
        Node<E> node = new Node<E> (element, null);
        if (isEmpty()){
            head = node;
            rear = head;
            size++;
        } else{
            rear.next = node;
            rear = node;
            size++;

        }
    }

    /**
     * Remove o elemento no inicio da fila.
     * 
     * @requires !isEmpty()
     */
    public void dequeue() {
        if(head.next == null){
            rear = null;
            head = null;
            size--;
        }else{
            head = head.next;
            size--;
        }

    }

    /**
     * Uma copia da fila copiada ate aos seus emelentos. 
     */
    @Override
    public Queue<E> clone() {
        try {
            Queue<E> result = (Queue<E>) super.clone();
            result.head = copyNodes();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    /**
     * Clone the node structure.
     */
    private Node<E> copyNodes() {
        Node<E> result = null;
        if (!isEmpty()) {
            result = new Node<E>(head.element, head.next);
            for (Node<E> p = result; p.next != null; p = p.next) {
                p.next = new Node<E>(p.next.element, p.next.next);
            }
        }
        return result;
    }
    
    /**
     * Representacao textua de uma fila na forma <e1, e2,...>
     * @return representacao textual da fila
     * @requires !isEmpty()
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        Node<E> cur = head;
        while(cur!=null){
            s.append(cur.element.toString());
            cur=cur.next;
        }
        return s.toString();
    }
}
