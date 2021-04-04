import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
            Arguments.of(new int[]{6,4,5}, new int[]{4,5,6}),
            Arguments.of(new int[]{-5,-3,-4,7}, new int[]{-5,-4,-3,7}),
            Arguments.of(new int[]{5,-4,-7,-3,4}, new int[]{-7,-4,-3,4,5}),
            Arguments.of(new int[]{-5,3,13,2,11,5}, new int[]{-5,2,3,5,11,14}),
            Arguments.of(new int[]{5,9,4,-3,-4}, new int[]{-4,-3,4,5,9})
        );
    }
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //TODO random_array add to prorityQueue
        for ( int i = 0; i  <  random_array.length; i++ ){
            test.add(random_array[i]) ;
        }
        System.out.println ( "Initial priority queue values are: "+ test);
        //TODO get prorityQueue result.
        for ( int i = 0; i  <  correct_array.length; i++ ){
            result[i] = test.poll();
        }

        assertArrayEquals(correct_array, result);

    }
    //TODO unique Exceptions
    @Test
    public void whenExceptionThrown_thenInitialCapacityNotGreaterThanOne(){
        assertThrows(IllegalArgumentException.class,()->{
            PriorityQueue<Integer> priorityqueue=new PriorityQueue<Integer>(-1,null);
        });
    }
    @Test
    public void whenExceptionThrown_thenOfferEisNull(){
        assertThrows(NullPointerException.class,()->{
            PriorityQueue<Integer>priorityqueue=new PriorityQueue<Integer>();
            priorityqueue.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenNoElementCanRemove() {
        assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<Integer> priorityqueue = new PriorityQueue<Integer>();
            priorityqueue.remove();
        });
    }
}
