package Endss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class EndssItems implements ContentList {
  public static Item tolium;
  
  @Override
  public void load(){
    tolium = new Item("tolium", Color.valueOf("5D5D61FF")){{
      hardness = 2;
      cost = 2;
    }};
  }
}