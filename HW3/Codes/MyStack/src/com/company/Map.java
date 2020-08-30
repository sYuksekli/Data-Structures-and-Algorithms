package com.company;

/*
 *
 *******************
 *******************
 *   CSE 222 HW3   *
 * Sıla Bengisu Yüksekli *
 *******************
 *******************

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW3

 */


public class Map {


    private int arr[][];
    private MyStack<Coordinate> my_stack;


    /**
     * Creates a new Map.
     * @param Arr,
     */
    public Map(int Arr[][]){

        arr=Arr;
        my_stack= new MyStack<Coordinate>();
    }


    /**
     * It calculate the number of the white blocks.
     * @return the number of the white blocks.
     */
    public int FindWhiteBlocks(){


        int row=arr.length;
        int column=arr[0].length;
        int group=0;    //To indicate number of the white blocks.
        int visited[][] = new int[row][column]; //I keep a array like this to avoid a loop.


        //First, all of them are zero, then if I visit that places, I change with them one.
        for (int i=0; i<row; ++i){
            for (int j=0; j<column; ++j)
                visited[i][j]=0;
        }


        for (int i=0; i<row; ++i){
            for (int j=0; j<column; ++j){

                if(visited[i][j]==0 && arr[i][j]==1) {

                    Coordinate c_first= new Coordinate(i,j);
                    my_stack.push(c_first);
                    visited[i][j]=1;

                    Coordinate coordinate = my_stack.peek();

                    while (!my_stack.Empty()){


                        //Move down
                        if ((coordinate.getRow()+1)>=0 && (coordinate.getRow()+1)<arr.length && visited[coordinate.getRow()+1][coordinate.getColumn()] ==0 && arr[coordinate.getRow()+1][coordinate.getColumn()] == 1) {

                            Coordinate c_new = new Coordinate((coordinate.getRow()+1), coordinate.getColumn());
                            my_stack.push(c_new);
                            visited[coordinate.getRow()+1][coordinate.getColumn()] = 1;
                        }


                        //Move right
                        else if ((coordinate.getColumn()+1)>=0 && (coordinate.getColumn()+1)<arr[0].length && visited[coordinate.getRow()][coordinate.getColumn()+1] == 0 && arr[coordinate.getRow()][coordinate.getColumn()+1] == 1) {

                                Coordinate c_new = new Coordinate(coordinate.getRow(), (coordinate.getColumn()+1));
                                my_stack.push(c_new);
                                visited[coordinate.getRow()][coordinate.getColumn()+1] = 1;
                        }


                        //Move left
                        else if ((coordinate.getColumn()-1)>=0 && (coordinate.getColumn()-1)<arr[0].length && visited[coordinate.getRow()][coordinate.getColumn()-1] == 0 && arr[coordinate.getRow()][coordinate.getColumn() - 1] == 1) {

                                Coordinate c_new = new Coordinate(coordinate.getRow(), (coordinate.getColumn() - 1));
                                my_stack.push(c_new);
                                visited[coordinate.getRow()][coordinate.getColumn() - 1] = 1;
                        }


                        //Move up
                        else if ((coordinate.getRow()-1)>=0 && (coordinate.getRow()-1)<arr.length && visited[coordinate.getRow() - 1][coordinate.getColumn()] == 0 && arr[coordinate.getRow() - 1][coordinate.getColumn()] == 1) {

                                Coordinate c_new = new Coordinate((coordinate.getRow() - 1), coordinate.getColumn());
                                my_stack.push(c_new);
                                visited[coordinate.getRow() - 1][coordinate.getColumn()] = 1;
                        }


                        //If there is no places to go, I remove them.
                        else
                            my_stack.pop();


                        //To update coordinates, because the head of stack is changing.
                        if (!my_stack.Empty())
                            coordinate = my_stack.peek();


                    }

                    ++group;
                }
            }
        }

        return group;

    }






}
