package engine.reports;

import model.ReportLocation;
import model.ReportType;

/**
 * Created by samuelsmith on 3/19/17.
 */
public interface IReport {
    ReportLocation getLocation();
    ReportType getType();
    String getURL();
    String getSnippet();
    String imageURL();
}
