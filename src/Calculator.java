import java.io.*;
import java.util.Vector;

public class Calculator {
    private Vector<Integer> current_type = new Vector<>(100);

    private TypeTag type_89016252;
    private TypeTag type_89016253;
    private TypeTag type_89016259;
    private TypeTag type_89950166;
    private TypeTag type_89950167;
    private TypeTag type_89950168;
    private TypeTag type_90063345;
    private TypeTag type_90109916;
    private TypeTag type_90155946;
    private TypeTag type_99104722;
    private TypeTag type_99999825;
    private TypeTag type_99999826;
    private TypeTag type_99999827;
    private TypeTag type_99999828;
    private TypeTag type_99999830;

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Buaa-Aladdin\\Downloads\\train_all.csv");
        FileWriter fileWriter = new FileWriter("C:\\train_all.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String getLine;
        while ((getLine = bufferedReader.readLine()) != null) {
            String[] s = getLine.split(",");
            String writeLine = "";
            for (int i = 0; i < s.length; i++) {
                if (i == 20 || i==23 || i==24 || i==1 || i==22 || i==11 || i==1 || i==14) {
                    continue;
                } else {
                    writeLine += s[i];
                }
                if (i != 26) {
                    writeLine += ",";
                }else{
                    writeLine += "\n";
                }
            }
            bufferedWriter.write(writeLine);
        }
        bufferedWriter.flush();
    }

    private Calculator(TypeTag[] mid) {
        this.type_89016252 = mid[0];
        this.type_89016253 = mid[1];
        this.type_89016259 = mid[2];
        this.type_89950166 = mid[3];
        this.type_89950167 = mid[4];
        this.type_89950168 = mid[5];
        this.type_90063345 = mid[6];
        this.type_90109916 = mid[7];
        this.type_90155946 = mid[8];
        this.type_99104722 = mid[9];
        this.type_99999825 = mid[10];
        this.type_99999826 = mid[11];
        this.type_99999827 = mid[12];
        this.type_99999828 = mid[13];
        this.type_99999830 = mid[14];
    }

    private void addCureentType(int i) {
        if (this.current_type.contains(new Integer(i))) {
            return;
        }
        this.current_type.add(new Integer(i));
    }

    public void addGenda(int type, float n) {
        switch (type) {
            case 89016252: {
                this.type_89016252.add(n);
                break;
            }
            case 89016253: {
                this.type_89016253.add(n);
                break;
            }
            case 89016259: {
                this.type_89016259.add(n);
                break;
            }
            case 89950166: {
                this.type_89950166.add(n);
                break;
            }
            case 89950167: {
                this.type_89950167.add(n);
                break;
            }
            case 89950168: {
                this.type_89950168.add(n);
                break;
            }
            case 90063345: {
                this.type_90063345.add(n);
                break;
            }
            case 90109916: {
                this.type_90109916.add(n);
                break;
            }
            case 90155946: {
                this.type_90155946.add(n);
                break;
            }
            case 99104722: {
                this.type_99104722.add(n);
                break;
            }
            case 99999825: {
                this.type_99999825.add(n);
                break;
            }
            case 99999826: {
                this.type_99999826.add(n);
                break;
            }
            case 99999827: {
                this.type_99999827.add(n);
                break;
            }
            case 99999828: {
                this.type_99999828.add(n);
                break;
            }
            case 99999830: {
                this.type_99999830.add(n);
                break;
            }
        }
    }
}
