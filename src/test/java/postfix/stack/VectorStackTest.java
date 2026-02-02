package postfix.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorStackTest {

    private IStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testPushIncreasesSize() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeekDoesNotRemove() {
        stack.push(42);
        assertEquals(42, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testPopOnEmptyStackThrows() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void testPeekOnEmptyStackThrows() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testMultiplePushAndSize() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertEquals(100, stack.size());
    }
}
