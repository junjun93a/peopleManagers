package service;

import model.Visitor;

public interface VisitorService {
    boolean insertvisitor(Visitor visitor);//注册
    boolean updatevisitor(Visitor visitor);
    Visitor login(Visitor visitor);//登陆
    Visitor selectvisitorbyid(Integer id);
    boolean selectvisitorbyaccount(Visitor visitor);

}
