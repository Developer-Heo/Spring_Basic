package Spring.Spring_Basic.service;

import Spring.Spring_Basic.domain.Member;
import Spring.Spring_Basic.repository.MemberRepository;
import Spring.Spring_Basic.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

// 서비스에서 비지니스 로직 만듬

@Transactional // join에 해줘도 무관
public class MemberService {

    private final MemberRepository memberRepository; //= new MemoryMemberRepository();

    public MemberService(MemberRepository memberRepository) { //Generate -> Constructor
        this.memberRepository = memberRepository;
    }

    // 회원가입

    public Long join(Member member){
       // 같은 이름이 있는 중복 회원x - 중복회원 검증
        validateDupulicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDupulicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {    // 존재하면~ (if not null)
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
