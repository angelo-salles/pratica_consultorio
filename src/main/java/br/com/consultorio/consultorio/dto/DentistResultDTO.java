package br.com.consultorio.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistResultDTO {
  private Long id;
  private String name;
  private String lastName;
  private String address;
  private String dni;
  private LocalDate birthDate;
  private String phone;
  private String email;
  private String codeMp;
}
