package net.gameslabs.api;

import java.util.ArrayList;

public interface Player {
    String getId();
    String getName();
    ArrayList<String> getInventory();
}
