package com.company;

import java.util.ArrayList;
import java.util.HashMap;


public class FolderStructure {
    private String name;
    // list of files
    private ArrayList<FileStructure> files = new ArrayList<>();
    // list of sub folders
    private ArrayList<FolderStructure> sub_folders = new ArrayList<>();
    boolean deleted;
//    HashMap<FolderStructure, FolderStructure> folderToSubFoldersMap = new HashMap<>();

//    HashMap<FileStructure, FolderStructure> filesToFoldersMap = new HashMap<>();

    public FolderStructure()
    {
        this.name = "";
        sub_folders = new ArrayList<>();
        files = new ArrayList<>();
    }

    public FolderStructure(String name) {
        this.name = name;
        sub_folders = new ArrayList<>();
        files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FileStructure> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileStructure> files) {
        this.files = files;
    }

    public ArrayList<FolderStructure> getSub_folders() {
        return sub_folders;
    }

    public void setSub_folders(ArrayList<FolderStructure> sub_folders) {
        this.sub_folders = sub_folders;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    /*boolean Search(String folderName, FolderStructure path) {
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
            FolderStructure folder = new FolderStructure(folderName);
//            path.getSub_folders().add(new FolderStructure(folderName));
            folderToSubFoldersMap.put(folder, path);
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
    public <T, E> T getKeyByValue(HashMap<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }*/
}
