package com.project.job.service.response;

/**
 * Author  : Creadted By Elhem NOURI
 **/

import com.project.job.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class Response {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss");

    @Value("")
    public ResponseEntity<ResponseDTO> successResponse(String message, Object data) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ResponseDTO responseDTO = ResponseDTO.builder()
                .date(sdf.format(timestamp))
                .status("200")
                .message(message)
                .data(data).build();
        return ResponseEntity.ok(responseDTO);
    }

    public ResponseEntity<ResponseDTO> errorResponse(String message, Object data) {

        ResponseDTO responseDTO = ResponseDTO.builder()
                .date("")
                .status("400")
                .message(message)
                .data(data).build();
        return ResponseEntity.ok(responseDTO);
    }

}
