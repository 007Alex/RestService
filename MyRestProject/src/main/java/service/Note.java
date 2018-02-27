package service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

@XmlRootElement
public class Note {
    @XmlElement public String id;
    @XmlElement public String title;
    @XmlElement public String text;
    @XmlElement public long date_create;
    @XmlElement public long date_update;

    public Note()
    {
        NewRandomID();
        title = "";
        text = "";
        date_create = System.currentTimeMillis()/1000;
        date_update = date_create;
    }

    public Note(String TITLE, String TEXT)
    {
        NewRandomID();
        title = TITLE;
        text = TEXT;
        date_create = System.currentTimeMillis()/1000;
        date_update = date_create;
    }

    public void ResetUpdateTime()
    {
        date_update = System.currentTimeMillis()/1000;
    }

    public String NewRandomID()
    {
        id = UUID.randomUUID().toString();
        return id;
    }
}
