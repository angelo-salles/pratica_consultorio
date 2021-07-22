package br.com.consultorio.consultorio.dto;

import br.com.consultorio.consultorio.Entity.TurnStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnResultDTO {
  private LocalDate date;
  @Enumerated(value = EnumType.STRING)
  private TurnStatusEnum status;
  private String dentistName;
  private String dentistCodeMP;
  private String patientName;
}
