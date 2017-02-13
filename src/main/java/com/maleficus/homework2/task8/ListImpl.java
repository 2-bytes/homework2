package com.maleficus.homework2.task8;

/**
 *
 * @author Vitalii Umanets
 */
public class ListImpl<T extends Comparable> {

    private int size;
    ListElem<T> head;

    private class ListElem<T>{
        private T elem;
        private ListElem<T> next;

        public ListElem(){
            this.elem = null;
            this.next = null;
        }

        public ListElem(T elem){
            this.elem = elem;
            this.next = null;
        }

        public T getElem(){
            return elem;
        }

        public ListElem<T> getNextElem(){
            return next;
        }

        public void removeNextElem(){
            next = next.next;
        }

        public boolean hasNext(){
            return next!=null;
        }
    }

    public ListImpl(){
        this.size = 0;
        this.head = null;
    }

    /**
    * Will create a new list with the specified size.
    * @param size Size of a new lis
    */
    public ListImpl(int size){
        if(size<0)
            size=0;
        this.size = size;
        head = new ListElem<>();
        size--;
        ListElem tail = head;
        while(size>0){
            tail.next = new ListElem<>();
            tail.next = tail.next.next;
            size--;
        }
    }

    public int getSize(){
        return this.size;
    }

    public T getElementAt(int index) throws IndexOutOfBoundsException{
        if (index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        ListElem<T> current = head;
        while(index>0 && current.hasNext()){
            current = current.next;
            index--;
        }
        return current.elem;

    }

    public void put(T elem){
        if(head == null){
            this.head = new ListElem<>(elem);
            this.size++;
            return;
        }
        ListElem<T> current = head;
        while(current.hasNext())
            current=current.next;
        current.next = new ListElem<>(elem);
        this.size++;
    }

    public void set(int index, T elem){
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException();
        ListElem<T> current = head;
        while(index>0){
            current = current.next;
            index--;
        }
        current.elem = elem;
    }

    public void putAt(int index, T elem){
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException();
        if(index==0){
            ListElem<T> newElem = new ListElem<>(elem);
            newElem.next = this.head;
            this.head = newElem;
            this.size++;
            return;
        }
        ListElem<T> current = head;
        while(index>1){
            current = current.next;
            index--;
        }
        ListElem<T> newElem = new ListElem<>(elem);
        newElem.next = current.next;
        current.next = newElem;
        this.size++;
    }

    public void remove(int index){
        if(index<0 || index>this.size || this.size==0)
            throw new IndexOutOfBoundsException();
        if(index ==0){
            this.head = this.head.next;
            this.size--;
            return;
        }
        ListElem<T> current = head;
        while(index>1){
            current = current.next;
            index--;
        }
        current.removeNextElem();
        this.size--;
    }
    public T[] toArray(){
        Comparable[] array = new Comparable[this.size];
        ListElem<T> current = head;
        for(int i=0;i<this.size;i++){
            array[i]= current.elem;
            current = current.next;
        }
        return (T[])array;
    }

}
