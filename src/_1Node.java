public class _1Node {
    public PayNumNode[] payNumNode;
    private int[] space;
    private int[] num;

    public _1Node(int[] s, int[] n) {
        this.space = s;
        this.num = n;
        this.payNumNode = new PayNumNode[this.num[10]];
    }

    public void select(String[] ref, boolean isFinal) {
        if (isFinal) {
            for (int i = 0; i < this.num[10]; i++) {
                try {
                    this.payNumNode[i].select(ref, true);
                } catch (NullPointerException e) {
                }
            }
            return;
        }

        try {
            this.payNumNode[Divide.divide(Double.valueOf(ref[15]),Divide.DIVIDE_NODE10)].select(ref, false);
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                this.payNumNode[this.num[10] - 1].select(ref, false);
            } catch (NullPointerException x) {
                this.payNumNode[this.num[10] - 1] = new PayNumNode();
                this.payNumNode[this.num[10] - 1].select(ref, false);
            }
        } catch (NullPointerException e) {
            this.payNumNode[Divide.divide(Double.valueOf(ref[15]),Divide.DIVIDE_NODE10)] = new PayNumNode();
            this.payNumNode[Divide.divide(Double.valueOf(ref[15]),Divide.DIVIDE_NODE10)].select(ref, false);
        }
    }

    public PayNumNode find(int target) {
        int i = 0;
        while (true) {
            if (target + i < 0 || target + i >= this.num[10]) {
                if (i <= 0) {
                    i--;
                }
                i *= -1;
                continue;
            }
            if (this.payNumNode[target + i] != null) {
                return this.payNumNode[target + i];
            }
            if (i <= 0) {
                i--;
            }
            i *= -1;
        }
    }
}
