package ui.configuration.components;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.configuration.IElementValidator;
import ui.configuration.IUserInterfaceElement;

/**
 * Created by samuelsmith on 3/19/17.
 */
public class Label implements IUserInterfaceElement {

    private final String field, content;

    public Label(String field, String content) {
        this.field = field;
        this.content = content;
    }
    @Override
    public String getJSON() {
        return "{\"field\":\"" + field + "\",\"type\":\"label\",\"content\":\"" + content + "\"}";
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public void addValidator(IElementValidator validator) { /* do nothing */}

    @Override
    public IElementValidator getValidator() {
        return null;
    }
}
