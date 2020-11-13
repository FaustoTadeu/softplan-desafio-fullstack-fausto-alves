package com.softplan.gestao.enums;

public enum PerfilUsuario {

    ADMIN(1, "ROLE_ADMIN"),
    ATENDENTE(2, "ROLE_ATENDENTE");

    private Integer cod;
    private String nome;

    private PerfilUsuario(int codigo, String nome) {
        this.cod = codigo;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public static PerfilUsuario toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(PerfilUsuario x : PerfilUsuario.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("id inválido: " + cod);
    }

    public static String getEnumName (Integer value) {
        PerfilUsuario[] perfis = PerfilUsuario.values();
        for(PerfilUsuario pr: perfis) {
            if(value.equals(pr.cod)) {
                return pr.name();
            }
        }
        return "Erro. Perfil não encontrado.";
    }

}

