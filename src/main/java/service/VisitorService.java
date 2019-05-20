package service;

import model.Visitor;

public interface VisitorService {
    Boolean insertvisitor(Visitor visitor);//注册
    Visitor login(Visitor visitor);//登陆
    Visitor selectvisitorbyid(Integer id);
    boolean selectvisitorbyaccount(Visitor visitor);

}
