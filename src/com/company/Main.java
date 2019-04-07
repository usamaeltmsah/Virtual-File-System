package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        indexedAllocation i = new indexedAllocation();
        FolderStructure f = new FolderStructure("root");
        ArrayList<Space> spaces = new ArrayList<>();
        ArrayList<Boolean> stat = new ArrayList<>();
        for (int j = 0; j < 1000; j++) {
            Space s = new Space(0, 1000, true);
            spaces.add(j, s);
            stat.add(false);
        }
        i.createFile(f, "os", 10, spaces, stat);
        i.createFolder(f, "MY");
        i.createFile(f.getSub_folders().get(0), "op", 10, spaces, stat);
        i.createFile(f, "om", 10, spaces, stat);
        i.deleteFolder("MY", f, stat);
    }
}
