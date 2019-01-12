import java.util.Random;
import java.lang.Math;

public class KeyPad {

    char[] answer;

    public KeyPad() {
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
        answer = key[Math.abs(gen.nextInt()) % 6];
    }
}
