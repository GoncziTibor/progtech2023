package wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {
    private char[][] map;
    private UserVO userVO;
    private int size;

    public MapVO(char[][] map, UserVO userVO, int size) {
        this.map = map;
        this.userVO = userVO;
        this.size = size;
    }

    public char[][] getMap() {
        return map;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public int getSize() {
        return size;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapVO mapVO = (MapVO) o;

        if (size != mapVO.size) return false;
        if (!Arrays.deepEquals(map, mapVO.map)) return false;
        return Objects.equals(userVO, mapVO.userVO);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + (userVO != null ? userVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVO{");
        sb.append("size=").append(size);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", userVO=").append(userVO);
        sb.append('}');
        return sb.toString();
    }
}
