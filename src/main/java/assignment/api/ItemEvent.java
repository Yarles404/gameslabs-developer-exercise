package assignment.api;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;

public abstract class ItemEvent extends PlayerEvent {
    private final String item;

    public ItemEvent(Player player, String itemName) {
        super(player);
        this.item = itemName;
    }

    public String getItem() {
        return item;
    }
}
