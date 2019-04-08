package com.company;

public class Parser {
    public String[] args;
    public String cmd = "";
    Parser(String CMD, allocationMethod i, system soso)
    {
        String[] dummy ;
        dummy = CMD.split(" ");
        //MUST BE ONE space after the command name(ie. createfile, createfolder or ...).
        if ((dummy.length > 2 && !dummy[0].equals("CreateFile"))
            || dummy.length < 3 && dummy[0].equals("CreateFile") || dummy.length < 2)
            return;
        else
        {
//            String[] dummy2;
//            dummy2 = dummy[1].split("[/]");
            switch (dummy[0])
            {
                case "CreateFile":
                    int fileSize = Integer.parseInt(dummy[2]);
                    soso.createFile(dummy[1], fileSize);
                    break;
                case "CreateFolder":
                    soso.createFolder(dummy[1]);
                    break;
                case "DeleteFile":
                    soso.deleteFile(dummy[1]);
                    break;
                case "DeleteFolder":
                    soso.deleteFolder(dummy[1]);
                    break;
                case "DisplayDiskStatus":

                    break;
                case "DisplayDiskStructure":

                    break;
                default:
                    System.out.println("No match command for " + "\"" + dummy[0] + "\"");
            }

        }
    }
}