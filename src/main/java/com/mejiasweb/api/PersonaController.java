package com.mejiasweb.api;

import com.mejiasweb.model.Persona;
import com.mejiasweb.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {


@Autowired
private IPersonaService service;

   @GetMapping(value = "/listar", produces = "application/json")
   public ResponseEntity<List<Persona>> listar(){
       List<Persona> lista = new ArrayList<>();

       try {

         lista = service.listar();


       }
       catch (Exception ex){

           return new ResponseEntity<List<Persona>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);

       }

       return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);

   }


   @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id){

       Persona persona =  new Persona();


       try {

        persona = service.listarId(id);


       }
       catch (Exception ex){

          new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

       }

       return new ResponseEntity<Persona>(persona, HttpStatus.OK);

   }

   @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Integer> registrar (@RequestBody Persona persona){

       int resultado = 0;

       try {

        service.registrar(persona);
        resultado = 1;
       }
       catch (Exception ex){

          new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);

       }



       return  new ResponseEntity<Integer>(resultado, HttpStatus.OK);

   }


   @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Integer> actualizar (@RequestBody Persona persona){

       int resultado = 0;

       try {

        service.registrar(persona);
        resultado = 1;
       }
       catch (Exception ex){

        return  new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);

       }



       return  new ResponseEntity<Integer>(resultado, HttpStatus.OK);

   }



    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id){

       int resultado = 0;




        try {

           service.eliminar(id);
           resultado = 1;


        }
        catch (Exception ex){

            new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);

    }





}
