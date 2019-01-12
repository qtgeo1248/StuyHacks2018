import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyPad extends Module{

    Character[] ans;
    char key1, key2, key3, key4;

    public KeyPad(int xOffset, int yOffset, Engine engine, TerminalScreen screen) {
        super(xOffset, yOffset, engine, screen);
        char[][] key = new char[6][7];
        char[] map1 = {'Ϙ', 'Ѧ', 'ƛ', 'Ϟ', 'Ѭ', 'ϗ', 'Ͽ'};
        char[] map2 = {'Ӭ', 'Ϙ', 'Ͽ', 'Ҩ', '☆', 'ϗ', '¿'};
        char[] map3 = {'©', 'Ѽ', 'Ҩ', 'Җ', 'Ԇ', 'ƛ', '☆'};
        char[] map4 = {'б', '¶', 'Ѣ', 'Ѭ', 'Җ', '¿', 'ټ'};
        char[] map5 = {'Ψ', 'ټ', 'Ѣ', 'Ͼ', '¶', 'Ѯ', '★'};
        char[] map6 = {'б', 'Ӭ', '҂', 'æ', 'Ψ', 'Ҋ', 'Ω'};
        key[0] = map1;
        key[1] = map2;
        key[2] = map3;
        key[3] = map4;
        key[4] = map5;
        key[5] = map6;
        Random gen = new Random();
        char[] ans = key[Math.abs(gen.nextInt()) % 6];
        ArrayList<Character> answer = new ArrayList<Character>();
        for (int i = 0; i < ans.length; i++) {
            answer.add(ans[i]);
        }
        key1 = answer.get(Math.abs(gen.nextInt()) % 7);
        answer.remove(Character.valueOf(key1));
        key2 = answer.get(Math.abs(gen.nextInt()) % 6);
        answer.remove(Character.valueOf(key2));
        key3 = answer.get(Math.abs(gen.nextInt()) % 5);
        answer.remove(Character.valueOf(key3));
        key4 = answer.get(Math.abs(gen.nextInt()) % 4);
        answer.remove(Character.valueOf(key4));
    }

    public String toString =
    public static void main(String[] args) {
        KeyPad abc = new KeyPad();
        System.out.println(abc.key1);
        System.out.println(abc.key2);
        System.out.println(abc.key3);
        System.out.println(abc.key4);
    }
}
