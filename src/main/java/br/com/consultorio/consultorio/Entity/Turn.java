package br.com.consultorio.consultorio.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "turns")
@Data
@NoArgsConstructor
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_turn_status")
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "id_diary")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    public Turn(TurnStatus turnStatus, Diary diary, Patient patient) {
        this.turnStatus = turnStatus;
        this.diary = diary;
        this.patient = patient;
    }
}
