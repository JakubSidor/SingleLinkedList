

//Implementation of Singly Linked List
public class SingleLinkedList <V> {

    //Reference to last(top) element of list
    private Element last;
    //Reference to first element of list
    private Element first;
    //Size of list
    private int size = 0;

    //Adds element to top of the single linked list
    public void add(V data)
    {
        Element temp = last;
        if(first == null)
        {
            last = new Element(data);
            first = last;
        }
        else {

            last.next = new Element(data);
            last = last.next;
        }
        size++;
    }

    //Adds element at specified index
    public void add(V data, int index){
        Element temp = first;

        if(index == 0)
        {
            first = new Element(data);
            first.next = temp;

            if(first.next == null){
                last = first;
            }
            return;
        }

        for(int i = 0; i < index - 1; i++){

            if(temp.next==null)
            {
                temp.next = new Element(data);
                last = temp;
                return;
            }

            temp = temp.next;
        }

        Element temp_2 = temp.next;
        temp.next = new Element(data);
        temp.next.next=temp_2;


    }

    //Checks if list contains specified piece of data
    public boolean contains(V data)
    {
        Element temp = first;
        while (temp!=null)
        {
            if(temp.data.equals(data))
            {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public V copyLast(){
        return last.data;
    }

    public V copy(int index){
        V data;
        Element temp = first;

        if(index < 0)
        {
            throw new IllegalArgumentException("Index can not be negative!");
        }
        if(index == 0)
        {
            data = first.data;

            return data;
        }

        for(int i = 0; i < index - 1; i++){

            if(temp==null)
            {
                throw new IllegalArgumentException("Element at this index does not exist!");
            }

            temp = temp.next;

        }

        data = temp.next.data;
        return data;
    }

    public int size()
    {
        return size;
    }

    //Removes all elements from list
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    //Removes last element from list and returns it
    public V remove(int index)
    {
        V data;
        Element temp = first;

        decreaseCounter();


        if(index < 0)
        {
            throw new IllegalArgumentException("Index can not be negative!");
        }
        if(index == 0)
        {
            data = first.data;

            if(first.next!=null)
            {
                first = first.next;
            }
            else{
                first = null;
            }
            return data;
        }

        for(int i = 0; i < index - 1; i++){

            if(temp==null)
            {
                throw new IllegalArgumentException("Element at this index does not exist!");
            }

            temp = temp.next;

        }

        data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    //decreaseCounter by 1 if list is not empty
    private void decreaseCounter(){
        if(size>0){
            size--;
        }
        else
        {
            throw new IllegalStateException("Cannot remove element, list is already empty!");
        }
    }

    //Removes and returns specified element from list
    public V remove(V element)
    {
        V data;
        Element temp = first;

        if(temp.data.equals(element)) {

            decreaseCounter();
            data = first.data;

            if(first.next!=null)
            {
                first = first.next;
            }
            else{
                first = null;
            }

            return data;
        }

        while (temp.next!=null)
        {
            if(temp.next.data.equals(element)) {
                decreaseCounter();
                data = temp.next.data;
                temp.next = temp.next.next;
                return data;
            }
            temp = temp.next;

        }
        return null;
    }

    //Removes and returns last element from list
    public V removeLast()
    {
        Element temp = first;

        decreaseCounter();

        while (temp.next!= last){
            temp = temp.next;
        }

        V data = temp.next.data;

        last = temp;
        temp.next = null;

        return data;
    }

    //Iterates through all elements of list and print every piece of data
    public void printAll()
    {
        Element temp = first;
        while (temp!=null)
        {
            System.out.println("value:"+temp.data);
            temp = temp.next;
        }
    }

    //Inner class Element contains reference to next Element and one piece of data
    private class Element
    {
        public Element (V data)
        {
            this.data = data;
        }

        //Reference to next element and instance of data object
        public Element next = null;
        //Piece of data
        public V data;

    }
}
