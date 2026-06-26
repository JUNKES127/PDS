package model;

/**
 * Classe Model do usuário.
 * Apenas guarda os dados de um usuário cadastrado.
 * Não tem nenhuma lógica de negócio aqui.
 */
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String dataNascimento;
    private String escolaridade;
    private String experiencia;  // não obrigatório
    private String habilidades;

    public Usuario(String nome, String email, String senha, String telefone,
                   String dataNascimento, String escolaridade,
                   String experiencia, String habilidades) {
        this.nome         = nome;
        this.email        = email;
        this.senha        = senha;
        this.telefone     = telefone;
        this.dataNascimento = dataNascimento;
        this.escolaridade = escolaridade;
        this.experiencia  = experiencia;
        this.habilidades  = habilidades;
    }

    // --- Getters e Setters ---

    public String getNome()             { return nome; }
    public void   setNome(String nome)  { this.nome = nome; }

    public String getEmail()              { return email; }
    public void   setEmail(String email)  { this.email = email; }

    public String getSenha()              { return senha; }
    public void   setSenha(String senha)  { this.senha = senha; }

    public String getTelefone()                 { return telefone; }
    public void   setTelefone(String telefone)  { this.telefone = telefone; }

    public String getDataNascimento()                       { return dataNascimento; }
    public void   setDataNascimento(String dataNascimento)  { this.dataNascimento = dataNascimento; }

    public String getEscolaridade()                     { return escolaridade; }
    public void   setEscolaridade(String escolaridade)  { this.escolaridade = escolaridade; }

    public String getExperiencia()                    { return experiencia; }
    public void   setExperiencia(String experiencia)  { this.experiencia = experiencia; }

    public String getHabilidades()                    { return habilidades; }
    public void   setHabilidades(String habilidades)  { this.habilidades = habilidades; }
}
