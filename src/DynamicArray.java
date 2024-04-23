import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T> {  //passar o tipo de dado que vai ser armazenado no T
    private static final int INITIAL_CAPACITY = 10;  //final = constant
    private Object[] array;
    private int counter;
    private int size;

    public DynamicArray(){
        this.counter = 0;
        this.array = new Object[INITIAL_CAPACITY];
        this.size = INITIAL_CAPACITY;
    }

    public T get(int index){
        return (T) array[index];
    }

    public int getCounter() {
        return counter;
    }

    public int getSize() {
        return size;
    }

    /**
     * esse método recebe um item e adiciona a lista
     * @param item é o valor que vai ser adicionado a lista
     */
    public void add(T item){
        array[counter] = item;  //pega o array na posição do counter (começa com 0), e coloca item
        counter++;  // aponta para a proxima posição
        if (counter == size){  // se a posição apontada for igual ao tamanho, então encheu
            this.grow();  // se encheu chamou o método grow
        }
    }

    public <T> T[] toArray(T[] a) {

        if (a.length < size)
            return (T[]) Arrays.copyOfRange(                   array, 0, counter, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * dobra o tamanho do array e atualiza o segundo array com os itens do array original
     * depois que ele atinge o tamanho do counter (o counter era o tamanho original)
     */
    private void grow(){
        size = size * 2;  // define o tamanho do novo array
        Object[] array2 = new Object[size];  // criou um novo vetor com o novo tamanho
        //Outro jeito: if (counter >= 0) System.arraycopy(array, 0, array2, 0, counter);
        for (int i = 0; i < counter; i++){  // copia os dados do array antigo pro array novo
            array2[i] = array[i];  // adiciona um item por vez
        }
        this.array = array2;  // atualiza o array para o array2 (que foi aumentado e copiado(copiado os itens))
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < counter;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
