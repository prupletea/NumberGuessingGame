import javax.swing.JOptionPane;

class atspekSkaiciu{
    public static void main(String[] args) {
        startWindow();
    }
    public static void startWindow(){
        Object[] startOpt = {"Taip", "Ne", "Apie"};
        int choice = JOptionPane.showOptionDialog(null, "Pradėti?", "Žaidimas 'Atspėk skaičių'", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, startOpt, startOpt[0]);
        if(choice == 0){
            int rightNum = genNumber();
            playWindow(rightNum);
        } else if(choice == 1){
            System.exit(0);
        } else if(choice == 2){
            helpWindow();
        } else {
            System.exit(0);
        }
    }
    public static void helpWindow(){
        Object[] backOpt = {"Grįžti atgal"};
        JOptionPane.showOptionDialog(null, "Šiame žaidime reikia atspėti skaičių 1-100, kurį sugalvoja kompiuteris.", "Pagalba", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, backOpt, backOpt[0]);
        startWindow();
    }
    public static void playWindow(int rightNum){
        String input = JOptionPane.showInputDialog("Įveskite skaičių 1-100.");
        int guess;
        if(isNumeric(input)){
            guess = Integer.parseInt(input);
            if(guess >= 1 && guess <= 100){
                if(guess == rightNum){
                    Object[] yesNo = {"Taip", "Ne"};
                    int choice = JOptionPane.showOptionDialog(null, "Teisingai. Žaisti dar kartą?", "Valio!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNo, yesNo[0]);
                    if(choice == 0){
                        startWindow();
                    } else {
                        System.exit(0);
                    }
                } else if(guess > rightNum){
                    Object[] yesNo = {"Taip", "Ne"};
                    int choice = JOptionPane.showOptionDialog(null, "Tikrasis skaičius mažesnis. Bandyti dar kartą?", "Neteisingai", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNo, yesNo[0]);
                    if(choice == 0){
                        playWindow(rightNum);
                    } else {
                        System.exit(0);
                    }
                } else if(guess < rightNum){
                    Object[] yesNo = {"Taip", "Ne"};
                    int choice = JOptionPane.showOptionDialog(null, "Tikrasis skaičius didesnis. Bandyti dar kartą?", "Neteisingai", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNo, yesNo[0]);
                    if(choice == 0){
                        playWindow(rightNum);
                    } else {
                        System.exit(0);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Klaida. Darbas baigiamas.");
                }
            } else {
                againWindow(rightNum);
            }
        } else {
            againWindow(rightNum);
        }
    }
    public static int genNumber(){
        return (int)(Math.random()*100 + 1);
    }
    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static void againWindow(int rightNum){
        Object[] opts = {"Bandyti dar kartą", "Baigti"};
        int choice = JOptionPane.showOptionDialog(null, "Netinkama įvestis.", "Klaida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
        if(choice == 0){
            playWindow(rightNum);
        } else if(choice == 1){
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Klaida. Darbas baigiamas.");
        }
    }
}