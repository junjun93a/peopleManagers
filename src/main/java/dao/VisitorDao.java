package dao;

import model.Visitor;

public interface VisitorDao {
    Integer insertvisitor(Visitor visitor);
    Visitor selectvisitorbyaccountpass(Visitor visitor);
    Visitor selectvisitorbyaccount(Visitor visitor);
    Visitor selectvisitorbyid(Integer id);

}
