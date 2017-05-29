package com.tamvan.kisah25nabi.holder;

import java.io.Serializable;

/**
 * Created by Rofie on 10/29/2016.
 */
public class Story implements Serializable {
    private String _title;
    private String _contents;

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_contents() {
        return _contents;
    }

    public void set_contents(String _contents) {
        this._contents = _contents;
    }
}
