package com.study.util.split;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

public class SplitPathTest {
    public static void main(String[] args) {
        String path = "a1/a2/a3";
        String path2 = "b1/b2/b3";
        String path3 = "a1/a2/a4";
        Arrays.stream(path.split("/")).forEach(System.out::println);
        TagPath root = new TagPath("/","/");
        merge(path, root);
        merge(path2, root);
        merge(path3, root);
        System.out.println(JSON.toJSONString(root));
    }

    private static void merge(String path, TagPath parent) {
        String[] paths = path.split("/");
        String prefix = "/";
        for (int i = 0; i < paths.length; i++) {
            TagPath tagPath = new TagPath(prefix + paths[i],paths[i]);
            parent = merge(tagPath, parent);
            prefix = prefix + paths[i] + "/";
        }
    }

    private static TagPath merge(TagPath tagPath, TagPath parent) {
        if (!parent.getChildrens().contains(tagPath)) {
            parent.getChildrens().add(tagPath);
            tagPath.setParent(parent);
        }
        return parent.getChildrens().stream().filter(t -> t.getPath().equals(tagPath.getPath())).findFirst().get();
    }
}
