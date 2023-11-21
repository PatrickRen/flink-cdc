/*
 * Copyright 2023 Ververica Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.cdc.runtime.serializer;

import org.apache.flink.api.common.typeutils.TypeSerializer;

import java.util.Random;

/** A test for the {@link ShortSerializer}. */
class ShortSerializerTest extends SerializerTestBase<Short> {

    @Override
    protected TypeSerializer<Short> createSerializer() {
        return ShortSerializer.INSTANCE;
    }

    @Override
    protected int getLength() {
        return 2;
    }

    @Override
    protected Class<Short> getTypeClass() {
        return Short.class;
    }

    @Override
    protected Short[] getTestData() {
        Random rnd = new Random(874597969123412341L);
        int rndInt = rnd.nextInt(32767);

        return new Short[] {
            Short.valueOf((short) 0),
            Short.valueOf((short) 1),
            Short.valueOf((short) -1),
            Short.valueOf((short) rndInt),
            Short.valueOf((short) -rndInt),
            Short.valueOf((short) -32767),
            Short.valueOf((short) 32768)
        };
    }
}