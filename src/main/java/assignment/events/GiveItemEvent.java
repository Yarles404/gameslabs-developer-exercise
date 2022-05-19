package assignment.events;

import net.gameslabs.api.Player;
import assignment.api.ItemEvent;

public class GiveItemEvent extends ItemEvent {
    private Boolean success = null;

    public GiveItemEvent(Player player, String itemName) {
        super(player, itemName);
    }

    public boolean giveSuccessful() {
        if (success == null)
            throw new IllegalStateException("GiveItemEvent did not complete");
        return success.booleanValue();
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
