package com.company;

import java.util.*;

public class indexedAllocation extends allocationMethod {
//    HashMap<Integer, ArrayList> blockToBlockListMap = new HashMap<>();

    @Override
    public boolean createFile(FolderStructure directory, String name, int size, ArrayList<Space> spaces,
                              ArrayList<Boolean> state) {
        ArrayList<Integer> allocatedBlocks = new ArrayList<>();
        int fileSize = size;

        //If the file name isn't exist before, then try to allocate a space for it.
        if (searchFile(name, directory) < 0) {
            //For every block(1 KB) of the file.
            for (int i = 0, stateSize = state.size(); i < stateSize; i++) {
                //if there is a free space, allocate this space and then mark this place as not free!
                if (!state.get(i)) {
                    allocatedBlocks.add(i);
                    state.set(i, true);
                    size--;
                }
                //The file allocated successfully :D
                if (size == 0) {
                    FileStructure file = new FileStructure(name, allocatedBlocks);
                    directory.getFiles().add(file);
                    file.setSize(fileSize);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean createFolder(FolderStructure directory, String name) {
        //If the folder name isn't exist before, then try to allocate a space for it.
        if (searchFolder(name, directory) < 0) {
            directory.getSub_folders().add(new FolderStructure(name));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFile(FolderStructure directory, String name,
                              ArrayList<Boolean> state) {
        //If file exists, delete it!
        int index = searchFile(name, directory);
        FileStructure file = directory.getFiles().get(index);
        if (index >= 0) {
            directory.getFiles().remove(index);

            for (int i = 0, siz = file.getAllocatedBlocks().size(); i < siz; i++) {
                state.set(file.getAllocatedBlocks().get(i), false);
            }
            file.setDeleted(true);
            //Update the size after deletion
            file.setSize(file.getAllocatedBlocks().size());
        }

//        if(searchFile(name, directory))
//        {
//            FileStructure file = (FileStructure) directory.getKeyByValue(directory.filesToFoldersMap, directory.);
////            for (int i = 0; i < file.allocatedBlocks.size(); i++) {
////                state.set(file.allocatedBlocks.get(i), false);
////            }
//            directory.filesToFoldersMap.remove(name, directory);
//            return true;
//        }
        return false;
    }

    @Override
    public int deleteFolder(String name, FolderStructure directory, ArrayList<Boolean> state) {
        int index = searchFolder(name, directory);
        int space = 0; // space = space of its folders + space of files
        FolderStructure folder = directory.getSub_folders().get(index);
        if (index >= 0) {
            //Delete the files in this folder
            for (FileStructure f:
            folder.getFiles()) {
                for (int i = 0, siz = f.getAllocatedBlocks().size(); i < siz; i++) {
                    state.set(f.getAllocatedBlocks().get(i), false);
                }
                f.setDeleted(true);
                //Space of files
                space += f.getAllocatedBlocks().size();
            }
            for (FolderStructure fo:
                 folder.getSub_folders()) {
                String entireFolder = fo.getName();
                space += deleteFolder(entireFolder, fo, state);
            }
            directory.getSub_folders().remove(index);
            return 1;
        }
        return 0;
//            for (int i = 0; i < file.allocatedBlocks.size(); i++) {
//                state.set(file.allocatedBlocks.get(i), false);
//            }
//            totalspace += file.allocatedBlocks.size();
//
//            for (Directory dire1 : dir.subDirectory) {
//                totalspace += deleteDir(dire1, spaces, state);
//            }
//            return true;
//        }
//        return false;
    }
}
