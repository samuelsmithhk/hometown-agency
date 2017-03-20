package engine.reports;

import model.ReportLocation;
import model.ReportType;
import org.joda.time.DateTime;

import java.util.Collection;

/**
 * This interface encapsulates the report that an agent may produce, this report will have two functions:
 *
 * 1) Stored in the document store to be used by other parts of the system
 * 2) Given back to the agent during the next runtime, to provide any data to the agent.  This report class can be used
 * as "scratch space" between agent runs.
 *
 * NOTE: An agent can produce multiple reports in one go, but only one will be given to the agent the next run, the one
 * given will be the one with the latest timestamp returned from getTimestamp()
 * Created by samuelsmith on 3/19/17.
 */
public interface IReport {
    /**
     * As this service is geolocation based, reports need to be specific to certain places
     * @return The locations that the report's data is relevant to.
     */
    Collection<ReportLocation> getLocations();

    /**
     * What kind of data is included in this report? Tweets? News? Weather? etc
     * @return
     */
    ReportType getType();

    /**
     * All reports have a source, this url will link to that source
     * @return
     */
    String getURL();

    /**
     * In the app, the snippet is used to pique a user's interest to try and get them to click (clicking will redirect
     * to the url returned by getURL)
     * @return
     */
    String getSnippet();

    /**
     * Reports may have a related image to go along with the snippet in the app. If no image, return null
     * @return
     */
    String imageURL();

    /**
     * This is used by the agency to aid with its scheduling of new reports.
     * @return
     */
    DateTime getTimestamp();
}
