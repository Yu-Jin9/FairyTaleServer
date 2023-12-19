package com.fairytale.server.controller.papago;

import com.fairytale.server.model.papago.PapagoDto;
import com.fairytale.server.service.papago.PaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/server/papago")
public class PapagoController {

    @Autowired
    private PaPagoService papagoService;

    @PostMapping("/translate")
    public String translateText(@RequestBody String text) {
        return papagoService.translate(text);
    }
}
