package Spring.Spring_Basic;

import Spring.Spring_Basic.repository.MemberRepository;
import Spring.Spring_Basic.repository.MemoryMemberRepository;
import Spring.Spring_Basic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 각 클래스에 @Service , @Repository 해도 SpringBean으로 인식 가능
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
