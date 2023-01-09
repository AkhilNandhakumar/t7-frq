package com.nighthawk.spring_portfolio.mvc.lightboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api/lightboard")
public class LightApiController {

    @GetMapping("/{row}/{col}")
    public ResponseEntity<String> LightBoard(@PathVariable("row") int row, @PathVariable("col") int col) throws JsonMappingException, JsonProcessingException {

      LightBoard test = new LightBoard(row, col);
  
      return ResponseEntity.ok(test.toString());  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/Tree/{row}/{col}")
    public ResponseEntity<JsonNode> getLightBoard(@PathVariable("row") int row, @PathVariable("col") int col) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      LightBoard test = new LightBoard(row, col);

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(test.toString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

}
