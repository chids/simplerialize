/*
 * Copyright 2013 Hittapunktse AB (http://www.hitta.se/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.hitta.simplerialize.adapters;

import java.io.IOException;
import java.util.Collection;

import se.hitta.simplerialize.SerializationCapable;
import se.hitta.simplerialize.Serializer;

/**
 * Collection wrapper that implements {@link SerializationCapable}, i.e. this class is its
 * own {@link se.hitta.simplerialize.SerializationAdapter}.
 */
public class SerializationCapableCollection<T> implements SerializationCapable {
    private final Collection<T> collection;
    private final String typeName;

    public SerializationCapableCollection(final Collection<T> collection, final String typeName) {
        this.collection = collection;
        this.typeName = typeName;
    }

    @Override
    public void write(final Serializer serializer) throws IOException {
        serializer.startContainer(this.typeName + "s");
        serializer.writeNameValue("included", this.collection.size());
        serializer.eachComplex(this.typeName, this.collection);
        serializer.endContainer();
    }
}
