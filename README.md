# spring-security-csrf-html
An example of how to pass CSRF token to pure HTML page.

# Motivation

I couldn't figure out how to work with Spring Security CSRF protection while
using pure HTML. That is, not jsp or Thymeleaf. It wasn't clear how to exactly
pass the token to the HTML and/or JavaScript. Spring Security documentation was
pretty much useless but I finally found the answer somewhere.

# Solution

The gist of the solution is to create a custom ViewResolver and a custom View.
With the latter the HTML can be read and modified to insert the CSRF token.
