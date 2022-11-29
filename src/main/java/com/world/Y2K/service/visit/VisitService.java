package com.world.Y2K.service.visit;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;

public interface VisitService {

	ArrayList<Visit> selectVisitList();

	int getVisitListCount();

	int insertVisit(Visit v);
}
