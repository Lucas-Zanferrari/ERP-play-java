package controllers;

import models.Comanda;
import models.Produto;
import models.ProdutoAdicionado;
import models.Venda;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.nova_comanda;
import views.html.comandas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ComandaController extends Controller {

    public static Result index(String id) {
        if(session().get("nome") ==null){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        if(id!=null) {
            comandaForm = comandaForm.fill(Comanda.byId(id));
        }else {
            Comanda comanda = new Comanda();
            comanda.setData_hora_abertura(new Date());
            List funcionarioResponsaveis = new ArrayList<>();
            comandaForm = comandaForm.fill(comanda);
        }
        return ok(index.render("", "", nova_comanda.render(comandaForm,"")));
    }

    public static Result create(String id){
        Form<Comanda> comandaForm = Form.form(Comanda.class);
        comandaForm = comandaForm.bindFromRequest();
        if (comandaForm.hasErrors()) {
            return badRequest(index.render("", "", nova_comanda.render(comandaForm, "")));
        } else {
            Comanda comandaObj = comandaForm.get();
            List<ProdutoAdicionado> produtos = comandaObj.getProdutos();
            for(Integer i=0;i<produtos.size();i++){
                ProdutoAdicionado produtoAdicionado = produtos.get(i);
                if(produtoAdicionado.getQuantidade()==0){
                    produtos.remove(produtoAdicionado);
                }
            }
            Double preco_total = produtos.stream().mapToDouble(produtoAdicionado ->
                    produtoAdicionado.getQuantidade() * Produto.byId(produtoAdicionado.getId().toString()).getPreco()
            ).sum();
            comandaObj.setPreco_total(preco_total);
            comandaObj.setProdutos(produtos);
            if(id.equals("0")) {
                comandaObj.setData_hora_abertura(new Date());
                comandaObj.save();
                return ok(index.render("", "", nova_comanda.render(comandaForm, "Comanda cadastrada com sucesso.")));
            }else{
                comandaObj.setId(Integer.valueOf(id));
                comandaObj.update();
                return ok(index.render("", "", nova_comanda.render(comandaForm, "Comanda atualizada com sucesso.")));
            }
        }
    }

    public static Result delete(String id){
        Comanda comanda = Comanda.byId(id);
        comanda.delete();
        return ok(index.render("", "", comandas.render(comanda.list(), "Comanda "+id+" removida com sucesso")));
    }

    public static Result list(){
        return ok(index.render("", "Comanda", comandas.render(Comanda.list(), "")));
    }

    public static Result finalizar(String id){
        Comanda comanda = Comanda.byId(id);
        Venda venda = new Venda();
        venda.setComanda(comanda);
        venda.setData_hora_encerramento(new Date());
        venda.save();
        comanda.delete();
        return ok(index.render("", "", comandas.render(comanda.list(), "Comanda "+id+" finalizada com sucesso")));
    }
}
