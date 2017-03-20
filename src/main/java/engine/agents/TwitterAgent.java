package engine.agents;

import engine.reports.IReport;
import org.joda.time.DateTime;
import ui.configuration.Configurator;
import ui.configuration.IElementValidator;
import ui.configuration.components.Label;
import ui.configuration.components.Radio;
import ui.configuration.components.TextBox;
import ui.configuration.validators.DefaultRadioValidator;

import java.util.Collection;
import java.util.Map;

/**
 * This agent will go out to the twitter API and collect Tweets that are either
 *
 * a) tweeted by a particular user
 * b) contain a particular hashtag
 *
 * That have been tweeted since the last time the agent was run
 *
 * Each returned tweet is included in an individual report, so it's better to schedule these more frequently
 *
 * Created by samuelsmith on 3/19/17.
 */
public class TwitterAgent implements IAgent {

    private final boolean userOrTag;
    private final String identifier;
    private final DateTime cutoff;

    private TwitterAgent(boolean userOrTag, String identifier, DateTime cutoff) {
        this.userOrTag = userOrTag;
        this.identifier = identifier;
        this.cutoff = cutoff;
    }

    @Override
    public Collection<IReport> go() {



        return null;
    }

    @Override
    public Configurator getUI() {

        String content = "Configure this agent to collect tweets by user or hashtag. Do not include @ or # in the search term";
        Label aboutLabel = new Label("about", content);

        Radio userOrTagRadio = new Radio("userOrTagRadio");
        userOrTagRadio.setLabel("User or tag:");
        userOrTagRadio.addOption("User");
        userOrTagRadio.addOption("Hashtag");
        userOrTagRadio.setTooltip("One of these options have to be selected to pass validation");
        userOrTagRadio.addValidator(new DefaultRadioValidator());

        TextBox searchBox = new TextBox("searchBox");
        searchBox.setLabel("Search term:");
        searchBox.setTooltip("Do not include @ or #");
        searchBox.addValidator(toValidate -> {
            if (toValidate.isEmpty()) return "Enter a value for the search box";
            if (toValidate.startsWith("@")) return "Remove @";
            if (toValidate.startsWith("#")) return "Remove #";
            return "";
        });

        Configurator.ConfiguratorBuilder cb = new Configurator.ConfiguratorBuilder();
        try {
            cb.withFirstElement(aboutLabel);
            cb.withNextElement(userOrTagRadio);
            cb.withLastElement(searchBox);
        } catch (Configurator.ConfiguratorBuilder.ConfigurationBuilderException e) {
            //TODO: Real logging and error handling
            e.printStackTrace();
        }

        return cb.build();
    }

    @Override
    public TwitterAgent build(IReport lastReport, Map<String, String> configurations) {
        String userOrTagRadio = configurations.get("userOrTagRadio");
        String identifier = configurations.get("searchBox");
        DateTime cutoff = lastReport.getTimestamp();

        boolean userOrTag = userOrTagRadio.equals("user");

        return new TwitterAgent(userOrTag, identifier, cutoff);
    }
}
