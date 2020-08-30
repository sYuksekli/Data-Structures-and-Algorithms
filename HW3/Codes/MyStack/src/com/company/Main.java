package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        int R_counter=0;
        int C_counter=0;
        int n=0;
        int i;
        int map[][]=null;

        try {

            String row_str;
            String[] col_str=null;
            File f = new File(args[0]);
            Scanner scan = new Scanner(f);


            while (scan.hasNextLine()) {
                row_str = scan.nextLine();
                col_str = row_str.split(" ");
                ++R_counter;
            }


            C_counter=col_str.length;
            map = new int [R_counter][C_counter];

            scan= new Scanner(f);

            while (scan.hasNextLine()) {
                row_str = scan.nextLine();
                col_str = row_str.split(" ");
                for(i=0; i<C_counter;++i)
                    map[n][i]=Integer.parseInt(col_str[i]);
                ++n;
            }
        }

        catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }


        Map m= new Map(map);
        int check= m.FindWhiteBlocks();
        System.out.print("Number of the white blocks are:");
        System.out.println(check);
    }
}
