package com.prueba.prueba.app.controller;


import com.prueba.prueba.app.entity.Cita;
import com.prueba.prueba.app.model.ResponseModel;
import com.prueba.prueba.app.service.CitasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/citas")
public class CitasController {

    private final CitasService service;

    public CitasController(CitasService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ResponseModel<?>> crearCita(@RequestBody Cita cita) throws Exception {
        return ResponseEntity.ok(service.altaCita(cita));
    }


    @GetMapping
    public ResponseEntity<ResponseModel<?>> consultarCitas(@RequestParam LocalDateTime fecha, Long idDoctor, Long idConsultorio) {
        return ResponseEntity.ok(service.consultarCitas(fecha,idDoctor, idConsultorio));
    }

    @DeleteMapping("/id")
    public ResponseEntity<ResponseModel<?>> cancelarCita(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.cancelarCitas(id));
    }


    @PutMapping()
    public ResponseEntity<ResponseModel<?>> editarCita(@RequestBody Cita cita) throws Exception {
        return ResponseEntity.ok(service.editarCita(cita));
    }


}
