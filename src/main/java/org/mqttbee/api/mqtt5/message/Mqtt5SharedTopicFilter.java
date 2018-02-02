package org.mqttbee.api.mqtt5.message;

import org.mqttbee.annotations.NotNull;
import org.mqttbee.mqtt5.message.Mqtt5SharedTopicFilterImpl;

/**
 * MQTT Shared Topic Filter according to the MQTT 5 specification.
 * <p>
 * A Shared Topic Filter consists of the {@link #SHARE_PREFIX} a Share Name and a Topic Filter. The Share Name has the
 * restrictions from {@link Mqtt5UTF8String}, must be at least 1 character long and mut not contain wildcards ({@link
 * Mqtt5TopicFilter#MULTI_LEVEL_WILDCARD}, {@link Mqtt5TopicFilter#SINGLE_LEVEL_WILDCARD}) and the {@link
 * Mqtt5Topic#TOPIC_LEVEL_SEPARATOR}. The Topic Filter has the same restrictions from {@link Mqtt5TopicFilter}.
 *
 * @author Silvio Giebl
 */
public interface Mqtt5SharedTopicFilter extends Mqtt5TopicFilter {

    /**
     * The prefix of a Shared Topic Filter.
     */
    String SHARE_PREFIX = "$share" + Mqtt5Topic.TOPIC_LEVEL_SEPARATOR;

    /**
     * Validates and creates a Shared Topic Filter from the given Share Name and the given Topic Filter.
     *
     * @param shareName   the Share Name.
     * @param topicFilter the Topic Filter.
     * @return the created Shared Topic Filter.
     * @throws IllegalArgumentException if the Share Name is not a valid Share Name or the Topic Filter is not a valid
     *                                  Topic Filter.
     */
    @NotNull
    static Mqtt5SharedTopicFilter from(@NotNull final String shareName, @NotNull final String topicFilter) {
        final Mqtt5SharedTopicFilter sharedTopicFilter = Mqtt5SharedTopicFilterImpl.from(shareName, topicFilter);
        if (sharedTopicFilter == null) {
            throw new IllegalArgumentException("The shareName: [" + shareName + "] is not a valid Topic Name.");
        }
        return sharedTopicFilter;
    }

    /**
     * @return the Share Name of this Shared Topic Filter as a string.
     */
    String getShareName();

    /**
     * @return the Topic Filter of this Shared Topic Filter as a string.
     */
    String getTopicFilter();

}