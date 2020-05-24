package life.majiang.community.schedule;

import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;

    @Scheduled(fixedRate = 10000)
    public void hotTagSchedule() {
        int offset = 0;
        int limit = 20;
        List<Question> list = new ArrayList<>();
        while(offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for(Question question : list) {
                log.info("list question : {}", question.getId());
            }
            offset += limit;
        }
        log.info("hotTagSchedule stop {}", new Date());
    }
}
