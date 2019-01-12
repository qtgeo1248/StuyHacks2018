import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.util.ArrayList;
public class WhosOnFirst extends Module{
  private String display;
  private String[] options=new String[6];
  private int level=0;
  private String[] allWords1=new String[] {"YES"," OKAY", "WHAT","MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"};
  private String[] allWords2=new String[] {"YOU'RE","NEXT","U","UR","HOLD","DONE", "UH UH","WHAT?","UH HUH","YOU","LIKE","SURE", "YOU ARE","YOUR"};
  private String Answer;
  private int strike;
  private HashMap<String, String[]> map = new HashMap<>();
  public String getDisplay(){
    return this.display;
  }
  public void setDisplay(String Word){
    this.display=Word;
  }
  public int getLevel(){
    return this.level;
  }
  public int getStrike(){
    return strike;
  }
  public WhosOnFirst(int XOFFSET, int YOFFSET){
        super(XOFFSET,YOFFSET);
        map.put("READY", new String[] {"YES"," OKAY", "WHAT","MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY", "NO", "FIRST", "UHHH", "NOTHING", "WAIT"});
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
        level=0;
      }

    public void generatePuzzle(){
      String[] all;
      int generateWord=(int)(Math.random()*100)%14;
      ArrayList<Integer> unUsed = new ArrayList<Integer>();
      for (int i = 0; i < 14; i++) {
        unUsed.add(i);
      }
        if (generateWord==0){
          display=allWords1[generateWord];
          all=allWords1;
        }
        else{
          display=allWords2[generateWord];
          all=allWords2;
        }
      unUsed.remove(generateWord);
      for (int a=0;a<6;a++){
        //System.out.println(""+generateWord+", "+unUsed.size()+", "+this.options.length);
        int temp=(int)(Math.random()*100) % (unUsed.size());
        generateWord=unUsed.get(temp);
        unUsed.remove(temp);
        this.options[a]=all[generateWord];
      }
    }
  public void Correct(){
    String[] correctSequence=map.get(this.display);
    int lowscore=15;
    for (int b=0;b<6;b++){
      for(int a=0;a<14;a++){
        if (correctSequence[a].equals(this.options[b])){
          if(a<lowscore){
            lowscore=a;
          }
        }
      }
    }
    Answer=correctSequence[lowscore];
  }
  public boolean userAnswer(String word){
    if (Answer==word){
      level++;
      return true;
    }
    else{
      level=0;
      strike++;
      return false;
    }
  }
  public boolean done(){
    if (level==5){
      return true;
    }
  }
  public static void drawDisplay(){
    TextGraphics.drawRectangle(new TerminalPosition(5+XOFFSET,9+YOFFSET),new TerminalSize(44,9),'#');
  }
  WhosOnFirst puzzle=new WhosOnFirst();
  public void initialize(Engine engine, TerminalScreen screen){
    puzzle.generatePuzzle();
    drawPuzzle();
    TextGraphics.drawRectangle(new TerminalPosition(17+XOFFSET,9+YOFFSET),new TerminalSize(14,9),'#');
    TextGraphics.drawRectangle(new TerminalPosition(28+XOFFSET,9+YOFFSET),new TerminalSize(14,9),'#');
    TextGraphics.drawRectangle(new TerminalPosition(39+XOFFSET,9+YOFFSET),new TerminalSize(14,9),'#');
    TextGraphics.drawRectangle(new TerminalPosition(17+XOFFSET,39+YOFFSET),new TerminalSize(14,9),'#');
    TextGraphics.drawRectangle(new TerminalPosition(28+XOFFSET,39+YOFFSET),new TerminalSize(14,9),'#');
    TextGraphics.drawRectangle(new TerminalPosition(39+XOFFSET,39+YOFFSET),new TerminalSize(14,9),'#');
  }
  public void run(Engine engine, Terminal Screen){

  }

  /*
  Constructor-WhosonFirst
  generatePuzzle
  Correct
  ----
  userAnwer
  done
  */
}
