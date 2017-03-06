package by.ayupov.dao.interfaces;

import by.ayupov.entity.Rating;

import java.util.List;

public interface RatingDao extends BaseDao<Rating>  {

    /**
     * this method return List<Integer> marks
     * @param productName
     * @return
     */
    List<Integer> getRatingMarks(String productName);
}
