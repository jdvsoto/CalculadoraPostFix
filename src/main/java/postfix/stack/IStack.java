package postfix.stack;

/**
 * Interface que define las operaciones básicas de una pila (stack) de tipo genérico.

 * @param <T> el tipo de dato que almacenará la pila
 */
public interface IStack<T> {

    /**
     * Inserta (empuja) un elemento en la parte superior de la pila.
     *
     * @param value el elemento a insertar en la pila
     */
    void push(T value);

    /**
     * Extrae (saca) y retorna el elemento en la parte superior de la pila.
     *
     * @return el elemento retirado de la pila
     * @throws java.util.NoSuchElementException si la pila está vacía
     */
    T pop();

    /**
     * Devuelve, sin remover, el elemento en la parte superior de la pila.
     *
     * @return el elemento en la cima de la pila
     
     */
    T peek();

    /**
     * Indica si la pila no contiene elementos.
     *
     * @return {@code true} si la pila está vacía; {@code false} en caso contrario
     */
    boolean isEmpty();

    /**
     * Devuelve la cantidad de elementos almacenados actualmente en la pila.
     *
     * @return el número de elementos en la pila
     */
    int size();

    /**
     * Elimina todos los elementos de la pila, dejando la estructura vacía.
     */
    void clear();
}
