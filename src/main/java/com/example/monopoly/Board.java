package com.example.monopoly;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int maxPlaceId = 40;

    private Map<Integer, Place> places;

    public Board() {
        places = new HashMap<>();
        initializePlaces();
    }

    private void initializePlaces() {
        places.put(1, new Place("Mediterranean Avenue", "purple", 60, 2, "bank"));
        places.put(2, new Place("Community Chest 1", "chest", 0, 0, null));
        places.put(3, new Place("Baltic Avenue", "purple", 60, 4, "bank"));
        places.put(4, new Place("Income Tax", "tax", 0, 0, null));
        places.put(5, new Place("Reading Railroad", "railroad", 200, 0, "bank"));
        places.put(6, new Place("Oriental Avenue", "light blue", 100, 6, "bank"));
        places.put(7, new Place("Chance 1", "chance", 0, 0, null));
        places.put(8, new Place("Vermont Avenue", "light blue", 100, 6, "bank"));
        places.put(9, new Place("Connecticut Avenue", "light blue", 120, 8, "bank"));
        places.put(10, new Place("Jail - Just Visiting", "corner", 0, 0, null));
        places.put(11, new Place("St. Charles Place", "pink", 140, 10, "bank"));
        places.put(12, new Place("Electric Company", "utility", 150, 0, "bank"));
        places.put(13, new Place("States Avenue", "pink", 140, 10, "bank"));
        places.put(14, new Place("Virginia Avenue", "pink", 160, 12, "bank"));
        places.put(15, new Place("Pennsylvania Railroad", "railroad", 200, 0, "bank"));
        places.put(16, new Place("St. James Place", "orange", 180, 14, "bank"));
        places.put(17, new Place("Community Chest 2", "chest", 0, 0, null));
        places.put(18, new Place("Tennessee Avenue", "orange", 180, 14, "bank"));
        places.put(19, new Place("New York Avenue", "orange", 200, 16, "bank"));
        places.put(20, new Place("Free Parking", "corner", 0, 0, null));
        places.put(21, new Place("Kentucky Avenue", "red", 220, 18, "bank"));
        places.put(22, new Place("Chance 2", "chance", 0, 0, null));
        places.put(23, new Place("Indiana Avenue", "red", 220, 18, "bank"));
        places.put(24, new Place("Illinois Avenue", "red", 240, 20, "bank"));
        places.put(25, new Place("B & O Railroad", "railroad", 200, 0, "bank"));
        places.put(26, new Place("Atlantic Avenue", "yellow", 260, 22, "bank"));
        places.put(27, new Place("Ventnor Avenue", "yellow", 260, 22, "bank"));
        places.put(28, new Place("Water Works", "utility", 150, 0, "bank"));
        places.put(29, new Place("Marvin Gardens", "yellow", 280, 24, "bank"));
        places.put(30, new Place("Go To Jail", "corner", 0, 0, null));
        places.put(31, new Place("Pacific Avenue", "green", 300, 26, "bank"));
        places.put(32, new Place("North Carolina Avenue", "green", 300, 26, "bank"));
        places.put(33, new Place("Community Chest 3", "chest", 0, 0, null));
        places.put(34, new Place("Pennsylvania Avenue", "green", 320, 28, "bank"));
        places.put(35, new Place("Short Line Railroad", "railroad", 200, 0, "bank"));
        places.put(36, new Place("Chance 3", "chance", 0, 0, null));
        places.put(37, new Place("Park Place", "indigo", 350, 35, "bank"));
        places.put(38, new Place("Luxury Tax", "tax", 0, 0, null));
        places.put(39, new Place("Boardwalk", "indigo", 400, 50, "bank"));
        places.put(40, new Place("Go", "corner", 0, 0, null));
    }
    

    public String getPlaceName(int placeID) {
        return getPlace(placeID).getName();
    }

    public String getPlaceGroup(int placeID) {
        return getPlace(placeID).getGroup();
    }

    public String getPlaceOwner(int placeID) {
        Place place = getPlace(placeID);
        if (place.getOwner() == null) {
            throw new IllegalArgumentException("This place can't be owned");
        }
        return place.getOwner();
    }

    public int getPlacePrice(int placeID) {
        Place place = getPlace(placeID);
        if (place.getPrice() == 0) {
            throw new IllegalArgumentException("This place can't be sold");
        }
        return place.getPrice();
    }

    public int getPropertyRent(int placeID) {
        Place place = getPlace(placeID);
        if (place.getRent() == 0) {
            throw new IllegalArgumentException("This place doesn't have a rent");
        }
        return place.getRent();
    }

    public Place getPlace(int placeID) {
        if (placeID < 1 || placeID > maxPlaceId) {
            throw new IllegalArgumentException("Place doesn't exist");
        }
        return places.get(placeID);
    }
}
