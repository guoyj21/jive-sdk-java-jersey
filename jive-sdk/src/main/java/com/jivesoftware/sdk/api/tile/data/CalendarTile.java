package com.jivesoftware.sdk.api.tile.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by rrutan on 2/4/14.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class CalendarTile extends BaseTile implements Serializable {
    public static final String TYPE = "CALENDAR";

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String title;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private List<CalendarEvent> events;

    private TileAction action;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private Map<String,Object> config;

    public CalendarTile() {
        title = null;
        events = Lists.newArrayList();
        action = null;
        config = Maps.newHashMap();
    } // end constructor

    public void addCalendarEvent(CalendarEvent event) {
      events.add(event);
    } // end addCalendarEvent

    public void removeCalendarEvent(CalendarEvent event) {
      events.remove(event);
    } // end removeCalendarEvent

    public void setLocationDisplay(boolean locationDisplay) {
        config.put("locationDisplay",locationDisplay);
    } // end setLocationDisplay

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }

    public TileAction getAction() {
        return action;
    }

    public void setAction(TileAction action) {
        this.action = action;
    }

    public Map<String, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarTile that = (CalendarTile) o;

        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;
        if (events != null ? !events.equals(that.events) : that.events != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (config != null ? config.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JiveCalendarTile{" +
                "title='" + title + '\'' +
                ", events=" + events +
                ", action=" + action +
                ", config=" + config +
                '}';
    }

} // end class
