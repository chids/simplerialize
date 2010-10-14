package se.hitta.serialization.adapter;

import se.hitta.serialization.JsonSerializer;
import se.hitta.serialization.XmlSerializer;

final class ObjectAdapter implements Adapter<Object>
{
    @Override
    public void writeJson(final Object target, final JsonSerializer serializer) throws Exception
    {
        serializer.writePrimitive(target);
    }

    @Override
    public void writeXml(final Object target, final XmlSerializer serializer) throws Exception
    {
        serializer.writePrimitive(target);
    }
}