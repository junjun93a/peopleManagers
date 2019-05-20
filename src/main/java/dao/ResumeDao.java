package dao;

import model.Resume;

import java.util.List;

public interface ResumeDao {
    Integer insertResume(Resume resume);
    Integer updateResume(Resume resume);
    Integer deleteResume(Integer T_ID);
    List<Resume> selectResumebyvid(Integer vid);//按游客查
    Resume selectResumebyid(Integer id);//按id查
}
