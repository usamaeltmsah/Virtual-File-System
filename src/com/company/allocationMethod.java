package com.company;

import java.util.ArrayList;

public abstract class allocationMethod {
    int searchFile(String fileName, FolderStructure directory) {
        //Search on the file in the ArrayList.
        for (FileStructure f:
             directory.getFiles()) {
            if(f.getName().equals(fileName))
                return directory.getFiles().indexOf(f);
        }
        return -1;
    }

    int searchFolder(String folderName, FolderStructure directory) {
        for (FolderStructure fo:
             directory.getSub_folders()) {
            if (fo.getName().equals(folderName))
                return directory.getSub_folders().indexOf(fo);
        }
        return -1;
    }

    abstract boolean createFile(FolderStructure directory, String name, int size, ArrayList<Space> spaces, ArrayList<Boolean> state);

    abstract boolean createFolder(FolderStructure directory, String name);

    abstract boolean deleteFile(FolderStructure directory, String name, ArrayList<Boolean> state);

    abstract int deleteFolder(String name, FolderStructure directory, ArrayList<Boolean> state);

}
