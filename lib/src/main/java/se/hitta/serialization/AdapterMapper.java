/*
 * Copyright 2011 Hittapunktse AB (http://www.hitta.se/)
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
package se.hitta.serialization;

import se.hitta.serialization.adapters.NullAdapter;

/**
 * An {@link AdapterMapper} maps {@link Class} objects to {@link SerializationAdapter} instances.
 * It's also responsible for trying to find a suitable adapter by moving up the type hierarchy
 * should one not already be registered for the supplied {@link Class}. 
 */
public interface AdapterMapper
{
    /**
     * Register a given {@link SerializationAdapter} as the adapter to use for the provided type(es).
     * 
     * @param adapter The adapter to register
     * @param clazz The type(es) to register the adapter with
     * @return The instance of the {@link AdapterMapper} to allow method chaining
     */
    public AdapterMapper register(final SerializationAdapter<?> adapter, final Class<?>... clazz);

    /**
     * This method is responsible for finding an adapter. It usually boils down to:
     * <ol>
     * <li>Check for any adapter explicitly registered for the provide type</li>
     * <li>Check whether the type implements {@link SerializationCapable} and thus should be considered its own adapter</li>
     * <li>Check for any adapter on any of the interfaces that the type implements</li>
     * <li>Repeat from step (1) on the superclass type</li>
     * </ol>
     * 
     * @param clazz the type to provide an adapter for
     * @return the adapter that should be used to serialize instances of the type
     */
    public <T> SerializationAdapter<T> resolveAdapter(final Class<T> clazz);

    /**
     * Register the provided {@link Class} to be skipped if encountered during serialization.
     * Skipped meaning no output will be produced. This is implemented by simply registering the {@link NullAdapter}'s
     * instance for the given {@link Class}.
     *  
     * @param <T> 
     * @param clazz The class to skip
     */
    public <T> AdapterMapper skip(final Class<T> clazz);
}