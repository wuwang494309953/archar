package fgo.xiaox.archar.common.base.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

public class AWrappers {

    public static <T> QueryWrapper<T> parseWhereSql(List<Condition> conditions) {
        if (conditions == null || conditions.isEmpty()) {
            return Wrappers.query();
        }
        QueryWrapper<T> wrapper = Wrappers.query();
        for (Condition condition : conditions) {
            switch (condition.getType()) {
                case EQ: wrapper.eq(condition.getColumn(), condition.getValue()); break;
                case NE: wrapper.ne(condition.getColumn(), condition.getValue()); break;
                case GT: wrapper.gt(condition.getColumn(), condition.getValue()); break;
                case GE: wrapper.ge(condition.getColumn(), condition.getValue()); break;
                case LT: wrapper.lt(condition.getColumn(), condition.getValue()); break;
                case LE: wrapper.le(condition.getColumn(), condition.getValue()); break;
                case LIKE: wrapper.like(condition.getColumn(), condition.getValue()); break;
                case LIKE_LEFT: wrapper.likeLeft(condition.getColumn(), condition.getValue()); break;
                case LIKE_RIGHT: wrapper.likeRight(condition.getColumn(), condition.getValue()); break;
                case NOT_LIKE: wrapper.notLike(condition.getColumn(), condition.getValue()); break;
                case ISNULL: wrapper.isNull(condition.getColumn()); break;
                case IS_NOT_NULL: wrapper.isNotNull(condition.getColumn()); break;
                case BETWEEN:
                    if (condition.getValue() instanceof List) {
                        wrapper.between(condition.getColumn(),
                                ((List<?>) condition.getValue()).get(0),
                                ((List<?>) condition.getValue()).get(1));
                    }
                    break;
                case NOT_BETWEEN:
                    if (condition.getValue() instanceof List) {
                        wrapper.notBetween(condition.getColumn(),
                                ((List<?>) condition.getValue()).get(0),
                                ((List<?>) condition.getValue()).get(1));
                    }
                    break;
                case IN:
                    if (condition.getValue() instanceof List) {
                        wrapper.in(condition.getColumn(),
                                ((List<?>) condition.getValue()));
                    }
                    break;
                case NOT_IN:
                    if (condition.getValue() instanceof List) {
                        wrapper.notIn(condition.getColumn(),
                                ((List<?>) condition.getValue()));
                    }
                    break;
                case OR:
                    wrapper.or();
                    break;
                default:
                    break;
            }
        }
        return wrapper;
    }

}
