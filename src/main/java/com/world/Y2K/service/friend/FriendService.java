package com.world.Y2K.service.friend;

import java.util.ArrayList;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendPageInfo;
import com.world.Y2K.model.vo.Friends;

public interface FriendService {

	int getFriendListCount();

	ArrayList<Member> selectFriendList(FriendPageInfo pi, Long userNo);

}
