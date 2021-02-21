import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    private SingleLinkedList<String> singleLinkedList;

    @BeforeEach
    void setUp(){
        singleLinkedList = new SingleLinkedList<>();

        singleLinkedList.add("Element1");
        singleLinkedList.add("Element2");
        singleLinkedList.add("Element3");
        singleLinkedList.add("Element4");
    }

    @Test
    void remove_first_value_by_index() {

        assertEquals(singleLinkedList.remove(0),
                "Element1");
        assertEquals(singleLinkedList.remove(0),
                "Element2");
        assertEquals(singleLinkedList.remove(0),
                "Element3");
        assertEquals(singleLinkedList.remove(0),
                "Element4");

    }


    @Test
    void try_to_remove_value_from_too_big_index() {

        String message = "Exception has not been occured!";


        try{
            singleLinkedList.remove(10);
        }
        catch (Exception exception)
        {
           message = exception.getMessage();
        }

        assertEquals("Element at this index does not exist!", message);

    }

    @Test
    void copy_by_index()
    {
        assertEquals("Element1", singleLinkedList.copy(0));
        assertEquals("Element2", singleLinkedList.copy(1));
        assertEquals("Element3", singleLinkedList.copy(2));
        assertEquals("Element4", singleLinkedList.copy(3));
    }

    @Test
    void copy_last()
    {
        assertEquals("Element4", singleLinkedList.copyLast());
    }

    @Test
    void try_to_remove_value_from_negative_index() {

        String message = "Exception has not been occured!";

        try{
            singleLinkedList.remove(-1);
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();

        }
        assertEquals("Index can not be negative!", message);

    }

    @Test
    void remove_from_empty_list() {

        singleLinkedList.clear();

        try{
            singleLinkedList.removeLast();
        }
        catch (IllegalStateException exception)
        {
            assertEquals("Cannot remove element, list is already empty!", exception.getMessage());
        }

    }

    @Test
    void clear_list() {

        singleLinkedList.clear();

        assertEquals(0, singleLinkedList.size());

    }

    @Test
    void remove_value_by_index() {

        assertEquals(singleLinkedList.remove(3),
                "Element4");
        assertEquals(singleLinkedList.remove(2),
                "Element3");
    }

    @Test
    void remove_value_by_object(){

        assertEquals("Element2",singleLinkedList.remove("Element2"));
    }

    @Test
    void remove_value_from_top() {

        assertEquals("Element4",
                singleLinkedList.removeLast());

        assertEquals("Element3",
                singleLinkedList.removeLast());
    }

    @Test
    void contains_true() {
        assertTrue(singleLinkedList.contains("Element1"));
        assertTrue(singleLinkedList.contains("Element2"));
        assertTrue(singleLinkedList.contains("Element3"));
        assertTrue(singleLinkedList.contains("Element4"));
    }

    @Test
    void contains_false() {
        assertFalse(singleLinkedList.contains("ElementX"));
    }

    @Test
    void size(){
        assertEquals(4,singleLinkedList.size());

        singleLinkedList.add("Element5");

        assertEquals(5,singleLinkedList.size());
    }

    @Test
    void add_on_the_top(){
        singleLinkedList.add("Element5");
        assertEquals("Element5", singleLinkedList.removeLast());
    }

    @Test
    void add_at_index(){
        singleLinkedList.add("ElementX",2);
        assertEquals("ElementX", singleLinkedList.remove(2));
    }
}