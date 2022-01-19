package Endss;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.mod.*;

import Endss.content.*;
public class EndlessHorizon extends Mod{

    public EndlessHorizon(){
    }

    @Override
    public void loadContent(){
        new EndssItems().load();
        new EndssBlocks().load();
        Log.info("a");
    }

}
