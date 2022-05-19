package assignment.events;

import net.gameslabs.api.Player;
import assignment.api.ItemEvent;

public class CheckItemEvent extends ItemEvent {
    private Boolean hasItem = null;

    public CheckItemEvent(Player player, String itemName) {
        super(player, itemName);
    }

    public boolean hasItem() {
        if (hasItem == null)
            throw new IllegalStateException("CheckItemEvent did not complete");
        return hasItem.booleanValue();
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
}
