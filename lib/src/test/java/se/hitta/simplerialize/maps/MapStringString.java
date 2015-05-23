package se.hitta.simplerialize.maps;

import se.hitta.simplerialize.AbstractSerializationTest;
import se.hitta.simplerialize.Serializer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MapStringString extends AbstractSerializationTest
{
    private static final Map<String, String> map;
    
    static
    {
        map = new LinkedHashMap<String, String>();
        map.put("yin", "yang");
        map.put("foo", "bar");
        map.put("x", "y");
    }

    @Override
    public void write(final Serializer serializer) throws IOException
    {
        serializer.startContainer(getClass().getSimpleName());
        serializer.eachComplex("entry", map.entrySet());
        serializer.endContainer();
    }
}