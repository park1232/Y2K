package com.world.Y2K.service.visit;

import java.util.ArrayList;

import com.world.Y2K.model.entity.VisitEntity;
import com.world.Y2K.model.vo.Visit;

public interface VisitService {

	ArrayList<VisitEntity> selectVisitList(Long userNo);

	int getVisitListCount();

	int insertVisit(Visit v);

	int deleteVisit(Long visitNo);
}
