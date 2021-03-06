package seedu.address.ui.list;

import seedu.address.ui.DisplaySystemType;

/**
 * An item to be displayed in a list in the Pet Store Helper.
 *
 * Any class that is intended to be displayed as an item in a list in the Pet
 * Store Helper should implement this interface.
 */
public interface DisplayItem {
    /**
     * Returns the type of system that this item constitutes of.
     */
    DisplaySystemType getDisplaySystemType();
}
