package se.hitta.simplerialize.basics;

import java.io.IOException;

import se.hitta.simplerialize.AbstractSerializationTest;
import se.hitta.simplerialize.AdapterMapper;
import se.hitta.simplerialize.Serializer;
import se.hitta.simplerialize.adapters.DefaultAdapterMapper;

public final class NullAdapterTest extends AbstractSerializationTest
{
    @Override
    public AdapterMapper createMapper()
    {
        return new DefaultAdapterMapper().skip(String.class);
    }

    @Override
    public void write(final Serializer context) throws IOException
    {
        context.startContainer("root").writeWithAdapter("foo").endContainer();
    }
}