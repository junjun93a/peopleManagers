package service;

import model.Position;

import java.util.List;

public interface PositionService {
    boolean insertPosition(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Integer T_ID);
    boolean  deletePositionbydid(Integer did);
    Position selectPositionbyid(Integer id);
    List<Position> selectAllPosition();
    List<Position> selectPositionbydid(Integer did);
    Position selectPositionbynameanddid(Integer did, String name);
}
