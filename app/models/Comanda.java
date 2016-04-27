package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by lucaszanferrari on 9/04/2016.
 */
@Entity
public class Comanda extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private List<ProdutoAdicionado> produtos;

    private List<String> funcionarios_responsaveis;

    private String cpf_cliente;

    private Date data_hora_abertura;

    private double preco_total;

    public Comanda() {
        produtos = new ArrayList<>();
    }

    public static Finder<String, Comanda> find = new Finder<String, Comanda>(
            String.class, Comanda.class
    );


    public static Comanda byId(String id) {
        return find.byId(id);
    }

    public static List<Comanda> list(){
        return find.all();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCpf_cliente(String cpf_cliente){
        this.cpf_cliente = cpf_cliente;
    }

    public String getCpf_cliente(){
        return cpf_cliente;
    }

    public double getPreco_total(){
        return preco_total;
    }

    public void setData_hora_abertura(Date data_hora_abertura){
        this.data_hora_abertura = data_hora_abertura;
    }

    public Date getData_hora_abertura(){
        return data_hora_abertura;
    }

    public void setProdutos(List<ProdutoAdicionado> produtos ){
        this.produtos =  produtos;
    }

    public List<ProdutoAdicionado> getProdutos() {
        return produtos;
    }

    public void setFuncionarios_responsaveis(List<String> funcionarios_responsaveis){
        this.funcionarios_responsaveis = funcionarios_responsaveis;
    }

    public List<String> getFuncionarios_responsaveis(){
        return funcionarios_responsaveis;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }
}