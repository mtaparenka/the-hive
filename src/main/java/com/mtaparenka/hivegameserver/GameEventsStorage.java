package com.mtaparenka.hivegameserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEventsStorage {
    private final Map<String, List<GameEvent>> eventsByGameId = new HashMap<>();

    public void saveEvent(GameEvent event) {
        eventsByGameId.compute(event.gameId, (gameId, events) -> {
            if (events == null) {
                List<GameEvent> newEvents = new ArrayList<>();

                newEvents.add(event);

                return newEvents;
            }

            events.add(event);

            return events;
        });
    }

    public List<GameEvent> getGameEvents(String gameId) {
        return eventsByGameId.get(gameId);
    }

    public GameEvent getLatestGameEvent(String gameId) {
        return eventsByGameId.get(gameId).getLast();
    }
}
