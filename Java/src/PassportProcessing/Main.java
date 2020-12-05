package PassportProcessing;

public class Main {
    public static void main(String[] args) {
        int numOfCorrect = 0;
        for (String string : Input.input.split("\n\n")) {
            boolean inCorrect = false;
            if (validate("byr", string)) continue;
            if (validate("iyr", string)) continue;
            if (validate("eyr", string)) continue;
            if (validate("hgt", string)) continue;
            if (validate("hcl", string)) continue;
            if (validate("ecl", string)) continue;
            if (validate("pid", string)) continue;
            numOfCorrect++;


        }
        System.out.println(numOfCorrect);
    }

    static boolean validateExistence(String tag, String input) {
        return input.contains(tag + ":");
    }

    static boolean validate(String tag, String input) {
        if (!validateExistence(tag, input)) return true;
        int indexOfTag = input.indexOf(tag + ":") + 4;
        input=input.replace("\n"," ");
        int indexEnd = input.indexOf(" ", indexOfTag);
        String tagData;
        if(indexEnd==-1) tagData=input.substring(indexOfTag);
        else
        tagData = input.substring(indexOfTag, indexEnd);
        switch (tag) {
            default:
                return true;
            case "byr":
                try {
                    int year = Integer.parseInt(tagData);
                    if (year < 1920) return true;
                    return year > 2020;
                } catch (NumberFormatException e) {
                    return true;
                }
            case "iyr":
                try {
                    int year = Integer.parseInt(tagData);
                    if (year < 2010) return true;
                    return year > 2020;
                } catch (NumberFormatException e) {
                    return true;
                }
            case "eyr":
                try {
                    int year = Integer.parseInt(tagData);
                    if (year < 2020) return true;
                    return year > 2030;
                } catch (NumberFormatException e) {
                    return true;
                }
            case "hgt":
                boolean inInches = false;
                int indx = tagData.indexOf("cm");
                if (indx == -1) {
                    inInches = true;
                    indx = tagData.indexOf("in");
                }
                if (indx == -1) return true;
                try {
                    int height = Integer.parseInt(tagData.substring(0, indx));
                    if (inInches) {
                        if (height < 59) return true;
                        return height > 76;
                    } else {
                        if (height < 150) return true;
                        return height > 193;
                    }
                } catch (NumberFormatException e) {
                    return true;
                }
            case "hcl":
                if (tagData.charAt(0) != '#') return true;
                boolean output=
                 tagData.matches("#([a-f]|[0-9]){6}");
                return !output;
            case "ecl":
                output= tagData.matches("amb|blu|brn|gry|grn|hzl|oth");
                return !output;
            case "pid":
                output=tagData.matches("[0-9]{9}");
                return !output;


        }
    }
}
