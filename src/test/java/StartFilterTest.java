import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.jru.quest.karaganov.filter.StartFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.mock;

//public class StartFilterTest {
//    private HttpFilter myFilter ;
//    private HttpServletRequest request ;
//    private HttpServletResponse response;
//    private FilterChain filterChain;
//
//    @Before
//    public void setUp(){
//        myFilter = new StartFilter();
//        request = mock(HttpServletRequest.class);
//        response = mock(HttpServletResponse.class);
//        filterChain = mock(FilterChain.class);
//
//    }
//
//    @Test
//    void startFilterTest() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//
//
//        HttpSession session = request.getSession();
//        session.setAttribute("someAttribute", "value1");
//        myFilter.doFilter(request, response, filterChain);
//        Assertions.assertEquals("value1",request.getSession().getAttribute("someAttribute"));
//    }
//}