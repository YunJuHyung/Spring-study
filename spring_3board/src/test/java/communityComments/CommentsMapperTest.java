package communityComments;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.iclass.mvc.dao.CommunityCommentsMapper;
import org.iclass.mvc.dto.CommunityComments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
class CommentsMapperTest {

	@Autowired
	CommunityCommentsMapper dao;
	
	@DisplayName("메인글 43번 - 댓글 리스트가 있습니다.")
	@Test
	void cmtlist() {
		
        // When: 테스트 대상 메서드 실행
        List<CommunityComments> commentsList = dao.commentsList(43);
        System.out.println("hiohi");
        log.info("메인글 43번 - 댓글 리스트 : {}", commentsList);
		 assertNotNull(commentsList); // 댓글 리스트가 null이 아닌지 확인
		 //assertTrue(commentsList.isEmpty());
	}

}
