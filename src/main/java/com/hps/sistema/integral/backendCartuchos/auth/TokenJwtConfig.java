package com.hps.sistema.integral.backendCartuchos.auth;

import java.security.Key;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class TokenJwtConfig {
   // public final static String SECRET_KEY = "Hospital_Pablo_Soria_Sistema_Integral";
   public final static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";
}
