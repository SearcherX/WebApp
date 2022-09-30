package homework.webapp.beans;

import java.io.Serializable;

public class NewsHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String content;
    private String pic;
    private int manufacturerId;

    public NewsHeader() {
    }

    public NewsHeader(String content, String pic, int manufacturerId) {
        this.content = content;
        this.pic = pic;
        this.manufacturerId = manufacturerId;
    }

    public NewsHeader(int id, String content, String pic, int manufacturerId) {
        this.id = id;
        this.content = content;
        this.pic = pic;
        this.manufacturerId = manufacturerId;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
