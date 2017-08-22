package cola;

import excepcion.Desbordamiento;

public interface Cola{
    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    Object getFront( ) throws Desbordamiento;

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    Object dequeue( ) throws Desbordamiento;

    /**
     * Insert a new item into the queue.
     * @param X the item to insert.
     */
    void  enqueue( Object X );

    /**
     * Make the queue logically empty.
     */
    void makeEmpty( );
}