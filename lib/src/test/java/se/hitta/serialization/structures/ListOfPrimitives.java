package se.hitta.serialization.structures;

import java.util.Arrays;

import se.hitta.serialization.AbstractSerializationTest;
import se.hitta.serialization.InsideContainer;
import se.hitta.serialization.SerializationCapable;
import se.hitta.serialization.SerializationContext;

public final class ListOfPrimitives extends AbstractSerializationTest
{
    @Override
    public void write(final SerializationContext serializer) throws Exception
    {
        final InsideContainer container = serializer.startContainer("container");
        serializer.beneath("items").writePrimitives("item", Arrays.asList("foo", "bar"));
        container.end();
    }

    int i = 0;

    final class Item implements SerializationCapable
    {
        @Override
        public void write(final SerializationContext serializer) throws Exception
        {
            serializer.writeNameValue("item" + ListOfPrimitives.this.i++, "value");
        }
    }
}