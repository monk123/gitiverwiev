package by.ayupov.services.impl;

import by.ayupov.entity.Rating;
import by.ayupov.services.interfaces.BaseService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl extends BaseServiceImpl<Rating> {
    private static final Logger log = Logger.getLogger(RatingServiceImpl.class);
}
