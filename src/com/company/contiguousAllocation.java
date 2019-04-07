package com.company;

import java.util.ArrayList;

public class contiguousAllocation extends allocationMethod {
    @Override
    boolean createFile(FolderStructure directory, String name, int size, ArrayList<Space> spaces, ArrayList<Boolean> state) {
        return false;
    }

    @Override
    boolean createFolder(FolderStructure directory, String name) {
        return false;
    }

    @Override
    boolean deleteFile(FolderStructure directory, String name, ArrayList<Boolean> state) {
        return false;
    }

    @Override
    int deleteFolder(String name, FolderStructure directory, ArrayList<Boolean> state) {
        return 0;
    }
}
