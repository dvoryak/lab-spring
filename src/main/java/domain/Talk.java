package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Talk {
    private String title;
    private String about;
    private Set<Speaker> speakers;

    public Talk(String title, Set<Speaker> speakers) {
        this.title = title;
        this.speakers = speakers;
    }

    public Talk() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", speakers=" + speakers +
                '}';
    }
}
