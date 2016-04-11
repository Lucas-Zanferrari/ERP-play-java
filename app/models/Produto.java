package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


/**
 * Created by lucaszanferrari on 9/04/2016.
 */
@Entity
public class Produto extends Model {

    @Id
    private int id;

    @Constraints.Required
    private String nome;

    private Date editado_em;
    private Funcionario editado_por;
    @Constraints.Required
    private int qtd_estoque;
    @Constraints.Required
    private String descricao;
    @Constraints.Required
    private float preco;


    public static Finder<String,Produto> find = new Finder<String,Produto>(
            String.class, Produto.class
    );

    public static List<Produto> list(){
        return find.all();
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

    public Date getEditado_em() {
        return editado_em;
    }

    public void setEditado_em(Date editado_em) {
        this.editado_em = editado_em;
    }

    public Funcionario getEditado_por() {
        return editado_por;
    }

    public void setEditado_por(Funcionario editado_por) {
        this.editado_por = editado_por;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
