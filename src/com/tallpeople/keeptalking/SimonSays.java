public class SimonSays extends Module{
    private String Display;
    public String getDisplay() {
        return this.Display;
    }
    private int strikes = 0;
    private boolean serialVowel = true;
    private static String[] colors = {"red", "green", "blue", "yellow"};
    private static int[] sequence = new int[4];
    private String[] colorSequence = new String[4];
    private String[] presses = new String[4];
    public SimonSays(int XOFFSET, int YOFFSET, Engine engine, TerminalScreen screen) {
        super(XOFFSET, YOFFSET, engine, screen);
        for(int i = 0; i < 4; i++){
            sequence[i] = (int) (Math.random() * 4);
            colorSequence[i] = colors[sequence[i]];
        }
        correctPress();
    }
    
    public void initialize() {
        
    }
    
    public void run() {
        
    }
    
    // public String getFlash() {
        // return colorSequence[0];
    // }
    
    // public String getSequence() {
        // String seq = new String();
        // for( int i = 0; i < 4; i++) {
            // seq += colorSequence[i];
        // }
        // return seq;
    // }
    
    public void correctPress() {
        if (serialVowel) {
            for(int i = 0; i < 4; i++) {
                if (strikes == 0) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "red";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "green";
                }
                if (strikes == 1) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "yellow";  
                    if (colorSequence[i].equals("blue")) 
                        presses[i] = "green";
                    if (colorSequence[i].equals("green")) 
                        presses[i] = "blue";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "red";                        
                }
                if (strikes == 2) {
                    if (colorSequence[i].equals("red")) 
                        presses[i] = "green";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "red";
                    if (colorSequence[i].equals("green")) 
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "blue";                        
                }
            }
        }
        else {
            for(int i = 0; i < 4; i++) {
                if (strikes == 0) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "red";
                }
                if (strikes == 1) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "red";  
                    if (colorSequence[i].equals("blue")) 
                        presses[i] = "blue";
                    if (colorSequence[i].equals("green")) 
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "green";                        
                }
                if (strikes == 2) {
                    if (colorSequence[i].equals("red")) 
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("green")) 
                        presses[i] = "blue";
                    if (colorSequence[i].equals("yellow")) 
                        presses[i] = "red";                        
                }
            }
        }
    }
    // public String getPresses(){
        // String x = new String();
        // for(int i = 0; i < 4; i++) {
            // x += presses[i];
        // }
        // return x;
    // }
    
}