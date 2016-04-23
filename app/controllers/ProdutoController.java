package controllers;

import models.Produto;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.novo_produto;
import views.html.produtos;

/**
 * Created by dumorango on 4/11/16.
 */
public class ProdutoController extends Controller {

    public static Result index(String id) {
        if(session().get("nome") ==null){
            return redirect(
                    routes.Application.login()
            );
        }
        Form<Produto> produtoForm = Form.form(Produto.class);
        if(id!=null) produtoForm = produtoForm.fill(Produto.byId(id));
        return ok(index.render("", "", novo_produto.render(produtoForm,"")));
    }

    public static Result create(String id){
        Form<Produto> produtoForm = Form.form(Produto.class);
        produtoForm = produtoForm.bindFromRequest();
        if (produtoForm.hasErrors()) {
            return badRequest(index.render("", "", novo_produto.render(produtoForm, "")));
        } else {
            Produto produtoObj = produtoForm.get();
            if(id==null) {
                produtoObj.save();
                return ok(index.render("", "", novo_produto.render(produtoForm, "Produto cadastrado com sucesso.")));
            }else{
                produtoObj.setId(Integer.valueOf(id));
                produtoObj.update();
                return ok(index.render("", "", novo_produto.render(produtoForm, "Produto atualizado com sucesso.")));
            }
        }
    }

    public static Result delete(String id){
        Produto produto = Produto.byId(id);
        String name = produto.getNome();
        produto.delete();
        return ok(index.render("", "produto", produtos.render(produto.list(), "Produto "+name+" removido com sucesso")));
    }

    public static Result list(){
        return ok(index.render("", "produto", produtos.render(Produto.list(),null)));
    }
}
