package by.ayupov.dao.impl;

import by.ayupov.entity.Rating;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@NoArgsConstructor
public class RatingDaoImpl extends BaseDaoImpl<Rating> {
    private static final Logger log = Logger.getLogger(RatingDaoImpl.class);
    private static RatingDaoImpl ratingDao;

    public static RatingDaoImpl getInstance() {
        if (ratingDao == null) {
            ratingDao = new RatingDaoImpl();
        }
        return ratingDao;
    }

}
