import java.util.HashMap;
import java.util.Map;
public class WhosOnFirst{
  private String Display;
  private String[] Options1=new String[6];
  private int Level=0;
  //private [][
  //private List
  public String getDisplay(){
    return this.Display;
  }
  public void setDisplay(String Word){
    this.Display=Word;
  }
  public int getLevel(){
    return this.Level;
  }
  public WhosOnFirst(){
    HashMap<String, String[]> map = new HashMap<>();
        map.put("READY", new String[] {"YES"," OKAY", "WHAT"," MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"});
        map.put("FIRST", new String[] {"LEFT"," OKAY", "YES", "MIDDLE", "NO", "RIGHT","NOTHING", "UHHH", "WAIT", "READY", "BLANK", "WHAT", "PRESS", "FIRST"});
        map.put("NO", new String[] {"BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT", "PRESS", "OKAY", "NO", "MIDDLE"});
        map.put("BLANK", new String[] {"WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK", "PRESS", "READY", "NOTHING", "NO", "WHAT", "LEFT", "UHHH","YES", "FIRST"});
        map.put("NOTHING",new String[] {"UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT","WAIT", "FIRST", "NOTHING", "READY"});
        map.put("YES", new String[] {"OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES", "LEFT", "BLANK", "NO", "WAIT"});
        map.put("WHAT", new String[] {"UHHH", "WHAT", "LEFT","NOTHING", "READY", "BLANK", "MIDDLE", "NO", "OKAY", "FIRST", "WAIT", "YES", "PRESS", "RIGHT"});
        map.put("UHHH", new String[] {"READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH", "MIDDLE", "WAIT", "FIRST"});
        map.put("LEFT", new String[] {"RIGHT", "LEFT", "FIRST", "NO", "MIDDLE", "YES", "BLANK", "WHAT", "UHHH", "WAIT", "PRESS", "READY", "OKAY", "NOTHING"});
        map.put("RIGHT", new String[] {"YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT", "MIDDLE", "LEFT", "UHHH", "BLANK", "OKAY", "FIRST"});
        map.put("MIDDLE", new String[] {"BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT","LEFT", "MIDDLE", "RIGHT", "FIRST", "UHHH", "YES"});
        map.put("OKAY", new String[] {"MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY", "LEFT", "READY", "BLANK", "PRESS", "WHAT", "RIGHT"});
        map.put("WAIT", new String[] {"UHHH", "NO", "BLANK", "OKAY", "YES","LEFT", "FIRST", "PRESS", "WHAT", "WAIT", "NOTHING", "READY","RIGHT", "MIDDLE"});
        map.put("PRESS", new String[] {"RIGHT", "MIDDLE", "YES", "READY", "PRESS", "OKAY","NOTHING", "UHHH", "BLANK", "LEFT", "FIRST", "WHAT", "NO", "WAIT"});
        map.put("YOU", new String[] {"SURE", "YOU ARE","YOUR", "YOU'RE","NEXT","UH HUH","UR","HOLD","WHAT?", "YOU", "UH UH", "LIKE", "DONE", "U"});
        map.put("YOU ARE", new String[] {"YOUR","NEXT","LIKE","UH HUH","WHAT?","DONE", "UH UH","HOLD","YOU","U", "YOU'RE","SURE","UR", "YOU ARE"});
        map.put("YOUR", new String[] {"UH UH", "YOU ARE","UH HUH","YOUR","NEXT","UR","SURE","U", "YOU'RE","YOU","WHAT?","HOLD","LIKE","DONE"});
        map.put("YOU'RE", new String[] {"YOU", "YOU'RE","UR","NEXT", "UH UH", "YOU ARE","U","YOUR","WHAT?","UH HUH","SURE","DONE","LIKE", "HOLD"});
        map.put("UR", new String[] {"DONE","U","UR","UH HUH","WHAT?","SURE","YOUR","HOLD", "YOU'RE","LIKE","NEXT", "UH UH", "YOU ARE", "YOU"});
        map.put("U", new String[] {"UH HUH","SURE","NEXT","WHAT?", "YOU'RE","UR", "UH UH","DONE","U","YOU","LIKE","HOLD", "YOU ARE","YOUR"});
        map.put("UH HUH", new String[] {"UH HUH","YOUR", "YOU ARE","YOU","DONE","HOLD", "UH UH","NEXT","SURE","LIKE", "YOU'RE","UR","U","WHAT?"});
        map.put("UH UH", new String[] {"UR","U", "YOU ARE", "YOU'RE","NEXT", "UH UH", "DONE","YOU","UH HUH","LIKE","YOUR","SURE","HOLD","WHAT?"});
        map.put("WHAT?", new String[] {"YOU","HOLD", "YOU'RE","YOUR","U", "DONE", "UH UH","LIKE", "YOU ARE","UH HUH","UR","NEXT","WHAT?", "SURE"});
        map.put("DONE", new String[] {"SURE","UH HUH","NEXT","WHAT?","YOUR","UR", "YOU'RE","HOLD","LIKE","YOU","U", "YOU ARE", "UH UH", "DONE"});
        map.put("NEXT", new String[] {"WHAT?","UH HUH", "UH UH","YOUR","HOLD","SURE","NEXT","LIKE","DONE", "YOU ARE","UR", "YOU'RE","U", "YOU"});
        map.put("HOLD", new String[] {"YOU ARE","U","DONE", "UH UH","YOU","UR","SURE","WHAT?", "YOU'RE","NEXT","HOLD","UH HUH","YOUR", "LIKE"});
        map.put("SURE", new String[] {"YOU ARE","DONE","LIKE", "YOU'RE","YOU","HOLD","UH HUH","UR","SURE","U","WHAT?","NEXT","YOUR", "UH UH"});
        map.put("LIKE", new String[] {"YOU'RE","NEXT","U","UR","HOLD","DONE", "UH UH","WHAT?","UH HUH","YOU","LIKE","SURE", "YOU ARE","YOUR"});
  }
}
