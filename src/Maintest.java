import java.io.*;

public class Maintest {
    //0.LocalCallerTime(ManyOverBill) --> 1.OnlineTime(FEE2) -->  2.MonthTraffic --> 3.ContractTime√ --> 4.LocalTrafficMonth(ServiceType)√
    // --> 5.NetService(FEE3) --> 6.LastMonthTrafiic(FEE1)√ --> 7.gender(Service_1_caller) --> 8.Service_2_caller
    // --> 9._1Node(contract_type) --> 10.PayNum(LastMonthTraffic)
    public static final int[] SPLIT_SPACE = {1, 32, 527, 11, 1, 41, 51, 1, 51, 1, 61};
    public static final int[] SPLIT_NUM = {5, 10, 4, 4, 5, 5, 5, 2, 5, 6, 20};
    public static final String readPath = "C:\\Users\\Buaa-Aladdin\\Downloads\\train_all.csv";
    public static final String testPath = "C:\\Users\\Buaa-Aladdin\\Downloads\\republish_test.csv";
    public static final String writePath = "C:\\result.csv";
    public static final int[] TRAIN_FIELD = {0, 950000};
    public static final int[] TEST_FIELD = {0, 1000000};
    public static final int[] TYPE =
            {
                    89016252, 89016253, 89016259, 89950166, 89950167,
                    89950168, 90063345, 90109916, 90155946, 99104722,
                    99999825, 99999826, 99999827, 99999828, 99999830
            };

    public static void main(String[] args) throws IOException {
        start zero = new start(SPLIT_SPACE, SPLIT_NUM);
        FileReader file = new FileReader(readPath);
        BufferedReader bufferedReader = new BufferedReader(file);
        String[] ref;

        int train_flag = 0;
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            if (train_flag >= TRAIN_FIELD[0] && train_flag <= TRAIN_FIELD[1]) {
                ref = line.split(",");
                zero.select(ref, false);
            }
            train_flag++;
        }
        zero.select(null, true);

        try {
            int illegal = 0;
            int right = 0;
            int wrong = 0;
            FileReader fileReader = new FileReader(testPath);
            FileWriter fileWriter = new FileWriter(writePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedReader = new BufferedReader(fileReader);
            String readline;

            bufferedWriter.write("user_id,current_service\n");
            readline = bufferedReader.readLine();
            int test_flag = 0;
            while ((readline = bufferedReader.readLine()) != null) {
                if (test_flag < TEST_FIELD[0] || test_flag > TEST_FIELD[1]) {
                    test_flag++;
                    continue;
                }
                String[] s = readline.split(",");
                bufferedWriter.write(s[25]);
                bufferedWriter.write(",");
                try {
                    int[] flag = new int[26];
                    flag[0] = (int) (Double.valueOf(s[8]) / SPLIT_SPACE[0]);
                    if (flag[0] >= SPLIT_NUM[0]) flag[0] = SPLIT_NUM[0] - 1;

                    flag[1] = (int) (Double.valueOf(s[4]) / SPLIT_SPACE[1]);
                    if (flag[1] >= SPLIT_NUM[1]) flag[1] = SPLIT_NUM[1] - 1;

                    flag[2] = Divide.divide(Double.valueOf(s[7]), Divide.DIVIDE_NODE2);

                    flag[3] = Divide.divide(Double.valueOf(s[10]), Divide.DIVIDE_NODE3);

                    flag[4] = (int) (Double.valueOf(s[0]) / SPLIT_SPACE[4]);
                    if (flag[4] >= SPLIT_NUM[4]) flag[4] = SPLIT_NUM[4] - 1;

                    flag[5] = Divide.divide(Double.valueOf(s[5]), Divide.DIVIDE_NODE5);

                    flag[6] = Divide.divide(Double.valueOf(s[3]), Divide.DIVIDE_NODE6);

                    flag[7] = (int) (Double.valueOf(s[18]) / SPLIT_SPACE[7]);
                    if (flag[7] >= SPLIT_NUM[7]) flag[7] = SPLIT_NUM[7] - 1;

                    flag[8] = Divide.divide(Double.valueOf(s[19]), Divide.DIVIDE_NODE8);

                    flag[9] = Divide.divide(Double.valueOf(s[9]), Divide.DIVIDE_NODE9);

                    flag[10] = Divide.divide(Double.valueOf(s[15]), Divide.DIVIDE_NODE10);

                    String mid = String.valueOf(TYPE[zero.find(flag[0]).find(flag[1]).find(flag[2]).find(flag[3]).
                            find(flag[4]).find(flag[5]).find(flag[6]).find(flag[7]).find(flag[8]).find(flag[9]).
                            find(flag[10]).first]);
                    bufferedWriter.write(mid);
                    if (mid.equals(s[25])) {
                        right++;
                    } else {
                        wrong++;
                    }
                } catch (Exception e) {
                    bufferedWriter.write("89016252");
                    illegal++;
                }
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                test_flag++;
            }
            System.out.println(illegal);
            System.out.println(right);
            System.out.println(wrong);
            System.out.println((double) right / ((double) right + (double) illegal + (double) (wrong)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}