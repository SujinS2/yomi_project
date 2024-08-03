package kr.co.iei.restr.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.restr.model.dao.RestrDao;
import kr.co.iei.restr.model.dto.Restaurant;

@Service
public class RestrService {

	@Autowired
	private RestrDao restrDao;
	
	public Restaurant selectOneRestr(int restrNo) {
		Restaurant r = restrDao.selectOneRestr(restrNo);
		return r;
	}

	@Transactional
	public int likePush(int restrNo, int isLike, int memberNo) {
		int result = 0;
		if(isLike == 0) {
			//현재 좋아요를 누르지 않은 상태에서 클릭 -> 좋아요 -> insert
			result = restrDao.insertNoticeRestrLike(restrNo, memberNo);
		} else if (isLike == 1) {
			//현재 좋아요를 누른 상태에서 클릭 -> 좋아요 취소 -> delete
			result = restrDao.deleteNoticeRestrLike(restrNo, memberNo);
		}
		if(result>0) {
			//좋아요,좋아요 취소 로직을 수행하고나면 현재 좋아요 갯수를 조회해서 리턴
			int likeCount = restrDao.selectNoticeRestrLikeCount(restrNo);
			return likeCount;
		} else {
			return -1;
		}
	}

}
