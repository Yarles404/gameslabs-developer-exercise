package assignment.events;

import net.gameslabs.api.Player;
import assignment.api.ItemEvent;

public class RemoveItemEvent extends ItemEvent {
    private Boolean success = null;

    public RemoveItemEvent(Player player, String itemName) {
        super(player, itemName);
    }

    public boolean removeSuccessful() {
        if (success == null)
            throw new IllegalStateException("RemoveItemEvent did not complete");
        return success.booleanValue();
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
