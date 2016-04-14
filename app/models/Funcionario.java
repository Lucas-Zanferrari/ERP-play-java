package models;

import javax.persistence.*;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by lucaszanferrari on 9/04/2016.
 */
@Entity
public class Funcionario extends Model {

    @Id
    private int id;
    @Constraints.Required
    private String nome;
    private Date data_nascimento;
    private int cpf;
    private String rg;
    private int carteira_trabalho;
    private String endereco;
    private int numero;
    private String bairro;
    private int cep;
    private Date data_contratacao;
    private String nivel_acesso;
    private String cargo;
    private float salario_base;
    @Constraints.Required
    private String usuario;
    @Constraints.Required
    private String senha;
    private String turno;

    public static Finder<String,Funcionario> find = new Finder<String,Funcionario>(
            String.class, Funcionario.class
    );

    public static List<Funcionario> list(){
        return find.all();
    }

    public static Funcionario authenticate(String usuario, String senha) {
        return find.where().eq("usuario", usuario)
                .eq("senha", senha).findUnique();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCarteira_trabalho() {
        return carteira_trabalho;
    }

    public void setCarteira_trabalho(int carteira_trabalho) {
        this.carteira_trabalho = carteira_trabalho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(float salario_base) {
        this.salario_base = salario_base;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
