package org.mqttbee.api.mqtt5.message.disconnect;

import org.mqttbee.annotations.DoNotImplement;
import org.mqttbee.annotations.NotNull;
import org.mqttbee.api.mqtt.datatypes.MqttUTF8String;
import org.mqttbee.api.mqtt.datatypes.mqtt5.Mqtt5UserProperties;
import org.mqttbee.api.mqtt5.message.Mqtt5Message;

import java.util.Optional;

/**
 * MQTT 5 DISCONNECT packet.
 *
 * @author Silvio Giebl
 */
@DoNotImplement
public interface Mqtt5Disconnect extends Mqtt5Message {

    @NotNull
    static Mqtt5DisconnectBuilder builder() {
        return new Mqtt5DisconnectBuilder();
    }

    /**
     * @return the reason code of this DISCONNECT packet.
     */
    @NotNull
    Mqtt5DisconnectReasonCode getReasonCode();

    /**
     * @return the optional expiry interval for the session, the client disconnects from with this DISCONNECT packet.
     */
    @NotNull
    Optional<Long> getSessionExpiryInterval();

    /**
     * @return the optional server reference, which can be used if the server sent this DISCONNECT packet.
     */
    @NotNull
    Optional<MqttUTF8String> getServerReference();

    /**
     * @return the optional reason string of this DISCONNECT packet.
     */
    @NotNull
    Optional<MqttUTF8String> getReasonString();

    /**
     * @return the optional user properties of this DISCONNECT packet.
     */
    @NotNull
    Mqtt5UserProperties getUserProperties();

}
