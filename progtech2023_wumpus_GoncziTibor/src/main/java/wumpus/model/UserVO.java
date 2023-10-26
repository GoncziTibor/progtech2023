package wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class UserVO {

    private char[][] map;
    private UserVO userVO;
    private int size;

    public UserVO(char[][] map, UserVO userVO, int size) {
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
        UserVO userVO1 = (UserVO) o;
        return size == userVO1.size && Arrays.equals(map, userVO1.map) && Objects.equals(userVO, userVO1.userVO);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userVO, size);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVo{");
        sb.append("size=").append(size);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", heroVo=").append(userVO);
        sb.append('}');
        return sb.toString();
    }
}
