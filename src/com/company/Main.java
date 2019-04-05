package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FolderStructure root = new FolderStructure("root");
        FolderStructure f = new FolderStructure("sc");
        root.createFolder("US", root);
        root.deleteFolder("USA", root);

        FileStructure fileStructure = new FileStructure();
        fileStructure.createFile("file.txt", root);
        fileStructure.createFile("ps.txt", f);

        fileStructure.deleteFile("file.txt", root);
    }
}
