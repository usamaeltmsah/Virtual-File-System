package com.company;

public class FileStructure {
    private String name;
    private int Size;
    private String fileContent;

    FileStructure() {
        this.name = "";
        this.Size = 0;
        this.fileContent = "";
    }

    FileStructure(String Name) {
        this.name = Name;
        this.Size = 0;
        this.fileContent = "";
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
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

    boolean Search(String fileName, FolderStructure path) {
        if (path.filesToFoldersMap.get(fileName) != null)
            return true;
        return false;
    }

    boolean createFile(String fileName, FolderStructure path) {
        //If file isn't exist, then create it!
        if(!Search(fileName, path))
        {
//            path.getFiles().add(new FileStructure(fileName));
            path.filesToFoldersMap.put(fileName, path);
            return true;
        }

        return false;
    }

    boolean deleteFile(String fileName, FolderStructure path) {
        //If file exists, delete it!
        if(Search(fileName, path))
        {
            path.filesToFoldersMap.remove(fileName, path);
            return true;
        }
        return false;
    }
}
