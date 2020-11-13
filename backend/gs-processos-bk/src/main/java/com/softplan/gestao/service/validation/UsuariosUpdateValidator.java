package com.softplan.gestao.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import com.softplan.gestao.controller.exception.FieldMessage;
import com.softplan.gestao.dto.UsuariosDTO;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.repository.UsuariosRepository;

public class UsuariosUpdateValidator implements ConstraintValidator<UsuariosUpdate, UsuariosDTO> {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize (UsuariosUpdate ann) {

    }

    @Override
    public boolean isValid(UsuariosDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer idUsuarios = Integer.parseInt(map.get("idUsuarios"));


        Usuarios usuario = usuariosRepository.findByEmailNaoExcluido(objDto.getEmailUsuarios());
        if(usuario != null && !usuario.getIdUsuarios().equals(idUsuarios)) {
            list.add(new FieldMessage ("emailUsuarios", "Email já cadastrado"));
        }

        for(FieldMessage fm : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}
