package com.company;

public class Parser {
    public String[] args;
    public String cmd = "";
    public int cmdsNum;
    public int foldersNum;
    Parser(String CMD)
    {
        String[] dummy ;
        dummy = CMD.split(" ");
        //MUST BE ONE after the command name(ie. createfile, createfolder or ...).
        if (dummy.length > 1)
            return;

        cmdsNum = dummy.length;

        String[] dummy2;
        dummy2 = dummy[1].split("[/]");

    }
}