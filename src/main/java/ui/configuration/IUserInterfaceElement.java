package ui.configuration;

/**
 * Created by samuelsmith on 3/19/17.
 */
public interface IUserInterfaceElement {

    /**
     * @return Returns a json representation of this element so that the UI can render it
     */
    String getJSON();

    /**
     *
     * @return Returns the string name of the field, for mapping the configuration back to the class
     */
    String getField();
}
