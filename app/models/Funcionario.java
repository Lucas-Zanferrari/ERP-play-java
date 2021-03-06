package models;

import javax.persistence.*;

import play.data.validation.Constraints;
import com.avaje.ebean.Model;
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
    @Constraints.Required
    private String usuario;
    @Constraints.Required
    private String senha;
    @Constraints.Required
    private Date data_nascimento;
    @Constraints.Required
    private String cpf;
    @Constraints.Required
    private String rg;
    @Constraints.Required
    private String carteira_trabalho;
    @Constraints.Required
    private String endereco;
    @Constraints.Required
    private int numero;
    @Constraints.Required
    private String bairro;
    @Constraints.Required
    private String cep;
    @Constraints.Required
    private Date data_contratacao;
    @Constraints.Required
    private String nivel_acesso;
    @Constraints.Required
    private String cargo;
    @Constraints.Required
    private float salario_base;
    @Constraints.Required
    private String turno;
    @Constraints.Required
    private String telefone;

    public static Finder<String, Funcionario> find = new Finder<String, Funcionario>(
            String.class, Funcionario.class
    );

    public static List<Funcionario> list(){
        return find.all();
    }

    public static Funcionario authenticate(String usuario, String senha) {
        return find.where().eq("usuario", usuario)
                .eq("senha", senha).findUnique();
    }

    public static Funcionario byId(String id) {
        return find.byId(id);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCarteira_trabalho() {
        return carteira_trabalho;
    }

    public void setCarteira_trabalho(String carteira_trabalho) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
