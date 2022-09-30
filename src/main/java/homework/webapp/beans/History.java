package homework.webapp.beans;

import java.io.Serializable;

public class History implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String content;
    private String type;
    private int manufacturerID;

    public History() {
    }

    public History(String content, String type, int manufacturerID) {
        this.content = content;
        this.type = type;
        this.manufacturerID = manufacturerID;
    }

    public History(int id, String content, String type, int manufacturerID) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.manufacturerID = manufacturerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }
}
