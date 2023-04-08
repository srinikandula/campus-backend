package com.anyaudit;

import com.anyaudit.models.User;
import com.anyaudit.util.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;


@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class, WebAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public abstract class AbstractControllerIntegrationTest {


    private static final Logger logger = LoggerFactory.getLogger(AbstractControllerIntegrationTest.class);

    @Autowired
    @Getter
    private ObjectMapper objectMapper;

    @Autowired
    @Getter
    private WebApplicationContext wac;

    public static MockHttpServletRequestBuilder asUser(final MockHttpServletRequestBuilder request, final User user) {
        return request.requestAttr(SessionManager.USER_SESSION_ATTR, user);
    }

    public void setup(){
        SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthenticationToken(
                "anonymousUser","anonymousUser", AuthorityUtils
                .createAuthorityList("ROLE_ONE", "ROLE_TWO")));
    }
}
