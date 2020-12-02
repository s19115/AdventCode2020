package PasswordPhilosphy;

public class Main {
    public static void main(String[] args) {
        String[] inputs=Input.input.split("\n");
        int correct=0;
        int correctNew=0;
        for (String input : inputs) {
            int[] letters = new int[26];
            int min = Integer.parseInt(input.split(" ")[0].split("-")[0]);
            int max = Integer.parseInt(input.split(" ")[0].split("-")[1]);
            char letter = input.split(" ")[1].charAt(0);
            String password = input.split(" ")[2];
            for (int j = 0; j < password.length(); j++) {
                letters[password.charAt(j) - 97]++;
            }
            int howMany = letters[letter - 97];
            if (howMany >= min && howMany <= max) correct++;
            if(password.charAt(min-1)==letter^password.charAt(max-1)==letter) correctNew++;


        }
        System.out.println(correct);
        System.out.println(correctNew);
    }


}
