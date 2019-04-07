package com.company;

import java.util.ArrayList;

public class FileStructure {
    private ArrayList<Integer> allocatedBlocks;
    private String name;
    private int Size;
    private boolean deleted;

    FileStructure() {
        this.name = "";
        this.Size = 0;
        deleted = false;
    }

    FileStructure(String Name) {
        this.name = Name;
        this.Size = 0;
        deleted = false;
    }


    public FileStructure( String name, ArrayList<Integer> allocatedBlocks) {
        this.allocatedBlocks = allocatedBlocks;
        this.name = name;
        deleted = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public ArrayList<Integer> getAllocatedBlocks() {
        return allocatedBlocks;
    }

    public void setAllocatedBlocks(ArrayList<Integer> allocatedBlocks) {
        this.allocatedBlocks = allocatedBlocks;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
