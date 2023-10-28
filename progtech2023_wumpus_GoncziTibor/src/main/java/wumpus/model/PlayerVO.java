package wumpus.model;

public class PlayerVO implements UserInterface{
    private char column;
    private int row;
    private char way;
    private int arrows;
    private int gold;

    public PlayerVO() {
        this.column = column;
        this.row = row;
        this.way = way;
        this.arrows = arrows;
        this.gold = gold;
    }


    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public char getWay() {
        return way;
    }

    public int getArrows() {
        return arrows;
    }

    public int getGold() {
        return gold;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setWay(char way) {
        this.way = way;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerVO playerVO = (PlayerVO) o;

        if (column != playerVO.column) return false;
        if (row != playerVO.row) return false;
        if (way != playerVO.way) return false;
        if (arrows != playerVO.arrows) return false;
        return gold == playerVO.gold;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + (int) way;
        result = 31 * result + arrows;
        result = 31 * result + gold;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlayerVO{");
        sb.append("column=").append(column);
        sb.append(", row=").append(row);
        sb.append(", way=").append(way);
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void move() {
    }

    @Override
    public void turnRight() {
        switch (this.way){
            case 'E':
                this.way = 'S';
                break;
            case 'S':
                this.way = 'W';
                break;
            case 'W':
                this.way = 'N';
                break;
            default:
                this.way = 'E';
                break;
        }
    }

    @Override
    public void turnLeft() {
        switch (this.way){
            case 'S':
                this.way = 'E';
                break;
            case 'W':
                this.way = 'S';
                break;
            case 'N':
                this.way = 'W';
                break;
            default:
                this.way = 'N';
                break;
        }
    }

    @Override
    public void shoot() {
        this.arrows--;
    }

    @Override
    public void pickupGold() {

    }
}
