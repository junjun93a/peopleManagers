package dao;

import model.Position;

import java.util.List;

public interface PositionDao {
    Integer insertPosition(Position position);
    Integer updatePosition(Position position);
    Integer deletePosition(Integer T_ID);
    Integer deletePositionbydid(Integer did);
    Position selectPositionbyid(Integer id);
    List<Position> selectAllPosition();
    List<Position> selectPositionbydid(Integer did);
    Position selectPositionbynameanddid(Integer did, String name);
}
