package ceit.aut.ac.ir.model;

import java.io.Serializable;

public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    public String getTitle(){
        return this.title;
    }

    public String getContent() {
        return content;
    }

    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", date='" + date + '\'' + '}';
    }
}

