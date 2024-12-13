package listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class MyContextListner implements ServletContextListener, ServletContextAttributeListener {

 
    public MyContextListner() {
        System.out.println("[context listener 객체 생성]"); // filter 출력결과
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // Servletcontext 객체.setAttribute("id","value") 호출 시점 자동 실행
    	System.out.println("[context 속성추가]");
    	System.out.println("[" +scae.getName()+"]");
    }
    
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // Servletcontext 객체.setAttribute("id","value2") 호출 시점 자동 실행
    	System.out.println("[context 속성값 수정]");
    	System.out.println("[" +scae.getName()+"]");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	// Servletcontext 객체.removeAttribute("id","value2") 호출 시점 자동 실행
    	System.out.println("[" +scae.getName()+"]");
    	System.out.println("[context 속성삭제]");
    	
    }


    public void contextInitialized(ServletContextEvent sce)  { 
         // tomcat 서버 시작 - 초기화 구현부분 자동 실행
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
}
