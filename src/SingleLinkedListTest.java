import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLinkedListTest {

    private SingleLinkedList<String> singleLinkedList;

    @BeforeEach
    void setUp(){
        singleLinkedList = new SingleLinkedList<>();

        singleLinkedList.add("Abc");
        singleLinkedList.add("Qwe");
        singleLinkedList.add("Fgt");
        singleLinkedList.add("Hml");
    }

    @Test
    void remove_first_value_by_index() {

        assertEquals(singleLinkedList.remove(0),
                "Abc");
        assertEquals(singleLinkedList.remove(0),
                "Qwe");
    }

    @Test
    void remove_value_by_index() {

        assertEquals(singleLinkedList.remove(3),
                "Hml");
        assertEquals(singleLinkedList.remove(2),
                "Fgt");
    }

    @Test
    void remove_value_by_object(){

        assertEquals("Qwe",singleLinkedList.remove("Qwe"));
    }

    @Test
    void remove_value_from_top() {

        assertEquals("Hml",
                singleLinkedList.removeLast());

        assertEquals("Fgt",
                singleLinkedList.removeLast());
    }

    @Test
    void size(){
        assertEquals(4,singleLinkedList.size());

        singleLinkedList.add("Abc");

        assertEquals(5,singleLinkedList.size());
    }

    @Test
    void add_on_the_top(){
        singleLinkedList.add("IOP");
        assertEquals("IOP", singleLinkedList.removeLast());
    }

    @Test
    void add_at_index(){
        singleLinkedList.add("LWD",2);
        assertEquals("LWD", singleLinkedList.remove(2));
    }
}