package com.company;

import java.util.ArrayList;

public class linkedAllocation extends allocationMethod {
    @Override
    boolean createFile(FolderStructure directory, String name, int size, ArrayList<Space> spaces, ArrayList<Boolean> state) {
        return false;
    }

    @Override
    boolean createFolder(FolderStructure directory, String name) {
        return false;
    }

    @Override
    int deleteFile(FolderStructure directory, String name, ArrayList<Space> spaces, ArrayList<Boolean> state) {
        return 0;
    }

    @Override
    int deleteFolder(FolderStructure folder, FolderStructure directory, ArrayList<Space> spaces, ArrayList<Boolean> state) {
        return 0;
    }
}
