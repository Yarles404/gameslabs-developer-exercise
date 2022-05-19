package assignment.components;

import net.gameslabs.api.Component;

import java.util.ArrayList;

import assignment.events.*;

public class MyInventoryComponent extends Component {

    @Override
    public void onLoad() {
        registerEvent(GiveItemEvent.class, this::onGiveItem);
        registerEvent(CheckItemEvent.class, this::onCheckItem);
        registerEvent(RemoveItemEvent.class, this::onRemoveItem);
    }

    private void onGiveItem(GiveItemEvent event) {
        ArrayList<String> playerInventory = event.getPlayer().getInventory();
        event.setSuccess(playerInventory.add(event.getItem()));
    }

    private void onCheckItem(CheckItemEvent event) {
        ArrayList<String> playerInventory = event.getPlayer().getInventory();
        event.setHasItem(playerInventory.contains(event.getItem()));
    }

    private void onRemoveItem(RemoveItemEvent event) {
        ArrayList<String> playerInventory = event.getPlayer().getInventory();
        event.setSuccess(playerInventory.remove(event.getItem()));
    }

    @Override
    public void onUnload() {
        // Do nothing
    }
}
