package cola;

import excepcion.Desbordamiento;

public class ColaImp implements Cola {

    private Object [ ] theArray;
    private int        currentSize;
    private int        front;
    private int        back;

    static final int DEFAULT_CAPACITY = 4;


	public ColaImp() {

        theArray = new Object[ DEFAULT_CAPACITY ];
        makeEmpty( );
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public Object getFront() throws Desbordamiento {
        if( isEmpty( ) )
            throw new Desbordamiento( "Queue getFront" );
        System.out.println("Frente de la cola: " + theArray[front]);
        return theArray[ front ];
	}

	@Override
	public Object dequeue() throws Desbordamiento {
        if( isEmpty( ) )
            throw new Desbordamiento( "Queue dequeue" );
        currentSize--;

        Object returnValue = theArray[ front ];
        front = increment( front );
        System.out.println("Se eliminó elemento: " + returnValue);
        cola();
        return returnValue;
	}

	@Override
	public void enqueue(Object x) {
        if( currentSize == theArray.length )
            doubleQueue( );
        back = increment( back );
        theArray[ back ] = x;
        currentSize++;
        System.out.println("Se agregó elemento: " + x + " a la cola");
        cola();
	}

    private void doubleQueue( )
    {
        Object [ ] newArray;

        newArray = new Object[ theArray.length * 2 ];

            // Copy elements that are logically in the queue
        for( int i = 0; i < currentSize; i++, front = increment( front ) )
            newArray[ i ] = theArray[ front ];

        theArray = newArray;
        front = 0;
        back = currentSize - 1;
        
        System.out.println("Tamaño de la cola duplicado");
    }
	@Override
	public void makeEmpty() {
        currentSize = 0;
        front = 0;
        back = -1;
        System.out.println("Se vació cola");
        cola();
	}

    private int increment( int x )
    {
        if( ++x == theArray.length )
            x = 0;
        System.out.println("Metodo incremente");
        cola();
        return x;
    }
    
	public void cola(){
		for(int i=0; i<theArray.length; i++)
			System.out.println(theArray[i]);
	}
    
	public static void main(String[] args) throws Desbordamiento {
		ColaImp cola = new ColaImp();
		cola.enqueue(new Integer(4));
		cola.enqueue(new Integer(7));
		cola.enqueue(new Integer(2));
		cola.enqueue(new Integer(8));
		cola.enqueue(new Integer(1));
		cola.enqueue(new Integer(0));
		cola.enqueue(new Integer(9));
		cola.enqueue(new Integer(6));
		cola.enqueue(new Integer(4));
		cola.enqueue(new Integer(18));
		
		cola.dequeue();
		
		cola.getFront();
		
		cola.dequeue();
		
		cola.getFront();
		
		
	}

}
