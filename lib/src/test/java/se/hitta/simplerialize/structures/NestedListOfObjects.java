package se.hitta.simplerialize.structures;

import static java.util.Arrays.asList;

import se.hitta.simplerialize.AbstractSerializationTest;
import se.hitta.simplerialize.SerializationCapable;
import se.hitta.simplerialize.Serializer;

import java.io.IOException;
import java.util.List;

public final class NestedListOfObjects extends AbstractSerializationTest {
    @Override
    public void write(final Serializer serializer) throws IOException {
        final List<ComplexObject> objects = asList(
                ComplexObject.of(0),
                ComplexObject.of(1),
                ComplexObject.of(2),
                ComplexObject.of(3),
                ComplexObject.of(4));
        final Iterable<?> iterable = asList(asList(asList(asList(objects))));
        serializer.startContainer("container");
        serializer.eachNestedComplex("item", iterable);
        serializer.endContainer();
    }

    public static final class ComplexObject implements SerializationCapable {

        public static final ComplexObject of(final int i) {
            return new ComplexObject(i);
        }

        public final int number;

        public ComplexObject(final int number) {
            this.number = number;
        }

        @Override
        public void write(final Serializer serializer) throws IOException {
            serializer.writeNameValue("number", this.number);
        }
    }
}