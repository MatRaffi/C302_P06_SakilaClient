package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import java.io.Serializable;

public class CategoryEnhanced implements Serializable {

    private String title;
    private int count;

    public CategoryEnhanced(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
