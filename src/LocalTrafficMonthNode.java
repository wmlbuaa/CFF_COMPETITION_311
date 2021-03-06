public class LocalTrafficMonthNode {
    private NetServiceNode[] netServiceNodes;
    private int[] space;
    private int[] num;

    public LocalTrafficMonthNode(int[] s, int[] n) {
        this.space = s;
        this.num = n;
        this.netServiceNodes = new NetServiceNode[this.num[5]];
    }

    public void select(String[] ref, boolean isFinal) {
        if (isFinal) {
            for (int i = 0; i < this.num[5]; i++) {
                try {
                    this.netServiceNodes[i].select(ref, true);
                } catch (NullPointerException e) {
                }
            }
            return;
        }

        try {
            this.netServiceNodes[Divide.divide(Double.valueOf(ref[5]), Divide.DIVIDE_NODE5)].select(ref, false);
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                this.netServiceNodes[this.num[5] - 1].select(ref, false);
            } catch (NullPointerException x) {
                this.netServiceNodes[this.num[5] - 1] = new NetServiceNode(this.space, this.num);
                this.netServiceNodes[this.num[5] - 1].select(ref, false);
            }
        } catch (NullPointerException e) {
            this.netServiceNodes[Divide.divide(Double.valueOf(ref[5]), Divide.DIVIDE_NODE5)] = new NetServiceNode(this.space, this.num);
            this.netServiceNodes[Divide.divide(Double.valueOf(ref[5]), Divide.DIVIDE_NODE5)].select(ref, false);
        } catch (NumberFormatException e) {
        }
    }

    public NetServiceNode find(int target) {
        int i = 0;
        while (true) {
            if (target + i < 0 || target + i >= this.num[5]) {
                if (i <= 0) {
                    i--;
                }
                i *= -1;
                continue;
            }
            if (this.netServiceNodes[target + i] != null) {
                return this.netServiceNodes[target + i];
            }
            if (i <= 0) {
                i--;
            }
            i *= -1;
        }
    }
}
