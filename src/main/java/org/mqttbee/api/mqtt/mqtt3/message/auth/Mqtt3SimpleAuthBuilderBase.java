/*
 * Copyright 2018 The MQTT Bee project
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
 *
 */

package org.mqttbee.api.mqtt.mqtt3.message.auth;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mqttbee.annotations.DoNotImplement;
import org.mqttbee.api.mqtt.datatypes.MqttUTF8String;

import java.nio.ByteBuffer;

/**
 * @author Silvio Giebl
 */
@DoNotImplement
public interface Mqtt3SimpleAuthBuilderBase<B extends Mqtt3SimpleAuthBuilderBase<B, C>, C extends B> {

    @NotNull C username(@NotNull String username);

    @NotNull C username(@NotNull MqttUTF8String username);

    @NotNull B password(@Nullable byte[] password);

    @NotNull B password(@Nullable ByteBuffer password);

    @DoNotImplement
    interface Complete<B extends Mqtt3SimpleAuthBuilderBase<B, C>, C extends B>
            extends Mqtt3SimpleAuthBuilderBase<B, C> {

        @Override
        @NotNull C password(@Nullable byte[] password);

        @Override
        @NotNull C password(@Nullable ByteBuffer password);
    }
}
