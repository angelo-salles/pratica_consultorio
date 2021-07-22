package br.com.consultorio.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnResultDTO {
  private LocalDate date;
  private String status;
  private String dentistName;
  private String dentistCodeMP;
  private String patientName;
}
