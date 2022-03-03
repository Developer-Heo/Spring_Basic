package Spring.Spring_Basic.repository;

import Spring.Spring_Basic.domain.Member;

import java.util.List;
import java.util.Optional;

// 리포지토리에서 데이터 저장
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
