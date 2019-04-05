package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FolderStructure root = new FolderStructure("root");
//        FolderStructure folderStructure = new FolderStructure();
        root.createFolder("USA", root);
        root.createFolder("USA", root);
        root.createFolder("US", root);
        root.deleteFolder("USA", root);

        FileStructure fileStructure = new FileStructure();
        fileStructure.createFile("file.txt", root);
        fileStructure.createFile("file.txt", root);
        fileStructure.createFile("file.txt", root);
        fileStructure.deleteFile("file.txt", root);
    }
}
