package wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class UserVO implements UserInterface{
    private char column;
    private int row;
    private char way;
    private int arrows;
    private int gold;

    public UserVO(char column, int row, char way, int arrows, int gold) {
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

        UserVO userVO = (UserVO) o;

        if (column != userVO.column) return false;
        if (row != userVO.row) return false;
        if (way != userVO.way) return false;
        if (arrows != userVO.arrows) return false;
        return gold == userVO.gold;
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
        final StringBuffer sb = new StringBuffer("UserVO{");
        sb.append("column=").append(column);
        sb.append(", row=").append(row);
        sb.append(", way=").append(way);
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append('}');
        return sb.toString();
    }
}
