package service;

import model.Resume;

import java.util.List;

public interface ResumeService {
    boolean insertResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(Integer T_ID);
    List<Resume> selectResumebyvid(Integer vid);//按游客查
    Resume selectResumebyid(Integer id);//按id查
}
