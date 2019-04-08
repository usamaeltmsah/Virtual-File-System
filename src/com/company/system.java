package com.company;

import java.util.ArrayList;

public class system {
    private int size;
    private int space = 0;
    private allocationMethod allocationMethod;
    private FolderStructure root;
    private ArrayList<Boolean> state;
    private ArrayList<Space> spaces;

    public system(int size, allocationMethod allocationMethod) {
        this.size = size;
        this.allocationMethod = allocationMethod;
        setState(new ArrayList<>());
        for (int i = 0; i < size; i++)
        {
            getState().add(i, false);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public allocationMethod getAllocationMethod() {
        return allocationMethod;
    }

    public void setAllocationMethod(allocationMethod allocationMethod) {
        this.allocationMethod = allocationMethod;
    }

    public FolderStructure getRoot() {
        return root;
    }

    public void setRoot(FolderStructure root) {
        this.root = root;
    }

    public ArrayList<Boolean> getState() {
        return state;
    }

    public void setState(ArrayList<Boolean> state) {
        this.state = state;
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(ArrayList<Space> spaces) {
        this.spaces = spaces;
    }

    public FolderStructure getFolder(FolderStructure folder, String[] path, int level) {
        //If you found the folder just return it!
        if(path.length == 1)
            return folder;
        //Otherwise try to find it in the subfolders till you reach it
        for (FolderStructure f
                : folder.getSub_folders()) {
            //If you found the folderName in the subfolder, but it's not the path you search
            //Then, try in the sub-subfolder (by going to the next level)
            if (path[level + 1].equals(f.getName()) && level != path.length - 2) {
                return getFolder(f, path, level + 1);
            }
        }
        //If you found the folderName in the subfolder and this's your goal, then return it
        if (path[level].equals(folder.getName()) && level == path.length - 2) {
            return folder;
        }
        //Otherwise the folder isn't exist!
        return null;
    }

    public boolean createFile(String path, int size) {
        //You can't create file with size greater than disk size!
        if (size > (this.getSize() - this.getSpace()))
            return false;

        String[] paths = path.split("/");
        FolderStructure fold;
        //Find the folder which I need to create my file in
        fold = getFolder(this.getRoot(), paths, 0);
        //If you find it successfully!
        if (fold != null) {
            //If file successfully created, then the space will be decreased.
            //paths[paths.length - 1]: The last one is my file name
            if (this.getAllocationMethod().createFile(fold, paths[paths.length - 1], size, this.getSpaces(),
                    this.getState())) {
                this.setSpace(space + size);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean createFolder(String path) {
        String[] paths = path.split("/");
        FolderStructure fold;
        //Search on the folder, if not exists, then create it.
        fold = getFolder(this.getRoot(), paths, 0);
        if (fold != null)
            return this.getAllocationMethod().createFolder(fold, paths[paths.length - 1]);
        else
            return false;
    }

    public boolean deleteFile(String path) {
        String[] paths = path.split("/");
        FolderStructure fold;
        fold = getFolder(this.getRoot(), paths, 0);
        if (fold != null) {
            int fileSize = this.getAllocationMethod().deleteFile(fold, paths[paths.length - 1],
                    this.getSpaces(), this.getState());
            if (fileSize != 0) {
                this.setSpace(this.getSpace() - fileSize);
                return true;
            }
            return false;
        } else
            return false;
    }

    public boolean deleteFolder(String path) {
        String[] paths = path.split("/");
        FolderStructure fold;
        fold = getFolder(this.getRoot(), paths, 0);
        if (fold != null) {
            int filesSize = getAllocationMethod().deleteFolder(fold, this.getRoot(), this.getSpaces(), this.getState());
            if (filesSize != 0) {
                this.setSpace(this.getSpace() - filesSize);
                return true;
            }
            return false;
        } else
            return false;
    }
}