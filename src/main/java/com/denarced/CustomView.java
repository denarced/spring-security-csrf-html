package com.denarced;

import org.apache.commons.io.IOUtils;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CustomView implements View {
    private final String viewName;

    public CustomView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void render(
        Map<String, ?> map,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write(htmlWithToken(request));
        writer.flush();
    }

    private String htmlWithToken(
        HttpServletRequest request) throws IOException {

        String html = IOUtils.toString(
            getClass().getResourceAsStream("/public/" + viewName + ".html"),
            StandardCharsets.UTF_8);
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        return html.replace(
            "___csrf___",
            csrfToken.getToken());
    }
}
