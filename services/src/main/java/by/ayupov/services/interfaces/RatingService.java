package by.ayupov.services.interfaces;

import by.ayupov.entity.Rating;

import java.util.List;

public interface RatingService extends BaseService<Rating> {

    /**
     * this method is needed to return List marks
     * @param productName
     * @return
     */
    List<Integer> getRatingMarks(String productName);
}
