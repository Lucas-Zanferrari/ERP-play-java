package controllers;

import models.Funcionario;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.novo_funcionario;
import views.html.index;
import views.html.funcionarios;

/**
 * Created by dumorango on 4/11/16.
 */
public class FuncionarioController extends Controller {

    public static Result index(String id) {
        if(session().isEmpty()){
            return redirect(
                    routes.Application.login()
            );
        }

        Form<Funcionario> userForm = Form.form(Funcionario.class);
        if(id!=null) userForm = userForm.fill(Funcionario.byId(id));

        return ok(index.render("", "", novo_funcionario.render(userForm, "")));
    }

    public static Result save(String id){
        Form<Funcionario> userForm = Form.form(Funcionario.class);
        userForm = userForm.bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(index.render("", "", novo_funcionario.render(userForm, "")));
        } else {
            Funcionario user = userForm.get();
            if(id==null){
                user.save();
                return ok(index.render("", "funcionário", funcionarios.render(Funcionario.list(), "Usuário cadastrado com sucesso")));
            }else{
                user.setId(Integer.valueOf(id));
                user.update();
                return ok(index.render("", "funcionário", funcionarios.render(Funcionario.list(), "Usuário atualizado com sucesso")));
            }

        }
    }

    public static Result delete(String id){
        Funcionario funcionario = Funcionario.byId(id);
        String name = funcionario.getNome();
        funcionario.delete();
        return ok(index.render("", "funcionário", funcionarios.render(Funcionario.list(), "Funcionário "+name+"removido com sucesso")));
    }

    public static Result list(){
        return ok(index.render("", "funcionário", funcionarios.render(Funcionario.list(), null)));
    }
}
