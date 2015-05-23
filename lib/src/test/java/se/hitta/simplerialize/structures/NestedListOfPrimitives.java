package se.hitta.simplerialize.structures;

import static java.util.Arrays.asList;

import se.hitta.simplerialize.AbstractSerializationTest;
import se.hitta.simplerialize.Serializer;

import java.io.IOException;

public final class NestedListOfPrimitives extends AbstractSerializationTest {
    @Override
    public void write(final Serializer serializer) throws IOException {
        final Iterable<?> iterable = asList(asList(asList(asList(asList("foo", "bar", "A", "B", "C")))));
        serializer.startContainer("container");
        serializer.eachNestedPrimitive("items", iterable);
        serializer.endContainer();
    }

}