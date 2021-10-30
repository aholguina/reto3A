package mintic.reto3.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import mintic.reto3.Service.MessageService;
import mintic.reto3.Model.Message;


@RestController
@RequestMapping("/api/Message")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//Anotacion que responde peticiones desde cualquier lado
public class MessageController {
    
    @Autowired //Anotacion que inyecta todas las caracteristicas del objeto que se va a usar
    private MessageService messageService;

    @GetMapping("/all") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public List<Message> getMessages(){
        return messageService.getAll();
    }


    @GetMapping("/{id}") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public Optional<Message> getMessage(@PathVariable("id") int id){// toma como variable lo que llega en la ruta
        return messageService.getMessage(id);
    }

    @PostMapping("/save") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Message save(@RequestBody Message Message){ //hace una peticion para  que los parametros del json lleguen bien como un modelo
        return messageService.save(Message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Message update(@RequestBody Message Message){ //hace una peticion para   que los parametros del json lleguen bien como un modelo
        return messageService.update(Message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 201
    public String deleteMessage(@PathVariable("id") int id){
        messageService.deleteMessage(id);
        return "redirect:/";
    }
}
