package com.example.picolofuergeringverdiener;

import java.util.ArrayList;

public class FragenMitTyp {

    private final ArrayList<String> list;
    private final FragenTypen type;
    private final boolean drehplatte;

    public FragenMitTyp(ArrayList<String> list, FragenTypen type, boolean drehplatte){
        this.list = list;
        this.type = type;
        this.drehplatte = drehplatte;
    }

    public ArrayList<String> getList(){
        return list;
    }

    public FragenTypen getType(){
        return type;
    }

    public boolean getDrehplatte(){return drehplatte;}
}
