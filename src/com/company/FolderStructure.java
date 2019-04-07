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
}
