package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucaszanferrari on 9/04/2016.
 */
@Entity
public class Comanda extends Model {
    private int cpf_cliente;
    private Date data_hora_encerramento;

    @Id
    private int id;
    @Constraints.Required
    private ArrayList<Produto> produtos;
    @Constraints.Required
    private ArrayList<Funcionario> funcionarios;
    @Constraints.Required
    private int qtd_produtos;
    @Constraints.Required
    private float preco_total;
    @Constraints.Required
    private Date data_hora_abertura;

    public static Finder<String, Comanda> find = new Finder<String, Comanda>(
            String.class, Comanda.class
    );

    public static List<Comanda> list(){
        return find.all();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCpf_cliente(int cpf_cliente){
        this.cpf_cliente = cpf_cliente;
    }

    public int getCpf_cliente(){
        return cpf_cliente;
    }

    public void setQtd_produtos(int qtd_produtos){
        this.qtd_produtos = qtd_produtos;
    }

    public int getQtd_produtos(){
        return qtd_produtos;
    }

    public void setPreco_total(float preco_total){
        this.preco_total = preco_total;
    }

    public float getPreco_total(){
        return preco_total;
    }

    public void setData_hora_abertura(Date data_hora_abertura){
        this.data_hora_abertura = data_hora_abertura;
    }

    public Date getData_hora_abertura(){
        return data_hora_abertura;
    }

    public void setData_hora_encerramento(Date data_hora_encerramento){
        this.data_hora_encerramento = data_hora_encerramento;
    }

    public Date getData_hora_encerramento(){
        return data_hora_encerramento;
    }
}