package homework.webapp.beans;

import java.io.Serializable;

public class NewsContent implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String content;
    private String contentType;
    private int newsHeaderId;

    public NewsContent() {
    }

    public NewsContent(String content, String contentType, int newsHeaderId) {
        this.content = content;
        this.contentType = contentType;
        this.newsHeaderId = newsHeaderId;
    }

    public NewsContent(int id, String content, String contentType, int newsHeaderId) {
        this.id = id;
        this.content = content;
        this.contentType = contentType;
        this.newsHeaderId = newsHeaderId;
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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getNewsHeaderId() {
        return newsHeaderId;
    }

    public void setNewsHeaderId(int newsHeaderId) {
        this.newsHeaderId = newsHeaderId;
    }
}
