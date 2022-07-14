package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 빈등록 !! 스프링에 맞긴다  == @Component
@RequiredArgsConstructor // final 필드를 초기화 해주는 생성자 선언
// 파이널 필드를 매개변수로 받아서 쓴다
public class ScoreRepositoryImpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template;

    // 파이널을 왜 붙이는걸까 ?

    // 정답 :  변하지 말라고 만들기 때문이다 ~~

//    @Autowired
//    public ScoreRepositoryImpl(JdbcTemplate template) {
//        this.template = template;
//    }

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO TBL_SCORE" + " VALUES (seq_tbl_score.nextval,?,?,?,?,?,?,?)";
        // INSERT ,UPDATE ,DELETE 는 템플릿의 UPDATE() 메서드 활용

        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath()
                , score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
//        update() 의 리턴타입은
        // 이거에 영향받는 행의 줄을 쓰는것이다
        // 그래서 이건 영향을 받는 행의 줄은 1 이기 때문에 ==  1 이라고 명시해줘야한다 .

    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("select * from TBL_SCORE ");

        switch (sort){
            case "num":
                sql.append("order by stu_num");
                break;
            case "name":
                sql.append("order by stu_name");
                break;
            case "average":
                sql.append("order by average DESC");
                break;
        }
//        String sql = "select * from TBL_SCORE ";
        // SELECT 문의 경우는 QUERY()
//      1. 첫번째 단계
//        return template.query(sql, new ScoreRowMapper());
//        2. 단계
//        return template.query(sql, new RowMapper<Score>() {
//            @Override
//            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return  new Score(rs);
//            }
//        });
//       3 단계
        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {
        String sql = "select * from TBL_SCORE where stu_num=?";

        // 단일건수 조회 사용
        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);

    }
// 제거하기
    @Override
    public boolean remove(int stuNum) {

        String sql = "DELETE FROM tbl_score where stu_num=?";

        return template.update(sql, stuNum) == 1;
    }
    // 총 성적순으로 조회하기
    @Override
    public List<Score> arrayTotal() {

        String sql = "select * from tbl_score ORDER BY total";

        return template.query(sql, (rs, rowNum) -> new Score(rs));

    }

    @Override
    public List<Score> arrayAverage() {
        String sql = "select * from tbl_score ORDER BY average";

        return template.query(sql, (rs, rowNum) -> new Score(rs));

    }


}
