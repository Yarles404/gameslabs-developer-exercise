package assignment.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;

public class GiveItemEvent extends PlayerEvent {
    private final String item;

    public GiveItemEvent(Player player, String itemName) {
        super(player);
        this.item = itemName;
    }
    
}
