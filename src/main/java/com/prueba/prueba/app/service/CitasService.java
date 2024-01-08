package com.prueba.prueba.app.service;


import com.prueba.prueba.app.entity.Cita;
import com.prueba.prueba.app.exception.CitaInvalidException;
import com.prueba.prueba.app.model.ResponseModel;
import com.prueba.prueba.app.repository.CitasRepository;
import com.prueba.prueba.app.repository.ConsultoriosRepository;
import com.prueba.prueba.app.repository.DoctoresRepository;
import com.prueba.prueba.app.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CitasService {

    private final CitasRepository repository;
    private final DoctoresRepository doctoresRepository;

    private final ConsultoriosRepository consultoriosRepository;

    @Autowired
    public CitasService(CitasRepository repository,
                        DoctoresRepository doctoresRepository,
                        ConsultoriosRepository consultoriosRepository) {
        this.repository = repository;
        this.doctoresRepository = doctoresRepository;
        this.consultoriosRepository = consultoriosRepository;
    }

    //----------------Alta de citas--------------------------------


    public ResponseModel<Object> altaCita(Cita cita) throws Exception {
        //Valida reglas de aceptacion de cita
        validarCita(cita);

        return ResponseModel.builder()
                .status(true)
                .code(ResponseCode.CODE_000)
                .message(ResponseCode.CODE_001.getMessage())
                .data(repository.save(cita))
                .build();

    }

    private void validarCita(Cita cita) throws Exception {
        //No se puede agendar cita en un mismo consultorio a la misma hora.
        if(repository.existsByConsultorio_IdAndHorarioConsulta(cita.getConsultorio().getId(), cita.getHorarioConsulta())) {
            throw new CitaInvalidException(ResponseCode.CODE_001);
        }

        //No se puede agendar cita para un mismo Dr. a la misma hora.
        if(repository.existsByDoctor_IdAndHorarioConsulta(cita.getDoctor().getId(), cita.getHorarioConsulta())) {
            throw new CitaInvalidException(ResponseCode.CODE_002);
        }

        //Un mismo doctor no puede tener más de 8 citas en el día
        if (repository.countByDoctor_Id(cita.getDoctor().getId()) > 8) {
            throw new CitaInvalidException(ResponseCode.CODE_003);
        }

        /*No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas
        de diferencia para el mismo día. Es decir, si un paciente tiene 1 cita de 2 a 3pm, solo
        podría tener otra el mismo día a partir de las 5pm */

        Cita ultimaCitaPaciente = repository.findFirstByNombrePacienteOrderByHorarioFinComsultaDesc(cita.getNombrePaciente());

        if (ultimaCitaPaciente != null && ultimaCitaPaciente.getHorarioFinComsulta().isBefore(cita.getHorarioFinComsulta().plusHours(2))) {
            throw new CitaInvalidException(ResponseCode.CODE_004);
        }

    }


    //----------------Consulta de citas--------------------------------

    // Consulta de citas por fecha, consultorio y doctor
    public ResponseModel<Object> consultarCitas(LocalDateTime fecha, Long doctorId, Long consultorioId) {
        return ResponseModel.builder()
                .status(true)
                .code(ResponseCode.CODE_000)
                .message(ResponseCode.CODE_000.getMessage())
                .data(repository.findByHorarioConsultaAndDoctor_IdAndConsultorio_Id(fecha, doctorId, consultorioId))
                .build();
    }

    //Cancelar cita
    public ResponseModel<Object> cancelarCitas(Long idCita) throws Exception {
        Cita cita = repository.findById(idCita).orElse(null);

        if (cita == null) {
            throw new CitaInvalidException(ResponseCode.CODE_005);
        }

        LocalDateTime now = LocalDateTime.now();

        if (cita.getHorarioConsulta().isAfter(now)) {
            throw new CitaInvalidException(ResponseCode.CODE_006);
        }

        repository.deleteById(idCita);

        return ResponseModel.builder()
                .status(true)
                .code(ResponseCode.CODE_000)
                .message(ResponseCode.CODE_000.getMessage())
                .data(null)
                .build();

    }

    //Editar cita

    public ResponseModel<Object> editarCita(Cita cita) throws Exception {
        validarCita(cita);

        return ResponseModel.builder()
                .status(true)
                .code(ResponseCode.CODE_000)
                .message(ResponseCode.CODE_000.getMessage())
                .data(repository.save(cita))
                .build();
    }












}
