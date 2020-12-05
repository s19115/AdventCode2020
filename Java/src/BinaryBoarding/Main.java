package BinaryBoarding;

public class Main {
    public static void main(String[] args) {
        String input = Input.input;
        boolean[] array=new boolean[975];
        int highestId = 0;
        for (String boardingPass : input.split("\n")) {
            String rowNum = boardingPass.substring(0, 7);
            String colNum = boardingPass.substring(7);
            rowNum = rowNum.replace('F', '0');
            rowNum = rowNum.replace('B', '1');
            colNum = colNum.replace('R', '1');
            colNum = colNum.replace('L', '0');

            int rowNumber = Integer.parseInt(rowNum, 2);
            int colNumber = Integer.parseInt(colNum, 2);
            int id = rowNumber * 8 + colNumber;
            if (id > highestId) highestId = id;
            array[id]=true;
        }
        boolean started=false;
        int i=-1;
        for(boolean bool:array){
            i++;
            if(bool)started=true;
            if (!bool&&started) System.out.println(i);
        }
    }
}
