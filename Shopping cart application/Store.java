import java.util.Arrays;

public class Store {
    private Item[][] item;

//    constructor
    public Store() {
        this.item =  new Item[7][3];
    }

    public Item getItem(int row, int column) {
        return new Item(item[row][column]);
    }

    public void setItem(int row, int column, Item item) {
        this.item[row][column] = new Item(item);
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < item.length; i++) {
            switch (i) {
                case 0 -> temp.append("\tDRINKS:        ");
                case 1 -> temp.append("\tCEREAL:        ");
                case 2 -> temp.append("\tDAIRY:         ");
                case 3 -> temp.append("\tDELI:          ");
                case 4 -> temp.append("\tGREENS:        ");
                case 5 -> temp.append("\tCLOTHING:      ");
                case 6 -> temp.append("\tELECTRONICS:   ");
            }
            for (int j = 0; j < item[i].length; j++) {
                temp.append(this.item[i][j].toString());
            }
            temp.append("\n\n");
        }
        temp.append("\t*************************************************************************");
        return temp.toString();
    }
}
