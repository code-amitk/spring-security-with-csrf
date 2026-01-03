package com.amit.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/security")
public class SecurityRestController {

    @GetMapping
    ResponseEntity<String> getHello(HttpServletRequest request) {
        return ResponseEntity.ok("Hello Security !!!" + request.getRequestedSessionId());
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        Object attr = request.getAttribute("_csrf");
        if (attr instanceof CsrfToken) {
            return (CsrfToken) attr;
        }
        if (attr instanceof Supplier) {
            Object supplied = ((Supplier<?>) attr).get();
            if (supplied instanceof CsrfToken) {
                return (CsrfToken) supplied;
            }
        }
        return null;
    }
}
