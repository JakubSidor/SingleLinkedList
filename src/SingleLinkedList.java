public class SingleLinkedList <V> {

    private Element last;
    private Element first;
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

    public int size()
    {
        return size;
    }

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
                return null;
            }

            temp = temp.next;

        }

        data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    private void decreaseCounter(){
        if(size>0){
            size--;
        }
    }

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

    public V removeLast()
    {
        Element temp = first;

        while (temp.next!= last){
            temp = temp.next;
        }

        V data = temp.next.data;

        last = temp;
        temp.next = null;

        return data;
    }

    public void printAll()
    {
        Element temp = first;
        while (temp!=null)
        {
            System.out.println("value:"+temp.data);
            temp = temp.next;
        }
    }

    //Contains reference to next element and instance of data object
    private class Element
    {
        public Element (V data)
        {
            this.data = data;
        }

        public Element getInstance() {
            return instance;
        }

        //Next ELEMENT IN List
        public Element instance = this;
        public Element next = null;
        public V data;

    }
}
