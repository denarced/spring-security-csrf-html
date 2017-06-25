# spring-security-csrf-html
An example of how to pass CSRF token to pure HTML page.

# Motivation

I couldn't figure out how to work with Spring Security CSRF protection while using pure HTML. That is, not jsp or Thymeleaf. It wasn't clear how to exactly pass the token to the HTML and/or JavaScript. Spring Security documentation was pretty much useless but I finally found the answer somewhere.

# Solution

The gist of the solution is in two files: `WebSecurityConfig.java` and `login.html`. In the former the CSRF token is setup to be picked up by the latter. Spring Security only adds the token to the session but not to the HTTP header. This is done `WebSecurityConfig.HeaderFilter#doFilterInternal`. Then the token is picked up in `login.html` and inserted to the login form.
