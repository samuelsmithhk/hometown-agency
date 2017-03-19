package engine.agents;


import engine.reports.IReport;
import ui.configuration.Configurator;

import java.util.Map;

/**
 * Created by samuelsmith on 3/19/17.
 *
 * This interface can be implemented by any class that wants to be loaded by the agency at runtime.
 *
 * An Agent is a single-purpose object that, when executed, will go forth and do its task - producing a "report"
 * for the agency, which the agency will then persist. Such agents may be collecting news stories, getting the weather,
 * or collecting tweets.
 *
 */
public interface IAgent {

    /**
     * This method will be called by the agency, and is where the agent's execution process will
     * begin.
     * @return An IReport containing the agent's findings
     */
    IReport go();

    /**
     * Most of the time, an agent will require configuration. Configuration is done by the user via the UI.
     * Use ConfiguratorBuilder to create a Configuration window for your agent
     * @return A configurator that can be rendered by the agency's UI.
     */
    Configurator getUI();

    /**
     * The instance of the class will be built by calling this method. The keys of the map are the fields specified
     * in the Configurator, the values are the values set by the user in the UI.
     * @param configurations
     */
    void build(Map<String, String> configurations);

}
