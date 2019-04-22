package servlet;

import config.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/infoShareAcademy")
public class Servlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        Enumeration enumeration = req.getParameterNames();

        while (enumeration.hasMoreElements()) {
            String param = (String) enumeration.nextElement();
            String[] s = map.get(param);

            for (int i = 0; i < s.length; i++) {
                resp.getWriter().println(param + "=" + s[i]);
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "Piotr";
        String surname = "Kowalski";
        String group = "JJDD6-Errorzy";
        LocalDateTime time = LocalDateTime.now();

        Template template = templateProvider.getTemplate(getServletContext(), "fm.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        model.put("surname", surname);
        model.put("group", group);
        model.put("time", time);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
