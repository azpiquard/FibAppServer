package org.emc.rubicon.rest;

/**
 * Created for a Fibonacci Algorithm test on 3/15/2018
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.emc.rubicon.rest.entity.FibonacciResult;

@RestController
@Description("A controller for return fibonacci series")
public class FibonacciController {
    @Autowired
    private FibonacciService fibonacciService;

    @RequestMapping(value = "/fibonacci", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public FibonacciResult fibonacci(@RequestParam(value = "num", defaultValue = "1") String parm) {
            int num = Integer.valueOf(parm);
            return fibonacciService.fibonacci(num);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(Exception e) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            ErrorResponse response = new ErrorResponse("400", e.getMessage());
            json = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return new ResponseEntity<Object>(json + "\n", HttpStatus.BAD_REQUEST);
    }
}
