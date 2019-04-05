package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class FolderStructure {
    private String name;

    // list of files
//    private ArrayList<FileStructure> files = new ArrayList<>();

    // list of sub folders
//    private ArrayList<FolderStructure> sub_folders = new ArrayList<>();

    HashMap<String, FolderStructure> folderToSubFoldersMap = new HashMap<>();

    HashMap<String, FolderStructure> filesToFoldersMap = new HashMap<>();

    public FolderStructure()
    {
//        sub_folders = new ArrayList<>();
        this.name = "";
    }

    public FolderStructure(String name) {
//        sub_folders = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<FileStructure> getFiles() {
//        return this.files;
//    }

//    public void setFiles(ArrayList<FileStructure> files) {
//        this.files = files;
//    }
//
//    public ArrayList<FolderStructure> getSub_folders() {
//        return this.sub_folders;
//    }

//    public void setSub_folders(ArrayList<FolderStructure> sub_folders) {
//        this.sub_folders = sub_folders;
//    }

    boolean Search(String folderName, FolderStructure path) {
        if (folderToSubFoldersMap.get(folderName) != null)
        {
            return true;
        }
        return false;
    }

    public boolean createFolder(String folderName, FolderStructure path)
    {
        //If folder isn't exist, so create it!
        if (!Search(folderName, path))
        {
//            path.getSub_folders().add(new FolderStructure(folderName));
            folderToSubFoldersMap.put(folderName, path);
            return true;
        }
        return false;
    }

    boolean deleteFolder(String folderName, FolderStructure path) {
        //If folder exists, delete it!
        if(Search(folderName, path))
        {
            path.folderToSubFoldersMap.remove(folderName, path);
            return true;
        }
        return false;
    }
}
