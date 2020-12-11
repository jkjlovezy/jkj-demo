package com.study.util.split;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class TagPath {
    @JSONField(ordinal=1)
    private String path;
    @JSONField(ordinal=2)
    private String name;
    @JSONField(serialize = false)
    private TagPath parent;
    @JSONField(ordinal=3)
    private List<TagPath> childrens = new ArrayList<>();

    public TagPath() {

    }

    public TagPath(String path) {
        this.path = path;
    }

    public TagPath(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public TagPath getParent() {
        return parent;
    }

    @JsonIgnore
    public void setParent(TagPath parent) {
        this.parent = parent;
    }

    public List<TagPath> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TagPath> childrens) {
        this.childrens = childrens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagPath tagPath = (TagPath) o;
        return path.equals(tagPath.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String toString() {
        return "TagPath{" +
                "path='" + path + '\'' +
                '}';
    }
}
