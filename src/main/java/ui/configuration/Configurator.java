package ui.configuration;

import java.util.*;

/**
 * Created by samuelsmith on 3/19/17.
 */
public class Configurator {

    private final String json;

    private Configurator(String json) {
        this.json = json;
    }


    public static class ConfiguratorBuilder {
        List<IUserInterfaceElement> elements;
        Set<String> keys;
        boolean firstSet = false, lastSet = false;

        public ConfiguratorBuilder() {
            elements = new LinkedList<>();
            keys = new HashSet<>();
        }

        public ConfiguratorBuilder withFirstElement(IUserInterfaceElement element)
                throws ConfigurationBuilderException {
            if (firstSet) throw new ConfigurationBuilderException("First element already set");
            firstSet = true;

            elements.add(element);
            return this;
        }

        public ConfiguratorBuilder withNextElement(IUserInterfaceElement element)
                throws ConfigurationBuilderException {
            if (!firstSet) throw new ConfigurationBuilderException("Must set first element");
            if (lastSet) throw new ConfigurationBuilderException("Last element has already been set");
            if (keys.contains(element.getField()))
                throw new ConfigurationBuilderException("Key already exists in configuration");

            elements.add(element);
            return this;
        }

        public ConfiguratorBuilder withLastElement(IUserInterfaceElement element)
                throws ConfigurationBuilderException {
            if (!firstSet) throw new ConfigurationBuilderException("Must set first element");
            if (lastSet) throw new ConfigurationBuilderException("Last element has already been set");
            if (keys.contains(element.getField()))
                throw new ConfigurationBuilderException("Key already exists in configuration");
            lastSet = true;

            elements.add(element);
            return this;
        }

        public Configurator build() {
            StringBuilder sb = new StringBuilder("[");

            for (IUserInterfaceElement element : elements) {
                sb.append(element.getJSON());
            }

            sb.append("]");

            return new Configurator(sb.toString());
        }

        public static class ConfigurationBuilderException extends Exception {
            ConfigurationBuilderException(String message) {
                super(message);
            }
        }
    }
}
