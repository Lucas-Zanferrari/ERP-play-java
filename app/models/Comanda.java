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
public class Comanda extends Model {

    @Id
    private int id;
    @Constraints.Required
    private List<Produto> produtos;
    @Constraints.Required
    private List<String> funcionarios_responsaveis;
    @Constraints.Required
    private int cpf_cliente;
    @Constraints.Required
    private Date data_hora_abertura;
    @Constraints.Required
    private float preco_total;

    private Date data_hora_encerramento;

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

    public void setCpf_cliente(int cpf_cliente){
        this.cpf_cliente = cpf_cliente;
    }

    public int getCpf_cliente(){
        return cpf_cliente;
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

    public void setProdutos(List<Produto> produtos ){
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setFuncionarios_responsaveis(List<String> funcionarios_responsaveis){
        this.funcionarios_responsaveis = funcionarios_responsaveis;
    }

    public List<String> getFuncionarios_responsaveis(){
        return funcionarios_responsaveis;
    }
}