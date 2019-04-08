package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        allocationMethod i = null;
        String choice;
        System.out.println("1- Contiguous Allocation.\n2- Indexed Allocation\n3- Linked Allocation");
        choice = new Scanner(System.in).next();
        
        switch (choice){
            case "1":
                i = new contiguousAllocation();
                break;
            case "2":
                i = new indexedAllocation();
                break;
            case "3":
                i = new linkedAllocation();
        }
        String cmd = "";
        system sys = new system(100, i);
        FolderStructure root = new FolderStructure("root");
        sys.setRoot(root);

        while (!cmd.equals("0"))
        {
            cmd = new Scanner(System.in).nextLine();

            Parser p = new Parser(cmd, i, sys);
        }

    }
}
