package com.hbm.reserva;


import com.hbm.reserva.dao.ReservaDAO;
import com.hbm.reserva.dto.ReservaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
public class Controller {

    @GetMapping
    public void consultar() {
        ReservaDAO pd = new ReservaDAO();
        pd.consultaReserva();
    }

    @PostMapping
    public boolean cadastrar(@RequestBody ReservaDTO dados) {
        ReservaDAO pd = new ReservaDAO();
        return pd.insereReserva(dados);
    }

}
