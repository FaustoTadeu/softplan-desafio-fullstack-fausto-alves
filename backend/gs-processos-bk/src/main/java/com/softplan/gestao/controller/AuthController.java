package com.softplan.gestao.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softplan.gestao.dto.EmailDTO;
import com.softplan.gestao.dto.PasswordDTO;
import com.softplan.gestao.security.JWTUtil;
import com.softplan.gestao.security.UserSS;
import com.softplan.gestao.service.AuthService;
import com.softplan.gestao.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	 @Autowired
	    private JWTUtil jwtUtil;

	    @Autowired
	    private AuthService authService;

	    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	    public ResponseEntity<Void> refreshToken (HttpServletResponse response) {
	        UserSS user = UserService.authenticated();
	        String token = jwtUtil.generateToken(user.getUsername());
	        response.addHeader("Authorization", "Bearer " + token);
	        response.addHeader("access-control-expose-headers", "Authorization");
	        return ResponseEntity.noContent().build();
	    }

	    @RequestMapping(value = "/esqueci_senha", method = RequestMethod.POST)
	    public ResponseEntity <PasswordDTO> forgotPassword (@Valid @RequestBody EmailDTO emailDTO) {
	        String newPassWord = authService.setNewPassword(emailDTO.getEmail());
	        PasswordDTO pass = new PasswordDTO();
	        pass.setLoginUsuario(emailDTO.getEmail());
	        pass.setPass(newPassWord);
	        return ResponseEntity.ok().body(pass);
	    }
}
