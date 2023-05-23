import org.junit.jupiter.api.Test;

public class SimpleTreeTest {
    @Test
    public void testSimpleTree() {
        SimpleTree<Integer> tree = new SimpleTree<>();

        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);

        tree.traverse();
    }
}
