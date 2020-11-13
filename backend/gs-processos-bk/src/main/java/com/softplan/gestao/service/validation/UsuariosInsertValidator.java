package com.softplan.gestao.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.softplan.gestao.controller.exception.FieldMessage;
import com.softplan.gestao.dto.UsuariosNewDTO;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.repository.UsuariosRepository;
import com.softplan.gestao.service.validation.utils.ValidationsBR;


public class UsuariosInsertValidator implements ConstraintValidator<UsuariosInsert,UsuariosNewDTO> {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public void initialize (UsuariosInsert ann) {

    }

    @Override
    public boolean isValid(UsuariosNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        Usuarios cli = usuariosRepository.findByEmailNaoExcluido(objDto.getEmailUsuarios());
        if(cli != null && !cli.getIdUsuarios().equals(objDto.getIdUsuarios())) {
            list.add(new FieldMessage ("emailUsuarios", "Email já cadastrado"));
        }

        if(objDto.getIdUsuarios() == null) {
            cli = usuariosRepository.findByCpfUsuariosNaoExcluidos(objDto.getCpfUsuarios());
            if (cli != null) {
                list.add(new FieldMessage("cpfUsuarios", "CPF já cadastrado"));
            }

            if (!ValidationsBR.isValidCPF(objDto.getCpfUsuarios())) {
                list.add(new FieldMessage("cpfUsuarios", "CPF inválido!"));
            }

        }

        for(FieldMessage fm : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fm.getMessage()).addPropertyNode(fm.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

}