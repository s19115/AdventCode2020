package ReportRepair;

public class Main {
    public static void main(String[] args) {
        String[] string=Input.input.split("\n");
        for(int i=0; i<string.length;i++){
            for(int j=i+1;j<string.length;j++){
                  if(Integer.parseInt(string[i])+Integer.parseInt(string[j])==2020) System.out.println(Integer.parseInt(string[i])*Integer.parseInt(string[j]));
            }
        }
        for(int i=0; i<string.length;i++){
            for(int j=i+1;j<string.length;j++){
                for(int y=j+1;y<string.length;y++)
                if(Integer.parseInt(string[i])+Integer.parseInt(string[j])+Integer.parseInt(string[y])==2020) System.out.println(Integer.parseInt(string[i])*Integer.parseInt(string[j])*Integer.parseInt(string[y]));
            }
        }


    }
}
