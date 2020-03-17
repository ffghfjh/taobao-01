package site.laodengtou.taobao01.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.laodengtou.taobao01.entity.CodeSetting;

import java.util.List;

public interface CodeSettingDao extends JpaRepository<CodeSetting, Long> {

}
