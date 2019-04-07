package com.company;

public class Space {
    private int Start;
    private int End;
    private int Size;
    private boolean state;

    public Space(int start, int end, int size, boolean state) {
        Start = start;
        End = end;
        Size = size;
        this.state = state;
    }

    public Space(int start, int end, boolean state) {
        Start = start;
        End = end;
        this.state = state;
        this.Size = end - start;
    }
}
