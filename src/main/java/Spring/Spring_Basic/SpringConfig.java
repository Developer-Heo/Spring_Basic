package Spring.Spring_Basic;

import Spring.Spring_Basic.repository.*;
import Spring.Spring_Basic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import javax.sql.DataSource;

// 각 클래스에 @Service , @Repository 해도 SpringBean으로 인식 가능
@Configuration
public class SpringConfig {

    /*private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    /*  private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

/*    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    */
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

   /* @Bean
    public MemberRepository memberRepository() {*/
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);\
    //}

   /* @Bean
    public TimeTraceAop timeTraceAop(s) {
        return new TimeTraceAop();
    }*/
}
