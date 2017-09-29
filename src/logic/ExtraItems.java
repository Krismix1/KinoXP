package logic;

import java.util.ArrayList;

/**
 * Created by Vidas on 9/25/2017.
 */
public class ExtraItems {


  public   static java.util.ArrayList<String> items = new ArrayList<String>();
    public static java.util.ArrayList<String> addExtraShit(String item) {
        items.add(item);
        return items;
    }


}
