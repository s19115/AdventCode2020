package TobogganTrajectory;

public class Main {
    public static void main(String[] args) {


        System.out.println(calculate(1,1)*calculate(3,1)*calculate(5,1)*calculate(7,1)*calculate(1,2));

    }

    static int calculate(int colStep,int rowStep){
        int row=0, collumn=0, trees=0;
        while (row<Input.input.split("\n").length){
            if(Input.input.split("\n")[row].charAt(collumn)=='#') trees++;
            row+=rowStep;
            collumn+=colStep;
            if(collumn>=Input.input.split("\n")[0].length()) collumn-=Input.input.split("\n")[0].length();
        }
        return trees;
    }

}
