package cn.qdgxy.tr.service.impl;

import cn.qdgxy.tr.mapper.QuestionMapper;
import cn.qdgxy.tr.po.Question;
import cn.qdgxy.tr.service.QuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题  服务实现类
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
