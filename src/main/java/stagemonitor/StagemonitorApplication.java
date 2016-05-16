package stagemonitor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.stereotype.Component;
import org.stagemonitor.core.Stagemonitor;
import org.stagemonitor.web.WebPlugin;

@SpringBootApplication
public class StagemonitorApplication {

    public static void main(String[] args) {
        Stagemonitor.init();
        SpringApplication.run(StagemonitorApplication.class, args);
    }

    @Component
    public static class StagemonitorEnabler implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addInitializers(new ServletContextInitializer() {
                @Override
                public void onStartup(ServletContext servletContext) throws ServletException {
                    new WebPlugin().onStartup(null, servletContext);
                }
            });
        }
    }
}
