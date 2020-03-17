package site.laodengtou.taobao01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import site.laodengtou.taobao01.entity.MyCode;

import java.util.List;

public interface CodeDao extends JpaRepository<MyCode,Long> {

    List<MyCode> findCodesByOneAndTwoAndThreeAndFour(int a, int b, int c, int d);


}
