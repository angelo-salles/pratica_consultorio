package br.com.consultorio.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryResultDTO {
  private LocalDateTime startDate;
  private LocalDateTime endingDate;
  private String dentistName;
  private String dentistCodeMP;
}
