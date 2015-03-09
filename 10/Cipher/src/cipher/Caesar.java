/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author LukeMcNemee
 */
public class Caesar {

    private int key;

    public Caesar(int key) {
        this.key = key % 26;
    }

    private String code(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    result.append((char) ('A' + (i - 'A' + key + 26) % 26));
                } else {
                    result.append((char) ('a' + (i - 'a' + key + 26) % 26));
                }
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }

    public String encode(String text) {
        return code(text, key);
    }

    public String decode(String text) {
        return code(text, -key);
    }
}
