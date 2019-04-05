package com.company;

import java.util.HashMap;

public class FolderStructure {
    private String name;

    HashMap<String, FolderStructure> folderToSubFoldersMap = new HashMap<>();

    HashMap<String, FolderStructure> filesToFoldersMap = new HashMap<>();

    public FolderStructure()
    {
        this.name = "";
    }

    public FolderStructure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

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
